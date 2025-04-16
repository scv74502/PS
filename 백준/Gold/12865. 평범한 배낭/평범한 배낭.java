import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        ipts = br.readLine().split(" ");
        int N = Integer.parseInt(ipts[0]);
        int K = Integer.parseInt(ipts[1]);

        int[] productWeights = new int[N];
        int[] productValues = new int[N];

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            productWeights[i] = Integer.parseInt(ipts[0]);
            productValues[i] = Integer.parseInt(ipts[1]);
        }

        // N개를 선택하며 K 무게만큼 담는 최대 가치
        int[][] dp = new int[N+1][K+1];
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int weight = productWeights[i-1];
            int value = productValues[i-1];

            for (int j = 1; j <= K; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);

                if(j >= weight){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight] + value);
                    answer = Math.max(answer, dp[i][j]);                }
            }
        }

        System.out.println(answer);
    }
}
