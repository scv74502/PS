import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = N;
        dp[1] = dp[0] - 1;
        int answer = 0;

        if(N == 1){
            bw.write("SK");
        }
        else if(N == 2){
            dp[2] = dp[1] - 1;
            bw.write("CY");
        } else if(N >= 3){
            dp[2] = dp[1] - 1;
            for(int i = 3; i <= N; i++){
                if(dp[i-1] % 2 == 0){
                    dp[i] = dp[i-1] - 1;
                } else if(dp[i-1] >= 3){
                    dp[i] = dp[i-1] - 3;
                } else{
                    dp[i] = dp[i-1] - 1;
                }

                if(dp[i] == 0){
                    answer = i;
                    break;
                }
            }
            if(answer % 2 == 0){
                bw.write("CY");
            } else{
                bw.write("SK");
            }
        }

        bw.write("\n");
        bw.flush();
    }
}
