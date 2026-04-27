import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        final int DIVIDER = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        Arrays.sort(money);
        
        for(int i = 0; i < money.length; i++){
            int curMoney = money[i];
            for(int j = curMoney; j <= n; j++){
                dp[j] = (dp[j] + dp[j - curMoney]) % DIVIDER;
            }
        }
                      
        return dp[n];
    }
}