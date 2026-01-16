import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] iptArray = br.readLine().split(" ");
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(iptArray[i]);
        }

        long[] accumulatedSum = new long[N + 1];
        accumulatedSum[0] = numbers[0];

        for (int i = 1; i < N; i++) {
            accumulatedSum[i] = accumulatedSum[i-1] + numbers[i];
        }

        long answer = 0;

        for (int i = 0; i < N - 1; i++) {
            answer += numbers[i] * (accumulatedSum[N - 1] - accumulatedSum[i]);
        }

        System.out.println(answer);
    }
}
