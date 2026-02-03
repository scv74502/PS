class Solution {
    int answer = -1;
    public int solution(int[] mats, String[][] park) {
        for(int mat: mats){
            int N = park.length;
            int M = park[0].length;

            for(int i = 0; i <= N - mat; i++){
                for(int j = 0; j <= M - mat; j++){
                    if(checkAvailable(mat, park, i, j)) {
                        answer = Math.max(mat, answer);
                        continue;
                    }
                }    
            }            
        }
        return answer;
    }
    
    public boolean checkAvailable(int mat, String[][] park, int startR, int startC){
        int N = park.length;
        int M = park[0].length;
                        
        for(int i = startR; i < startR + mat; i++){
            for(int j = startC; j < startC + mat; j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        
        return true;
    }
}