import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        ipts = br.readLine().split(" ");
        int N, K;
        N = Integer.parseInt(ipts[0]);
        K = Integer.parseInt(ipts[1]);
        int[][] heights = new int[N][2];
        ipts = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            heights[i][0] = Integer.parseInt(ipts[i]);
            heights[i][1] = 1;
        }

        int[] diff = new int[N-1];
        for(int i = 1; i < N; i++){
            diff[i-1] = heights[i][0] - heights[i-1][0];
        }

        Arrays.sort(diff);

        
        int answer = 0;
        for(int i = 0; i < N - K; i++){
            answer += diff[i];
        }
        System.out.println(answer);
    }
}
