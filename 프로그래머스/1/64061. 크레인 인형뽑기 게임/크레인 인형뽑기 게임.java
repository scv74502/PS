import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        
        Stack<Integer>[] lines = new Stack[N + 1];
        Stack<Integer> basket = new Stack<>();
        
        int answer = 0;
        
        for(int i = 0; i < N; i++){
            lines[i + 1] = new Stack<>();
            for(int j = N - 1; j >= 0; j--){                
                if(board[j][i] == 0) break;
                lines[i + 1].add(board[j][i]);
            }            
        }
        
        for(int move:moves){
            if(lines[move].isEmpty()) continue;
            int curNum = lines[move].pop();
            
            if(!basket.isEmpty() && basket.peek() == curNum){
                answer += 2;
                basket.pop();
            } else{
                basket.push(curNum);
            }
        }
        
        return answer;
    }
}