import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX_BALL_WEIGHT = 40_000;
        final int MAX_BELL_WEIGHT = 500;

        int N = Integer.parseInt(br.readLine());    // 추의 개수
        int[] bellWeights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bellWeights[i] = Integer.parseInt(st.nextToken());
        }

        int ballsAmount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] balls = new int[ballsAmount];

        int maxBallWeight = Integer.MIN_VALUE;

        for (int i = 0; i < ballsAmount; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
            maxBallWeight = Math.max(balls[i], maxBallWeight);
        }

        boolean[] dp = new boolean[MAX_BALL_WEIGHT + 1];
        dp[0] = true;

        for (int i = 1; i <= N; i++) {
            int bellWeight = bellWeights[i-1];
            for (int j = MAX_BALL_WEIGHT; j >= 0; j--) {
                if(dp[j]){
                    dp[j + bellWeight] = true;
                }
            }

            for (int j = 0; j <= MAX_BALL_WEIGHT; j++) {
                if(dp[j]){
                    dp[Math.abs(bellWeight - j)] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int ball:balls){
            sb.append(dp[ball] ? "Y" : "N");
            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
