import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N+1][3];

        int meetingFin = 0;

        for (int i = 1; i <= N; i++) {
            ipts = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(ipts[0]);
            meetings[i][1] = Integer.parseInt(ipts[1]);
            meetings[i][2] = Integer.parseInt(ipts[2]);
            meetingFin = Math.max(meetings[i][1], meetingFin);
        }

        int[] dp = new int[N+1];

        Arrays.sort(meetings, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        dp[1] = meetings[1][2];

        if(N > 1){
            dp[2] = Math.max(dp[1], meetings[2][2]);

            for (int i = 2; i <= N; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + meetings[i][2]);
            }
        }
        System.out.println(dp[N]);
    }
}
