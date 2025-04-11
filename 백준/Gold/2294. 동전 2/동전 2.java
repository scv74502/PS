import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        for (int coin:coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
            }
        }

        System.out.println(dp[k] == k+1 ? -1 : dp[k]);
    }
}
