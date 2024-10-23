import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        long[] distances = new long[N-1];
        long[] cities = new long[N];

        ipts = br.readLine().split(" ");
        for(int i = 0; i < N-1; i++) {
            distances[i] = Long.parseLong(ipts[i]);
        }

        ipts = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            cities[i] = Long.parseLong(ipts[i]);
        }

        long answer = 0;
        long curPrice = Long.MAX_VALUE;

        for(int i = 0; i < N-1; i++) {
            curPrice = Math.min(curPrice, cities[i]);
            answer += curPrice * distances[i];
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
