import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean isPossible = false;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipts;

        for (int i = 0; i < 5; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        ipts = br.readLine().split(" ");
        int r = Integer.parseInt(ipts[0]);
        int c = Integer.parseInt(ipts[1]);
        if(map[r][c] != -1) dfs(r, c, 0, 0);

        System.out.println(isPossible ? 1 : 0);

        br.close();
    }

    public static void dfs(int r, int c, int depth, int appleCnt){
//        System.out.println("r : " + r + ", c : " + c + ", depth : " + depth + ", appleCnt : " + appleCnt);
        if(isPossible) return;
        if(depth >= 3){
//            System.out.println("finished r : " + r + ", c : " + c + ", depth : " + depth + ", appleCnt : " + appleCnt);
            if(appleCnt >= 2) isPossible = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || 4 < nr || 4 < nc || map[nr][nc] == -1) continue;

            if(map[nr][nc] == 1){
                map[r][c] = -1;
                map[nr][nc] = 0;
                dfs(nr, nc, depth + 1, appleCnt + 1);
                map[r][c] = 0;
                map[nr][nc] = 1;
            } else if(map[nr][nc] == 0){
                map[r][c] = -1;
                dfs(nr, nc, depth + 1, appleCnt);
                map[r][c] = 0;
            }
        }
    }
}

