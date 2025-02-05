import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        int mod = 1_000_000_009;

        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i < 100001; i++) {
            dp[i][1] += (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] += (dp[i-2][1] + dp[i-2][3]) % mod;
            dp[i][3] += (dp[i-3][1] + dp[i-3][2]) % mod;
        }

        for (int rpt = 0; rpt < testCase; rpt++) {
            int N = Integer.parseInt(br.readLine());
            sb.append((dp[N][1] + dp[N][2] + dp[N][3]) % mod);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
