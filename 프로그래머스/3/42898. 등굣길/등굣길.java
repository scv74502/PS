import java.util.*;

class Solution{
    public int solution(int m, int n, int[][] puddles){
        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        
        // for(int[] arr:dp){
        //     Arrays.fill(arr, Integer.MAX_VALUE);
        // }
        
        for(int[] puddle:puddles){
            map[puddle[1]][puddle[0]] = -1;
        }                
        
        dp[1][1] = 1;                        
        
        
//         for(int i = 1; i <= n; i++){
//             for(int j = 1; j <= m; j++){
//                 if(map[i-1][j] != -1 && map[i][j-1] == -1){
//                     if(map[i][j] != -1){
//                         dp[i][j] += dp[i-1][j];
//                     }
//                 }
                
//                 else if(map[i][j-1] != -1 && map[i-1][j] == -1){
//                     if(map[i][j] != -1){
//                         dp[i][j] += dp[i][j-1];
//                     }
//                 }
                
//                 else{
//                     if(map[i][j] != -1){
//                         dp[i][j] += dp[i-1][j] + dp[i][j-1];
//                     }
//                 }
//             }
//         }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] != -1){
                    dp[i][j] += (dp[i-1][j] + dp[i][j-1])  % 1000000007;
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }
}