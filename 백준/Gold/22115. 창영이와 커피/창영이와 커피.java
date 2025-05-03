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

        int[] caffeineArray = new int[N];

        st = new StringTokenizer(br.readLine());
        int[][] dp = new int[N+1][K+1];

        int MAX_CAFFEINE = 1000000;
        Arrays.fill(dp[0], MAX_CAFFEINE);
        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            caffeineArray[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i+1], MAX_CAFFEINE);
            dp[i+1][0] = 0;
        }

        for (int i = 1; i <= N; i++) {
            int caffeine = caffeineArray[i-1];

            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= caffeine){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-caffeine] + 1);
                }
            }
        }

        System.out.println(dp[N][K] == MAX_CAFFEINE ? -1 : dp[N][K]);
    }
}
