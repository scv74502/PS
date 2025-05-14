import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String ipt = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = ipt.charAt(j);
            }
        }

        int answer = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'L'){
                    answer = Math.max(answer, bfs(i, j));
                    resetVisited();
                }
            }
        }

        System.out.println(answer);
    }

    static int bfs(int sr, int sc){
        int result = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sr, sc, 0});
        visited[sr][sc] = true;

        while(!queue.isEmpty()){
            int cr = queue.peek()[0];
            int cc = queue.peek()[1];
            int cd = queue.peek()[2];
            queue.poll();

            if(cd > result){
                result = cd;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || N <= nr || nc < 0 || M <= nc || visited[nr][nc] || map[nr][nc] == 'W') continue;
                queue.add(new int[] {nr, nc, cd + 1});
                visited[nr][nc] = true;
            }
        }

        return result;
    }

    public static void resetVisited(){
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }
}

