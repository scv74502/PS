import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dc = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[N][M][3];
        int[][] space = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], 100000);
            }
        }

        for (int j = 0; j < M; j++) {
            for (int dir = 0; dir < 3; dir++) {
                dp[0][j][dir] = space[0][j];
            }
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dir = 0; dir < 3; dir++) { // 현재 위치로 오는 방향
                    int prevCol = j - dc[dir]; // 이전 열 위치

                    // 범위를 벗어나는 경우 스킵
                    if (prevCol < 0 || prevCol >= M) continue;

                    for (int prevDir = 0; prevDir < 3; prevDir++) { // 이전 위치에서의 방향
                        // 같은 방향으로 연속해서 이동할 수 없음
                        if (prevDir == dir) continue;

                        dp[i][j][dir] = Math.min(dp[i][j][dir], dp[i-1][prevCol][prevDir] + space[i][j]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(dp[N-1][i][j], answer);
            }
        }

        System.out.println(answer);
    }
}
