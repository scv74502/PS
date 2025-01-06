import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[5001];

        final long MOD = 1000000007L;

        dp[0] = 1;
        dp[2] = 1;

        for (int i = 2; i < 2501; i++) {
            for (int j = 0; j < i; j++) {
                dp[i * 2] += dp[j * 2] * dp[(i - j - 1) * 2];
                dp[i * 2] %= MOD;
            }
        }

        for (int i = 0; i < N; i++) {
            int tgt = Integer.parseInt(br.readLine());
            System.out.println(dp[tgt]);
        }
    }
}
