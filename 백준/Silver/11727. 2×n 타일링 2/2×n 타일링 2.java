import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(N+1, 3)];
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        System.out.println(dp[N]);
    }
}
