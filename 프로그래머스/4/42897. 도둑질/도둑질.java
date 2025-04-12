import java.util.*;

class Solution {
    public int solution(int[] money) {
        int houses = money.length;            
        // dp[i][0]은 처음 집부터 시작한 i번째 집
        // dp[i][1]은 처음 집부터 시작하지 않은 i번째 집
        int[] dp1 = new int[houses];
        int[] dp2 = new int[houses];
        
        dp1[0] = money[0];        
        dp1[1] = Math.max(money[0], money[1]);
        dp2[1] = money[1];
                
        for(int j = 2; j < houses - 1; j++){                
            dp1[j] = Math.max(dp1[j-1], dp1[j-2] + money[j]);
        }
        
        for(int j = 2; j < houses; j++){                
            dp2[j] = Math.max(dp2[j-1], dp2[j-2] + money[j]);
        }                
        
        return Math.max(dp1[houses-2], dp2[houses-1]);
    }
}
