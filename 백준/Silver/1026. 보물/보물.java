import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] aArr = new int[N];
        int[] bArr = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += aArr[i] * bArr[N - 1 - i];
        }

        System.out.println(answer);
    }
}