import java.io.*;

public class Main {
    static final long MOD = 1000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        // dp[i][j][k] -> 길이가 i이고 끝이 j이며 비트 형태의 k는 방문했던 수를 체크함
        long[][][] dp = new long[N+1][10][1 << 10];

        // 한 자리의 계단수 체크
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1 << 10; k++) {
                    // 자리수가 1보다 크다면 j-1에서 도착한 경우의 수를 고려하고, 현재 숫자의 비트를 켜서 방문 기록에 추가
                    if(j >= 1){
                        dp[i][j][k | (1 << j)] += dp[i-1][j-1][k];
                    }
                    if(j <= 8){
                        // 자리수가 9보다 작다면 j+1에서 도착한 경우의 수를 고려하고, 현재 숫자의 비트를 켜서 방문 기록에 추가
                        dp[i][j][k | (1 << j)] += dp[i-1][j+1][k];
                    }
                    dp[i][j][k | (1 << j)] %= MOD;
                }
            }
        }
        
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i][(1 << 10) - 1];
            answer %= MOD;
        }

        System.out.println(answer);
    }
}
