import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        ipts = br.readLine().split(" ");
        int V = Integer.parseInt(ipts[0]);
        int N = Integer.parseInt(ipts[1]);

        int[] coins = new int[V];
        long[] dp = new long[N+1];

        for (int i = 0; i < V; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        dp[0] = 1;

        for(int coin:coins){
            for (int i = coin; i <= N; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[N]);
    }
}
