import java.io.*;
import java.util.*;

public class Main {
    static int[][] stickers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int repeat = 0; repeat < tc; repeat++) {
            int N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];

            for (int i = 0; i < 2; i++) {
                String[] ipts = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    stickers[i][j] = Integer.parseInt(ipts[j]);
                }
            }

            int[][] dp = new int[2][N];

            if(N == 1){
                sb.append(Math.max(stickers[0][0], stickers[1][0]));
                sb.append("\n");
                continue;
            } else if (N == 2) {
                sb.append(Math.max(stickers[0][0] + stickers[1][1], stickers[1][0] + stickers[0][1]));
                sb.append("\n");
            } else{
                dp[0][0] = stickers[0][0];
                dp[1][0] = stickers[1][0];

                dp[0][1] = dp[1][0] + stickers[0][1];
                dp[1][1] = dp[0][0] + stickers[1][1];

                for (int i = 2; i < N; i++) {
                    dp[0][i] = Math.max(dp[1][i-1] + stickers[0][i], dp[1][i-2] + stickers[0][i]);
                    dp[1][i] = Math.max(dp[0][i-1] + stickers[1][i], dp[0][i-2] + stickers[1][i]);
                }

                sb.append(Math.max(dp[0][N-1], dp[1][N-1]));
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}