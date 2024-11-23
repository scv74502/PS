import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        ipts = br.readLine().split(" ");
        int[] numbers = new int[N+1];
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(ipts[i-1]);
        }

        int max, curSeq;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
