import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX_COST = 10_000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memoryAmounts = new int[N];
        int[] costs = new int[N];
        int[][] dp = new int[N+1][MAX_COST + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memoryAmounts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int memoryAmount = memoryAmounts[i-1];
            int cost = costs[i-1];

            for (int j = 0; j <= MAX_COST; j++) {
                dp[i][j] = dp[i-1][j];  // 현재 앱 종료하지 않더라도 이전 선택까지의 비용은 보존됨

                if(j >= cost){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j-cost] + memoryAmount);                }
            }
        }

        int answer = MAX_COST + 1;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= MAX_COST; j++) {
                if(dp[i][j] >= M){
                    answer = j;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
