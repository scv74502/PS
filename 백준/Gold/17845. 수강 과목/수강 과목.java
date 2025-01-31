import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        ipts = br.readLine().split(" ");
        int N = Integer.parseInt(ipts[0]);
        int K = Integer.parseInt(ipts[1]);

        int[] subjectWeight = new int[K];
        int[] subjectTime = new int[K];

        for (int i = 0; i < K; i++) {
            ipts = br.readLine().split(" ");
            subjectWeight[i] = Integer.parseInt(ipts[0]);
            subjectTime[i] = Integer.parseInt(ipts[1]);
        }

        // K개 과목을 N시간 들을 때의 최대 중요도
        int[][] dp = new int[K+1][N+1];
        int answer = 0;

        for (int i = 1; i <= K; i++) {
            int weight = subjectWeight[i-1];
            int time = subjectTime[i-1];

            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= time){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time] + weight);
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        System.out.println(answer);
    }
}
