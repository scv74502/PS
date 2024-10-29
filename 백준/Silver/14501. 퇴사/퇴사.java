import java.io.*;
import java.util.*;

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

        int[] dp = new int[N+1];

        // 첫 날부터 진행, bottom-up
        for(int i = 0; i < N; i++) {
            int consultDay = schedule[i][0];
            int consultPrice = schedule[i][1];

            // i번 상담을 끝낸 날
            int consultEndDay = i + consultDay;
            
            // 상담 끝낸 날부터 마지막 날까지
            for (int j = consultEndDay; j <= N; j++) {
                // 처음에는 비어 있으므로 i번째 날짜에 상담 진행한 금액이 들어옴
                // 그 후에 다른 값들중 큰 값으로 갱신됨
                dp[j] = Math.max(dp[j], dp[i] + consultPrice);
            }
        }
        
        System.out.println(dp[N]);
    }
}
