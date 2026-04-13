import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int DIVIDER = 1_000_000_000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // k열의 n행 -> k개의 수를 더해서 n이 되는 가지수
        int[][] dp = new int[K+1][N+1];
        for (int i = 0; i <= K; i++) dp[i][0] = 1;
        for (int j = 0; j <= N; j++) dp[1][j] = 1;

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % DIVIDER;
            }
        }
        
        System.out.println(dp[K][N]);
    }
}
