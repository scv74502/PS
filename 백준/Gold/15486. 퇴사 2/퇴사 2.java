import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];

        for(int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            int consultDay = Integer.parseInt(ipts[0]);
            int consultPrice = Integer.parseInt(ipts[1]);
            schedule[i][0] = consultDay;
            schedule[i][1] = consultPrice;
        }

        // dp[i] -> i일까지밖에 없을 대 최대값
        int[] dp = new int[N+1];

        // 첫 날부터 진행, bottom-up
        for(int i = 1; i <= N; i++) {
            // 이전까지의 최대값
            dp[i] = Math.max(dp[i], dp[i-1]);
            int consultDay = schedule[i-1][0];
            int consultPrice = schedule[i-1][1];

            // 해당 상담을 진행한 마지막 날, 당일을 포함한다
            int finDay = i + consultDay - 1;

            if(finDay <= N){
                dp[finDay] = Math.max(dp[finDay], dp[i-1] + consultPrice);
            }
        }

        System.out.println(dp[N]);
    }
}
