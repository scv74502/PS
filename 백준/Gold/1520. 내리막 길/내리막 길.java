import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipts = br.readLine().split(" ");

        M = Integer.parseInt(ipts[0]);
        N = Integer.parseInt(ipts[1]);

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(ipts[j]);
                dp[i][j] = -1;
            }
        }



        System.out.println(dfs(0, 0));
    }

    public static int dfs(int r, int c){
        if(r == M - 1 && c == N - 1){
            return 1;
        }

        if(dp[r][c] != -1) return dp[r][c];
        dp[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || M <= nr || N <= nc ){
                continue;
            }

            if(map[r][c] > map[nr][nc]){
                dp[r][c] += dfs(nr, nc);
            }
        }

        return dp[r][c];
    }
}

