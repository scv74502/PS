import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        final int MAXIMUM_BOUND = 100001;

        int[] costs = new int[N];
        int[] values = new int[N];
        int[] dp = new int[C + 101];  // 고객이 i명일때 최소 비용
        Arrays.fill(dp, MAXIMUM_BOUND);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cost = costs[i];
            int value = values[i];

            for (int j = value; j < C+101; j++) {
                dp[j] = Math.min(dp[j], dp[j - value] + cost);
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = C; i < C+101; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
