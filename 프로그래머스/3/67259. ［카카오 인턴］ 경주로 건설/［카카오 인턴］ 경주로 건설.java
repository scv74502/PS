import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] priceArr = new int[N][N][4];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(priceArr[i][j], Integer.MAX_VALUE);
            }                    
        }                
        
        for(int i = 0; i < 4; i++){
            priceArr[0][0][i] = 0;
        }                    
        
        Deque<int[]> deque = new ArrayDeque<>();
        // r, c, price, direction        
        deque.add(new int[] {0, 0, 0, 0});
        deque.add(new int[] {0, 0, 0, 2});
        
        while(!deque.isEmpty()){
            int cr = deque.peek()[0];
            int cc = deque.peek()[1];
            int curPrice = deque.peek()[2];
            int curDirection = deque.peek()[3];
            deque.poll();
            
            if(cr == N - 1 && cc == N - 1){
                priceArr[N-1][N-1][curDirection] = Math.min(priceArr[N-1][N-1][curDirection], curPrice);
                continue;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];            
                
                if(nr < 0 || N <= nr || nc < 0 || N <= nc || board[nr][nc] == 1) continue;
                                
                if((d < 2 && (curDirection == 0 || curDirection == 1)) || (2 <= d && (curDirection == 2 || curDirection == 3))){
                    int nextPrice = curPrice + 100;
                    if(nextPrice <= priceArr[nr][nc][d]){
                        priceArr[nr][nc][d] = nextPrice;
                        deque.add(new int[] {nr, nc, nextPrice, d});
                    }
                } else {
                    int nextPrice = curPrice + 600;
                    if(nextPrice <= priceArr[nr][nc][d]){
                        priceArr[nr][nc][d] = nextPrice;                        
                        deque.add(new int[] {nr, nc, nextPrice, d});
                    }
                }
            }                    
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < 4; i++){
            answer = Math.min(priceArr[N-1][N-1][i], answer);
        }
        
        return answer;
    }
}