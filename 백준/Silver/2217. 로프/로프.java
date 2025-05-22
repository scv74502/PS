import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] ropes = new int[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer =  new StringTokenizer(br.readLine());
            ropes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(ropes);

        int maxHeight = 0;
        int ropeCnt = 0;

        for (int i = N-1; i  >= 0; i--) {
            ropeCnt++;
            if(maxHeight < ropes[i] * ropeCnt){
                maxHeight = ropes[i] * ropeCnt;
            }
        }

        System.out.println(maxHeight);
    }
}