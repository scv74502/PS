import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 오른쪽, 아래
        int[] dr = {0, 1};
        int[] dc = {1, 0};

        int[][] board = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            String[] ipt = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(ipt[j]);
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 도달할 수 없거나 종착점인 경우 스킵
                if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) continue;

                int range = board[i][j];

                // 오른쪽 이동
                if (j + range < N) dp[i][j + range] += dp[i][j];
                // 아래 이동
                if (i + range < N) dp[i + range][j] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
