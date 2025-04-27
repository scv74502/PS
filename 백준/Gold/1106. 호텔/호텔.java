import java.io.*;
import java.util.*;

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
        int[] dp = new int[MAXIMUM_BOUND];  // 비용이 i일 때 최대 고객
//        Arrays.fill(dp, 100001);
//        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++){
            int cost = costs[i];
            for (int j = cost; j < MAXIMUM_BOUND; j++) {
                dp[j] = Math.max(dp[j] ,dp[j - cost] + values[i]);
            }
        }

        int answer = 0;

        for (int i = 1; i < MAXIMUM_BOUND; i++) {
            if(dp[i] >= C){
                answer = i;
                break;
            }
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }
}
