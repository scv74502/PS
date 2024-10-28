import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);
        int K = Integer.parseInt(ipts[2]);

        // N번 도시를 M번째 방문시 점수
        int[][] dp = new int[N+1][M+1];

        int[][] lines = new int[N+1][N+1];

        for (int i = 0; i < K; i++) {
            ipts = br.readLine().split(" ");
            int a = Integer.parseInt(ipts[0]);
            int b = Integer.parseInt(ipts[1]);
            int c = Integer.parseInt(ipts[2]);

            if(a > b) continue;

            lines[a][b] = Math.max(lines[a][b], c);
        }

        // 초기화, 1번 도시에서 출발하는 경우를 저장함
        for (int i = 2; i <= N; i++) {
            dp[i][2] = Math.max(dp[i][2], lines[1][i]);
        }

        // dp를 이용한 풀이
        // 2번부터 N번까지 모든 점 순회
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < M; j++) {
                if(dp[i][j] != 0){
                    for (int k = 2; k <= N; k++) {
                        if(lines[i][k] != 0){
                            dp[k][j+1] = Math.max(dp[k][j+1], dp[i][j] + lines[i][k]);
                        }
                    }
                }
            }
        }


        int answer = 0;
        for (int i = 1; i <= M; i++) {
            answer = Math.max(answer, dp[N][i]);
        }
        System.out.println(answer);
    }
}
