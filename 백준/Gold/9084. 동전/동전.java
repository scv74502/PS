import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer =  new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(stringTokenizer.nextToken());

        for (int rpt = 0; rpt < TC; rpt++) {
            int N = Integer.parseInt(br.readLine());
            stringTokenizer =  new StringTokenizer(br.readLine());

            int[] coins = new int[N];

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[][] dp = new int[N+1][M+1];

            for (int i = 1; i <= N; i++) {
                int coin = coins[i-1];
                // 0원을 만들 수 있는 방법은 1개이다.
                dp[i][0] = 1;

                for (int j = 1; j <= M; j++) {
                    dp[i][j] = dp[i-1][j];

                    if(j >= coin){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-coin] + dp[i-1][j]);
                    }
                }

            }
            System.out.println(dp[N][M]);
        }
    }
}