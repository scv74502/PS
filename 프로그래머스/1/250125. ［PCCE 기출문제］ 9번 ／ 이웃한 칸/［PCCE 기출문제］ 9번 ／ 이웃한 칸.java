class Solution {
    public int solution(String[][] board, int h, int w) {
        int N = board.length;                
        int answer = 0;
        
        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        
        for(int i = 0; i <= 3; i++){
            int h_chk = h + dh[i];
            int w_chk = w + dw[i];
            
            if(0 <= h_chk && h_chk < N && 0 <= w_chk && w_chk < N){
                if(board[h][w].equals(board[h_chk][w_chk])) answer += 1;   
            }
        }
        
        return answer;
    }
}