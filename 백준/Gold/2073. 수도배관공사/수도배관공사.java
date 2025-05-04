import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] pipeLengths = new int[P];
        int[] pipeCapas = new int[P];
        int[][] dp = new int[P + 1][D + 1];

        Arrays.fill(dp[0], -1);
        dp[0][0] = 2 << 23;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            pipeLengths[i] = Integer.parseInt(st.nextToken());
            pipeCapas[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i+1], -1);
            dp[i+1][0] = 2 << 23;
        }

        for (int i = 1; i <= P; i++) {
            int pipeLength = pipeLengths[i-1];
            int pipeCapa = pipeCapas[i-1];
            for (int j = 1; j <= D; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= pipeLength){
                    dp[i][j] = Math.max(dp[i][j], Math.min(dp[i-1][j-pipeLength], pipeCapa));
                }
            }
        }

        System.out.println(dp[P][D]);
    }
}