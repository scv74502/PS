import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        final int DIVIDER = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int cur:money){
            for(int i = cur; i <= n; i++){
                dp[i] += dp[i - cur];
            }
        }
        
        return dp[n];
    }
}