import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        // dp[i][j]는 길이가 i고 끝 숫자가 j인 계단수의 개수이다.
        long[][] dp = new long[101][10];


        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            dp[i][0] = dp[i-1][1] % 1000000000;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            dp[i][9] = dp[i-1][8] % 1000000000;
        }



        int N = Integer.parseInt(br.readLine());
        long ans = 0;

        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[N][i]) % 1000000000;
        }
        System.out.println((ans % 1000000000));
    }
}
