import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] numbers = new int[K];
        int left = S / K;
        int leftOver = S % K;

        Arrays.fill(numbers, left);
        int idx = 0;

        while(leftOver > 0){
            numbers[idx] += 1;
            idx++;
            idx = idx % K;
            leftOver--;
        }

        long answer = 1;
        for (int number:numbers){
            answer *= number;
        }

        System.out.println(answer);
    }
}