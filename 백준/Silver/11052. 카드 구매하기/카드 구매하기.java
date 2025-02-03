import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int[] cardPacks = new int[N+1];
        ipts = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            cardPacks[i+1] = Integer.parseInt(ipts[i]);
        }

        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                dp[j + i] = Math.max(dp[j+i], dp[j] + cardPacks[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
