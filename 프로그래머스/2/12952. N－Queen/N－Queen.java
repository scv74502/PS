class Solution {
    private int answer = 0;
    public int solution(int n) {        
        int[] col = new int[n];                                        
        bt(0, col);
        
        return answer;
    }
    
    public void bt(int row, int[] col){
        if(row == col.length){
            answer++;
            return;
        }
        
        for(int i = 0; i < col.length; i++){
            col[row] = i;
            if(isAvailable(row, col)){                
                bt(row+1, col);
            }
        }
    }
    
    public boolean isAvailable(int idx, int[] col){
        int cur = 0;        
        for(int i = 0; i < idx; i++){
            // 해당 열에 이미 퀸이 있거나, 행의 차이와 열의 차이가 같은지 확인하여 대각선 체크시 같은 대각선이면
            if(col[i] == col[idx] || Math.abs(idx - i) == Math.abs(col[idx] - col[i])) return false;
        }        
        return true;
    }        
}