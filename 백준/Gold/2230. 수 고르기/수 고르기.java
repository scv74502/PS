import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int end = 0;

            while(end < N && numbers[end] -  numbers[i] < M) {
                end++;
            }

            if(end == N) break;

            answer = Math.min(answer, numbers[end] - numbers[i]);
        }

        System.out.println(answer);
    }
}