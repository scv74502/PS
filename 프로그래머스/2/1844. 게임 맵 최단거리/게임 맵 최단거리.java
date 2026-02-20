import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int N = maps.length;
        int M = maps[0].length;        
        boolean[][] visited = new boolean[N][M];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0, 1}); // r, c, 지난 칸수
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int cr = queue.peek()[0];
            int cc = queue.peek()[1];
            int cBlock = queue.peek()[2];
            queue.poll();
            
            if(cr == N - 1 && cc == M - 1){
                return cBlock;
            }
            
            for(int d = 0; d < 4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(nr < 0 || N <= nr || nc < 0 || M <= nc || visited[nr][nc] || maps[nr][nc] == 0) continue;
                queue.add(new int[] {nr, nc, cBlock + 1});
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}