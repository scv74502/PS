import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0,};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        int[][] crushCnt = new int[N][M];

        for (int i = 0; i < N; i++) {
            String ipt = br.readLine();
            Arrays.fill(crushCnt[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                maze[i][j] = ipt.charAt(j) - '0';
            }
        }

        crushCnt[0][0] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0, 0});

        while(!queue.isEmpty()){
            int cr = queue.peek()[0];
            int cc = queue.peek()[1];
            int cCrush = queue.peek()[2];
            queue.poll();

            if(cr == N-1 && cc == M-1){
                answer = Math.min(cCrush, answer);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int nCrush = cCrush;

                if(nr < 0 || N <= nr || nc < 0 || M <= nc){
                    continue;
                }

                if(maze[nr][nc] == 1) nCrush += 1;
                if(crushCnt[nr][nc] <= nCrush) continue;

                queue.add(new int[] {nr, nc, nCrush});
                crushCnt[nr][nc] = nCrush;
            }
        }

        System.out.println(answer);
    }
}
