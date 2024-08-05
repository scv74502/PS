import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int N, S;
    static int[] numbers;
    static int count;

    public static void backTracking(int sum, int cur){
        if(cur == N){
            if(sum == S){
                count++;
            }
            return;
        }

        backTracking(sum+numbers[cur], cur+1);
        backTracking(sum, cur + 1);
    }

    static void swap(int a, int b){
        int temp = b;
        b = a;
        a = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        int temp = 0;

        ipts = br.readLine().strip().split(" ");
        N = Integer.parseInt(ipts[0]);
        S = Integer.parseInt(ipts[1]);
        numbers = new int[N];
        ipts = br.readLine().strip().split(" ");

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(ipts[i]);
        }

        count = 0;

        backTracking(0, 0);
        System.out.println(S == 0 ? count - 1 : count);

    }
}
