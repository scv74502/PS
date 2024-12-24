import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        int rpt = Integer.parseInt(br.readLine());
        int N, M;
        int[][] dp = dp = new int[31][31];

        for (int i = 0; i <= 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j <= 30; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for (int rr = 0; rr < rpt; rr++) {
            ipts = br.readLine().split(" ");
            N = Integer.parseInt(ipts[0]);
            M = Integer.parseInt(ipts[1]);


            bw.write(dp[M][N] + "\n");
        }

        bw.flush();
    }

    public static int combination(){
        return 1;
    }
}
