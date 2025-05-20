import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            L = Integer.parseInt(stringTokenizer.nextToken());
            R = Integer.parseInt(stringTokenizer.nextToken());
            C = Integer.parseInt(stringTokenizer.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            int sl = 0;
            int sr = 0;
            int sc = 0;

            int el = 0;
            int er = 0;
            int ec = 0;

            for (int i = L-1; i >= 0; i--) {
                for (int j = 0; j <= R; j++) {
                    String ipt = br.readLine().strip();
                    if(j == R) break;
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = ipt.charAt(k);
                        if(map[i][j][k] == 'S'){
                            sl = i;
                            sr = j;
                            sc = k;
                        } else  if(map[i][j][k] == 'E'){
                            el = i;
                            er = j;
                            ec = k;
                        }
                    }
                }
            }

            bfs(sl, sr, sc);
        }
    }

    public static void bfs(int sl, int sr, int sc){
        int answer = Integer.MAX_VALUE;

        Queue<int[]> queue = new ArrayDeque<>();
        visited[sl][sr][sc] = true;
        queue.add(new int[] {sl, sr, sc, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cl = cur[0], cr = cur[1], cc = cur[2], curTime = cur[3];

            if(map[cl][cr][cc] == 'E'){
                answer = Math.min(answer, curTime);
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || R <= nr || nc < 0 || C <= nc || visited[cl][nr][nc] || map[cl][nr][nc] == '#') continue;
                visited[cl][nr][nc] = true;
                queue.add(new int[] {cl, nr, nc, curTime + 1});
            }

            if(cl - 1 >= 0 && map[cl-1][cr][cc] != '#' && !visited[cl-1][cr][cc] ){
                visited[cl-1][cr][cc] = true;
                queue.add(new int[] {cl - 1, cr, cc, curTime + 1});
            }

            if(cl + 1 < L && map[cl + 1][cr][cc] != '#' && !visited[cl + 1][cr][cc] ){
                visited[cl + 1][cr][cc] = true;
                queue.add(new int[] {cl + 1, cr, cc, curTime + 1});
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println("Trapped!");
        } else {
            System.out.println("Escaped in " + answer + " minute(s).");
        }
    }
}