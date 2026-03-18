import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0,};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        N = Integer.parseInt(ipt[0]);
        M = Integer.parseInt(ipt[1]);

        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];
        int startR = 0, startC = 0;

        for(int i = 0; i < N; i++){
            ipt = br.readLine().split(" ");
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(ipt[j]);
                if(map[i][j] == 2) {
                    startR = i;
                    startC = j;
                    dist[startR][startC] = 0;
                }
            }
        }

        bfs(startR, startC);

        StringBuilder sb = new StringBuilder();
        // map[i][j] == 0이면 원래 갈 수 없는곳
        for(int i = 0; i < N; i++){
            for (int j = 1; j < M; j++) {
                sb.append(map[i][j - 1] == 0 ? 0 : dist[i][j  -1]);
                sb.append(" ");
            }
            sb.append(map[i][M - 1] == 0 ? 0 : dist[i][M-1]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void bfs(int startR, int startC){
        visited[startR][startC] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startR, startC});

        while(!queue.isEmpty()){
            int cr = queue.peek()[0];
            int cc = queue.peek()[1];
            queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                // 범위 초과하거나 방문한 배열, 방문 불가한 배열은 체크하지 않기
                if(nr < 0 || N <= nr || nc < 0 || M <= nc || visited[nr][nc] || map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                dist[nr][nc] = dist[cr][cc] + 1;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}



