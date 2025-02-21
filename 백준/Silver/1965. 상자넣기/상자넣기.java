import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] ipts = br.readLine().split(" ");
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(ipts[i]);
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int answer = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(numbers[j] < numbers[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
