import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int[][] numbers = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                numbers[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        if(N == 1){
            System.out.println(numbers[0][0]);
        } else{
            dp[0][0] = numbers[0][0];

            for (int i = 0; i < N-1; i++) {
                for (int j = 0; j <= i; j++) {
                    for (int k = 0; k < 2; k++) {
                        dp[i + 1][j + k] = Math.max(dp[i + 1][j + k], dp[i][j] + numbers[i + 1][j + k]);
                    }
                }
            }

            int answer = -1;
            for (int i = 0; i < N; i++) {
                answer = Math.max(answer, dp[N-1][i]);
            }
            System.out.println(answer);
        }
    }
}
