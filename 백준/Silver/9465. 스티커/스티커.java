import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] stickers;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int repeat = 0; repeat < tc; repeat++) {
            int N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];
            dp = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            if(N > 1){
                dp[0][1] = stickers[1][0] + stickers[0][1];
                dp[1][1] = stickers[0][0] + stickers[1][1];
            }

            int answer = -1;

            // 전 칸 대각선 스티커를 떼는 경우
            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1] + stickers[0][i], dp[1][i - 2] + stickers[0][i]);
                dp[1][i] = Math.max(dp[0][i - 1] + stickers[1][i], dp[0][i - 2] + stickers[1][i]);
            }

            answer = Math.max(dp[0][N-1], dp[1][N-1]);

            System.out.println(answer);
        }
    }
}