import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts = br.readLine().split(" ");
        
        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);
        
        int[] ground = new int[N + 1];
        int[] accumulateSum = new int[N + 1];

        ipts = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            ground[i] = Integer.parseInt(ipts[i-1]);
        }

        for(int i = 0; i < M; i++) {
            ipts = br.readLine().split(" ");
            int a = Integer.parseInt(ipts[0]);
            int b = Integer.parseInt(ipts[1]);
            int k = Integer.parseInt(ipts[2]);

            accumulateSum[a] += k;
            if(b < N) accumulateSum[b+1] -= k;
        }

        for(int i = 1; i <= N; i++) {
            accumulateSum[i] = accumulateSum[i] + accumulateSum[i-1];
            ground[i] += accumulateSum[i];
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            sb.append(ground[i]);

            if(i != N) sb.append(" ");
            else sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
