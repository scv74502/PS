import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        StringBuilder sb = new StringBuilder();

        // N이 가로, M이 세로
        int N, M;

        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);

        long [][] dp = new long[N+1][M+1];

        int k = Integer.parseInt(br.readLine());
        int a, b, c, d;

        // 각각 가로 도로 저장, 세로 도로 저장
        int[][] horizontal = new int[N][M+1];
        int[][] vertical = new int[N+1][M];

        for(int r = 0; r < k; r++){
            ipts = br.readLine().split(" ");
            a = Integer.parseInt(ipts[0]);
            b = Integer.parseInt(ipts[1]);
            c = Integer.parseInt(ipts[2]);
            d = Integer.parseInt(ipts[3]);

            // 가로 도로
            if(b == d){
                horizontal[Math.min(a, c)][b] = 1;
            } else{
                // 세로 도로
                vertical[a][Math.min(b, d)] = 1;
            }
        }

        for(int i = 1; i <= N; i++){
            if(horizontal[i-1][0] == 1){
                break;
            }
            dp[i][0] = 1L;
        }

        for(int i = 1; i <= M; i++){
            if(vertical[0][i-1] == 1){
                break;
            }
            dp[0][i] = 1L;
        }

        // i가 가로, j가 세로
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                // 가로 도로가 공사중인 경우
                if(horizontal[i-1][j] == 1){
                    dp[i][j] -= dp[i-1][j];
                }
                // 세로 도로가 공사중인 경우
                if(vertical[i][j-1] == 1){
                    dp[i][j] -= dp[i][j-1];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}

