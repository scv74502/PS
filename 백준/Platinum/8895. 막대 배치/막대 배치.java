import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        int tc = Integer.parseInt(br.readLine());

        long[][][] dp = new long[21][21][21];
        dp[1][1][1] = 1;

        // 새 stick이 가장 작은 막대를 새로 놓으면
        // 1. 가장 왼쪽에 놓는 경우
        // 2. 가장 오른쪽에 놓는 경우
        // 3. 막대의 사이 중 하나를 골라 넣는 경우이므로 dp[stick][l][r] += (dp[stick-1][l][r]) * (stick - 1 -1)
        for (int i = 2; i <= 20; i++) {
            for (int l = 1; l <= i; l++) {
                for (int r = 1; r <= i; r++) {
                    dp[i][l][r] += dp[i-1][l-1][r] + dp[i-1][l][r-1] + (dp[i-1][l][r] * (i - 2));
                }
            }
        }


        long answer = 0;
        int n, left, right;
        for (int RPT = 0; RPT < tc; RPT++) {
            ipts = br.readLine().split(" ");
            n = Integer.parseInt(ipts[0]);
            left = Integer.parseInt(ipts[1]);
            right = Integer.parseInt(ipts[2]);

            System.out.println(dp[n][left][right]);
        }
    }
}
