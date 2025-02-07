import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] ranks = new int[N];

        long answer = 0;

        for (int i = 0; i < N; i++) {
            ranks[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ranks);

        for (int i = 0; i < N; i++) {
            answer += Math.abs((i+1) - ranks[i]);
        }

        System.out.println(answer);
    }
}
