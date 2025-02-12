import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] consultPrice = new int[N + 1];
        int[] consultTime = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            ipts = br.readLine().split(" ");
            consultTime[i] = Integer.parseInt(ipts[0]);
            consultPrice[i] = Integer.parseInt(ipts[1]);
        }

        for (int i = 1; i <= N; i++) {
            // i일 상담 하지 않으면 i일 최대값은 전날의 값
            dp[i] = Math.max(dp[i-1], dp[i]);

            // 상담이 끝나서 상담료가 지급되는 상담 마지막 날
            int endDay = i + consultTime[i] - 1;
            if (endDay <= N) {
                // 상담 종료일에 상담료를 받을 때 금액총합이 크면 갱신함
                dp[endDay] = Math.max(dp[i-1] + consultPrice[i], dp[endDay]);
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}
