import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rpt = Integer.parseInt(br.readLine());
        final int DIVIDER = 1_000_000_009;
        int[] dp = new int[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (int) (((long) dp[i - 1] + dp[i - 2] + dp[i - 3]) % DIVIDER);
        }

        for (int i = 0; i < rpt; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
