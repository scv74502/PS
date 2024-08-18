import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N];
        int[] dp = new int[N + 1];

        for(int i = 0; i < N; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        if(N < 3){
            for(int i = 0; i < N; i++){
                answer += wines[i];
            }
        } else{
            dp[1] = wines[0];
            dp[2] = dp[1] + wines[1];
            for(int i = 3; i <= N; i++){
                // 3잔 기준으로 점화식을 세운다
                dp[i] = dp[i-3] + wines[i-1] + wines[i-2];    // 둘째잔, 셋째잔 마심
                dp[i] = Math.max(dp[i], dp[i-2] + wines[i-1]);    // 첫째잔, 지금잔 마심
                dp[i] = Math.max(dp[i], dp[i-1]);    // 첫째잔, 둘째잔 마심
            }
            answer = dp[N];
        }

        System.out.println(answer);
    }
}
