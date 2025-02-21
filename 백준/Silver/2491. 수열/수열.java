import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] ipts = br.readLine().split(" ");
        int[] numbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(ipts[i-1]);
        }

        int[] dpPlus = new int[N + 1];
        int[] dpMinus = new int[N + 1];
        Arrays.fill(dpPlus, 1);
        Arrays.fill(dpMinus, 1);
        dpPlus[0] = 0;
        dpMinus[0] = 0;
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if(numbers[i] >= numbers [i-1]){
                dpPlus[i] = Math.max(dpPlus[i], dpPlus[i-1] + 1);
            }

            if(numbers[i] <= numbers [i-1]){
                dpMinus[i] = Math.max(dpMinus[i], dpMinus[i-1] + 1);
            }

            answer = Math.max(answer, dpPlus[i]);
            answer = Math.max(dpMinus[i], answer);
        }

        System.out.println(answer);
    }
}
