import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        String[] ipts = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(ipts[i]);
        }

        Arrays.sort(times);

        // 1 2 3 3 4
        // 1
        // 1 + 2
        // 1 + 2 + 3
        // 1 + 2 + 3 + 3
        // 1 + 2 + 3 + 3 + 4
        // 1 + 3 + 6 + 9 + 13

        int prevTime = 0;
        int totalSpentTime = 0;

        for (int i = 0; i < N; i++) {
            totalSpentTime += prevTime + times[i];
            prevTime += times[i];
        }

        System.out.println(totalSpentTime);
    }
}
