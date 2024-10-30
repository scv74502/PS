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

        for(int i = 1; i <= N; i++){
            // 이전까지의 최대값, i일자 상담을 진행하지 않더라도 i-1일자의 최대값은 i일에도 최대값이다
            dp[i] = Math.max(dp[i], dp[i-1]);

            // 상담의 마지막 날은 현재날짜 + 상담소요시간 - 1
            // -1 없으면 상담이 끝난 첫날
            int consultEndDay = i + schedule[i-1][0] - 1; // i일 상담의 마지막 날
            int curPrice = schedule[i-1][1];  // i일 진행하는 상담의 수임료

            // N일자 넘어서 끝나는 상담은 진행하지 않음
            if(consultEndDay > N) continue;

            // dp[i]는 i일까지 상담 진행했을 때의 최대금액
            // 오늘 기준으로 어제까지 상담 최대금액 + 오늘 진행하는 상담료를 오늘 상담 마지막날의 최대 상담료와 비교하여 큰 값을 대입함
            dp[consultEndDay] = Math.max(dp[consultEndDay], dp[i-1] + curPrice);
        }

        System.out.println(dp[N]);
    }
}
