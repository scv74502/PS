import java.io.*;
import java.util.*;

public class Main {
    // 아래, 왼쪽, 오른쪽
    static int[] dr = {-1, 0, 0};
    static int[] dc = {0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] leftToRight = new int[M];
        int[] rightToLeft = new int[M];
        int[][] dp = new  int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 첫 줄 업데이트
        for (int i = 1; i < M; i++) {
            dp[0][i] += dp[0][i - 1];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                leftToRight[j] = dp[i][j];
                rightToLeft[j] = dp[i][j];
            }

            // 우측으로 이동
            for (int j = 0; j < M; j++) {
                if(j == 0) leftToRight[j] += dp[i - 1][j];
                else leftToRight[j] += Math.max(dp[i - 1][j], leftToRight[j - 1]);
            }

            // 좌측으로 이동
            for (int j = M - 1; j >= 0; j--) {
                if(j == M - 1) rightToLeft[j] += dp[i - 1][j];
                else rightToLeft[j] += Math.max(dp[i - 1][j], rightToLeft[j + 1]);
            }

            // 최대값 갱신
            for(int j = 0; j < M; j++) {
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}