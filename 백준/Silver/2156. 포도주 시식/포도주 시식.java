import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];

        if(N < 3){
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += wines[i];
            }
            System.out.println(sum);
            return;
        }

        for (int i = 1; i <= 2; i++) {
            dp[i] = dp[i - 1] + wines[i];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 3] + wines[i-1] +wines[i]);
            dp[i] = Math.max(dp[i], dp[i - 2] + wines[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[N]);
    }
}