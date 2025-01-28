import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        ipts = br.readLine().split(" ");
        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);

        int[][] bookInfo = new int[M+1][2];

        for (int i = 1; i <= M; i++) {
            ipts = br.readLine().split(" ");
            bookInfo[i][0] = Integer.parseInt(ipts[0]);
            bookInfo[i][1] = Integer.parseInt(ipts[1]);
        }

        // dp[i][j]는 i개 챕터를 j일까지 읽을 수 있는 최대 페이지 수
        int[][] dp = new int[M+1][N+1];

        for (int i = 1; i <= M; i++) {
            int dayToRead = bookInfo[i][0];
            int pagePerDay = bookInfo[i][1];

            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= dayToRead){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-dayToRead] + pagePerDay);
                }
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[M][N]);
    }
}
