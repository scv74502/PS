import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        int[] timeInfo = new int[N+1];
        int[] priceInfo = new int[N+1];

        for (int i = 1; i <= N; i++) {
            ipts = br.readLine().split(" ");
            timeInfo[i] = Integer.parseInt(ipts[0]);
            priceInfo[i] = Integer.parseInt(ipts[1]);
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
            int endDate = i + timeInfo[i] - 1;
            if(endDate <= N){
                dp[endDate] = Math.max(dp[i-1] + priceInfo[i], dp[endDate]);
            }
        }

        System.out.println(dp[N]);
    }
}

