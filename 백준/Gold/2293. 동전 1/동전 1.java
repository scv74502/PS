import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[K+1];
        dp[0] = 1;   // 0원을 만드는 법은 1가지
        
        for (int i = 0; i < N; i++) {
            int coin = coins[i];  // 현재 동전의 금액
            for (int j = coin; j <= K; j++) {
                dp[j] += dp[j-coin];  // 현재 동전을 사용하여 j원을 만드는 경우의 수 추가
            }
        }
        System.out.println(dp[K]);
    }
}