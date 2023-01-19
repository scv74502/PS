import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;
        int n = Integer.parseInt(br.readLine());
        ipt = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i=  0; i < n; i++){
            nums[i] = Integer.parseInt(ipt[i]);
        }
        int tgt = Integer.parseInt(ipt[n-1]);
        long [][] dp = new long[n][21];
        dp[0][nums[0]] = 1;
        for(int i = 1; i < n-1; i++){
            for(int j = 0; j < 21; j++){
                if(dp[i-1][j] != 0){
                    int plus = j + nums[i];
                    int minus = j - nums[i];
                    if(0 <= plus && plus<= 20){
                        dp[i][plus] += dp[i-1][j];
                    }
                    if(0 <= minus && minus<= 20){
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        bw.write(dp[n-2][nums[n-1]] + "\n");
        bw.flush();
    }
}
