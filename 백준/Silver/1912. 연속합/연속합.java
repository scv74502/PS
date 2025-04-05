import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];

        String[] ipts = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(ipts[i]);
            dp[i] = numbers[i];
        }

        int answer = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i], dp[i-1] + numbers[i]);
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
