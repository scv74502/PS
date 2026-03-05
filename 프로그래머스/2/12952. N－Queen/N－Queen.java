import java.util.*;

class Solution {
    int answer = 0;
    int[] col;  // col[row] = row행의 열 값
    public int solution(int n) {        
        col = new int[n];        
        bt(n, 0);
        return answer;
    }
    
    public void bt(int n, int row){
        if(row == n){
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            col[row] = i;
            if (isPossible(row)) {
                bt(n, row + 1);
            }
        }
    }
    
    public boolean isPossible(int row){
        for(int i = 0; i < row; i++){
            if(col[i] == col[row]) return false;            
            if(Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        return true;
    }
}