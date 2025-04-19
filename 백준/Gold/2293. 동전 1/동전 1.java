import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N+1][K+1];
        dp[0][0] = 1;   // 0원을 만드는 법은 1가지

        for (int i = 1; i <= N; i++) {
            int coin = coins[i-1];  // 현재 동전의 금액
            dp[i][0] = 1;

            for (int j = 0; j <= K; j++) {
                dp[i][j] = dp[i-1][j];  // i개째 동전을 고르지 않더라도 i-1개로 만든 j원 가짓수는 유지된다

                if(j >= coin){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j] + dp[i][j-coin]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
