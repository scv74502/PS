import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] expectedTimes = new int[N];
        int[] expectedScores = new int[N];

        // dp[i][j] -> i개 과목 j시간을 공부시 최대 점수
        int[][] dp = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            expectedTimes[i] = Integer.parseInt(st.nextToken());
            expectedScores[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int expectedTime = expectedTimes[i-1];
            int expectedScore = expectedScores[i - 1];

            for (int j = 1; j <= M; j++) {
                // i개 과목 j시간 공부시, i-1개 과목의 j시간 공부할 때 점수는 보장됨
                dp[i][j] = dp[i-1][j];

                if(j >= expectedTime){
                    // i-1개 과목의 j시간 공부할 때 점수, i-1개 과목에서 현재과목 학습시간 뺀 만큼 공부했을 때 + 현재 과목 예상점수 중 큰 값
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-expectedTime] + expectedScore);
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
