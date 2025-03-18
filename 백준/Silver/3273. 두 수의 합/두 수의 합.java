import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] numbers = new int[N];
        stringTokenizer =  new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);

        int x = Integer.parseInt(br.readLine());

        int answer = 0;
        int start = 0;
        int end = N - 1;

        while(start < end){
            if(numbers[start] + numbers[end] == x){
                answer++;
            }

            if(numbers[start] + numbers[end] <= x){
                start++;
            } else{
                end--;
            }
        }

        System.out.println(answer);
    }
}