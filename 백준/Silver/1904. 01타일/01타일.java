import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        // 길이 1인 이진수열은 1, 길이 2인 이진수열은 00, 11
        dp[0] = 0;
        dp[1] = 1;
        
        if(N > 1){
            dp[2] = 2;
        }

        if(N >= 3){
            for(int i = 3; i <= N; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 15746;
            }
        }

        bw.write(dp[N] + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
