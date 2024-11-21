import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int K = Integer.parseInt(ipts[1]);

        int[] numbers = new int[N];
        ipts = br.readLine().split(" ");

        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(ipts[i]);
            maxVal = Math.max(numbers[i], maxVal);
        }

        int left = 0;
        int right =0;

        int[] sequence = new int[maxVal + 1];;
        int answer = 0;

        while(right < N){
            if(sequence[numbers[right]] < K){
                sequence[numbers[right]]++;
                right++;
            } else{
                sequence[numbers[left]]--;
                left++;
            }
            answer = Math.max(answer, right - left);
        }
        System.out.println(answer);
    }
}
