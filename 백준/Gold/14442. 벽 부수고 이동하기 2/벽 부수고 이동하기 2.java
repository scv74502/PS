import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);
        int K = Integer.parseInt(ipts[2]);

        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        int answer = Integer.MAX_VALUE;

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        // r, c, k
        dq.add(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        while(!dq.isEmpty()){
            int cr = dq.peek()[0];
            int cc = dq.peek()[1];
            int cDist = dq.peek()[2];
            int ck = dq.peek()[3];
            dq.poll();

            if(cr == N - 1 && cc == M - 1){
                answer = Math.min(cDist, answer);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || nc < 0 || N <= nr || M <= nc) continue;

                if(map[nr][nc] == 1){
                    if(ck >= K || visited[nr][nc][ck + 1]) continue;
                    dq.add(new int[] {nr, nc, cDist + 1, ck + 1});
                    visited[nr][nc][ck + 1] = true;
                } else{
                    if(visited[nr][nc][ck]) continue;
                    dq.add(new int[] {nr, nc, cDist + 1, ck});
                    visited[nr][nc][ck] = true;
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer+1);
    }
}