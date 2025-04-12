import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int maxChance = Math.max(n, m);
        boolean[][][] dp = new boolean[info.length + 1][n][m];
        dp[0][0][0] = true;
        
        int aAdd = 0;
        int bAdd = 0;
        
        for(int i = 0; i < info.length; i++){                        
            aAdd = info[i][0];
            bAdd = info[i][1];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(!dp[i][j][k]) continue;
                    
                    int nextA = j + aAdd;
                    int nextB = k + bAdd;
                    
                    if(nextA < n){
                        dp[i+1][nextA][k] = true;
                    }
                    
                    if(nextB < m){
                        dp[i+1][j][nextB] = true;
                    }
                }                
            }            
        }
                
        // System.out.println(Arrays.deepToString(dp));
        
        for(int j = 0; j < n; j++){
            for(int k = 0; k < m; k++){
                if(dp[info.length][j][k]){
                    return j;
                }
            }
        }
                        
        return -1;
    }
}