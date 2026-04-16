import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int testCase = 0;
        StringBuilder sb = new StringBuilder();

        while(N != 0) {
            testCase++;

            int[][] graph = new int[N][3];
            int[][] dp = new int[N][3];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = 100_000_000;
                }
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 0행 초기 설정
            dp[0][0] = 100_000_000;
            dp[0][1] = graph[0][1];
            dp[0][2] = graph[0][1] + graph[0][2];

            // 1행부터 N-1행까지 동일한 규칙 적용
            for (int i = 1; i < N; i++) {
                // 0번 열: 위, 우상에서 옴
                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + graph[i][0];

                // 1번 열: 좌상, 상, 우상, 좌에서 옴
                int minFromAbove1 = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
                dp[i][1] = Math.min(minFromAbove1, dp[i][0]) + graph[i][1];

                // 2번 열: 좌상, 상, 좌에서 옴
                int minFromAbove2 = Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][2] = Math.min(minFromAbove2, dp[i][1]) + graph[i][2];
            }

            sb.append(testCase).append(". ").append(dp[N - 1][1]).append("\n");

            N = Integer.parseInt(br.readLine());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
