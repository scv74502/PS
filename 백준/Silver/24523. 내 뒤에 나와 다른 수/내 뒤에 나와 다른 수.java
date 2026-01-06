import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] ipt = br.readLine().split(" ");

        int[] numbers = new int[N + 1];
        int[] accum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(ipt[i-1]);
        }

        // N이 1이면 -1
        if(N == 1){
            System.out.println(-1);
            return;
        }

        int duplicatedAmount = 1;
        for (int i = 2; i <= N; i++) {
            int diff = numbers[i] - numbers[i-1];

            // 차가 0이면 같은 수, 중복개수 추가하고 넘어간다
            if (diff == 0){
                duplicatedAmount += 1;
                continue;
            }

            // 차가 0 아니면 다른 수, 겹친 만큼 이전 수들에 인덱스 반영
            for (int j = 1; j <= duplicatedAmount; j++) {
                accum[i - j] = i;
            }
            duplicatedAmount = 1;
        }

        for (int j = 0; j < duplicatedAmount; j++) {
            accum[N - j] = -1;
        }

        for (int i = 1; i < N; i++) {
            sb.append(accum[i]).append(" ");
        }

        sb.append(accum[N]).append("\n");

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
