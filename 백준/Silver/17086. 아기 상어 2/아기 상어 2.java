import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    // 상, 하, 좌, 우, 좌하, 좌상, 우상, 우하
    public static int[] my = {-1, 1, 0, 0, 1, -1, -1, 1};
    public static int[] mx = {0, 0, -1, 1, -1, -1, 1, 1};
    public static int[][] grids;
    public static boolean[][] visited;
    public static int MAX_DIST = Integer.MIN_VALUE;

    // 시작 y, x 도착 y, x
    public static int bfs(int sy, int sx){
        visited = new boolean[N][M];
        visited[sy][sx] = true;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sy, sx, 0});
        int result = Integer.MAX_VALUE;
        int[] cur;
        int cy, cx, cd;
        int ny, nx, nd;

        while(!dq.isEmpty()){
            cur = dq.pollFirst();
            cy = cur[0];
            cx = cur[1];
            cd = cur[2];

            if(grids[cy][cx] == 1){
                return cd;
            }

            for(int i = 0; i < 8; i++){
                ny = cy + my[i];
                nx = cx + mx[i];
                nd = cd + 1;

                // 범위 체크
                if(0 <= ny && ny < N && 0 <= nx && nx < M){
                    // 방문 여부 체크
                    if(!visited[ny][nx]){

                        dq.add(new int[] {ny, nx, nd});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return result ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;
        int sy, sx, dy, dx, nearest = 0;
        int[] start, destination;
        int result = Integer.MIN_VALUE;

        ipts = br.readLine().strip().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);
        grids = new int[N][M];
//        ArrayList<int[]> sharks = new ArrayList<>();

        for(int i = 0; i < N; i++){
            ipts = br.readLine().strip().split(" ");
            for(int j = 0; j < M; j++){
                grids[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        for(int i = 0; i < N;i++){
            for(int j = 0; j < M; j++){
                if(grids[i][j] == 1){
                    continue;
                }
                result = bfs(i, j);
                MAX_DIST = Math.max(result, MAX_DIST);
            }
        }
        System.out.println(MAX_DIST);
    }
}