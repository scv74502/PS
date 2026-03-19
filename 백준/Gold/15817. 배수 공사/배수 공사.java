import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ipt = br.readLine().split(" ");
        int N = Integer.parseInt(ipt[0]);
        int x = Integer.parseInt(ipt[1]);

        int[] dp = new int[10001];
        dp[0] = 1;

        // pipes[i][0] -> i번 파이프 길이, pipes[i][1] -> i번 파이프 개수
        int[][] pipes = new int[N][2];
        for (int i = 0; i < N; i++) {
            ipt = br.readLine().split(" ");
            int length = Integer.parseInt(ipt[0]);
            int count = Integer.parseInt(ipt[1]);
            pipes[i][0] = length;
            pipes[i][1] = count;
        }

        for(int[] pipe: pipes){
            int curLength = pipe[0];
            int curCnt = pipe[1];

            for (int i = x; i > 0; i--) {
                for (int j = 1; j <= curCnt; j++) {
                    if(i - j * curLength >= 0) {
                        dp[i] += dp[i - j * curLength];
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(dp[x]);
    }
}
