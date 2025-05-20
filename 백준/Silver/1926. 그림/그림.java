import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        visited = new boolean[N][M];
        int paintCnt = 0;
        int maxPaintArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && paper[i][j] == 1){
                    paintCnt++;
                    int area = bfs(i, j);
                    maxPaintArea = Math.max(maxPaintArea, area);
                }
            }
        }

        System.out.println(paintCnt);
        System.out.println(maxPaintArea);
    }

    public static int bfs(int sr, int sc){
        visited[sr][sc] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sr, sc});
        int area = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cr = cur[0], cc = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || N <= nr || nc < 0 || M <= nc || visited[nr][nc] || paper[nr][nc] != 1) continue;
                visited[nr][nc] = true;
                queue.add(new int[] {nr, nc});
                area++;
            }
        }

        return area;
    }
}