import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] vip = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            vip[Integer.parseInt(br.readLine())] = true;
        }

        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        long answer = 1;
        int seats = 0;

        for (int i = 1; i <= N; i++) {
            if (vip[i]) {
                answer *= dp[seats];
                seats = 0;
            } else {
                seats++;
            }
        }
        answer *= dp[seats];

        System.out.println(answer);
    }
}

