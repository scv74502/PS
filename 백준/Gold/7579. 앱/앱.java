import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAX_BOUND = 1_000_000_000;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memoryAmounts = new int[N];
        int[] costs = new int[N];
        int[][] dp = new int[N+1][10001];  // i개 고르고 memory가 코스트가 j인 경우 메모리의 최소 사용량

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memoryAmounts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 상태에서 비용이 0일 때 확보할 수 있는 메모리는 0
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }




        for (int i = 1; i <= N; i++) {
            int memoryAmount = memoryAmounts[i-1];
            int cost = costs[i-1];

            for (int j = 0; j < 10001; j++) {
                dp[i][j] = dp[i-1][j];  // 현재 앱 비활성화하는 경우
                if(j >= cost) dp[i][j] = Math.max(dp[i][j], dp[i-1][j - cost] + memoryAmount);

            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 10001; j++) {
                if(dp[N][j] >= M){
                    answer = Math.min(answer, j);
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
