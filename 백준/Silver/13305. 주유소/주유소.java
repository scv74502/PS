import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int[] cities = new int[N];
        int[] distances = new int[N-1];

        ipts = br.readLine().split(" ");
        for(int i = 0; i < N-1; i++) {
            distances[i] = Integer.parseInt(ipts[i]);
        }

        ipts = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(ipts[i]);
        }

        int answer = 0;
        int curPrice = Integer.MAX_VALUE;

        for(int i = 0; i < N-1; i++) {
            curPrice = Math.min(curPrice, cities[i]);            
            answer += curPrice * distances[i];
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
