import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        for (int RPT = 0; RPT < TC; RPT++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[][] dp = new int[N+1][M+1];

            for (int i = 1; i <= N; i++) {
                int coin = coins[i-1];
                dp[i][0] = 1;

                for (int j = 1; j <= M; j++) {
                    dp[i][j] = dp[i-1][j];

                    if(j >= coin){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j] + dp[i][j-coin]);
                    }
                }
            }

            System.out.println(dp[N][M]);
        }
    }
}
