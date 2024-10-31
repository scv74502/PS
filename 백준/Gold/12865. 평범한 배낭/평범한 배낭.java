import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        ipts = br.readLine().split(" ");
        int N = Integer.parseInt(ipts[0]);
        int K = Integer.parseInt(ipts[1]);

        int[] weights = new int[N+1];
        int[] values = new int[N+1];

        for (int i = 1; i <= N; i++) {
            ipts = br.readLine().split(" ");
            // 무게와 가치
            weights[i] = Integer.parseInt(ipts[0]);
            values[i] = Integer.parseInt(ipts[1]);
        }

        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // i번 물건을 넣지 않는 경우에는, i-1번째 최대 무게를 가져옴
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);

                if(j >= weights[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
