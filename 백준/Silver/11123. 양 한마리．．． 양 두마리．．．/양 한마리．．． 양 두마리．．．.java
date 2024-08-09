import java.io.*;
import java.util.*;

public class Main {
    public static int rpt, H, W;
    // 상, 하, 좌, 우
    public static int[] dh = {-1, 1, 0, 0};
    public static int[] dw = {0, 0, -1, 1};
    public static char[][] grid;
    public static boolean[][] visited;

//    public static void bfs(int sy, int sx){
//        Deque<Point> dq = new ArrayDeque<>();
//        dq.add(new Point(sy, sx));
//
//        while(!dq.isEmpty()){
//            Point cur = dq.poll();
//            int cr = cur.r;
//            int cc = cur.c;
//            visited[cr][cc] = true;
//            //System.out.println("cr : " + cr + ", cc : " + cc);
//
//            for(int mv = 0; mv < 4; mv++){
//                int dr = cur.r + dh[mv];
//                int dc = cur.c + dw[mv];
//
//                // 범위 및 방문여부 체크하기
//                if(0 <= dr && dr < H && 0 <= dc && dc < W && !visited[dr][dc] && grid[dr][dc] == '#'){
//                    dq.add(new Point(dr, dc));
//                }
//            }
//        }
//    }

    public static void dfs(int sy, int sx){
        for(int mv = 0; mv < 4; mv++){
            int nr = sy + dh[mv];
            int nc = sx + dw[mv];

            if(0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc] && grid[nr][nc] == '#'){
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;
        int answer;
        rpt = Integer.parseInt(br.readLine());

        for(int r = 0; r < rpt; r++){
            answer = 0;

            ipts = br.readLine().split(" ");
            H = Integer.parseInt(ipts[0]);
            W = Integer.parseInt(ipts[1]);
            grid = new char[H][W];
            visited = new boolean[H][W];
            for(int y = 0; y < H; y++){
                ipt = br.readLine().strip();
                int idx = 0;
                for(char ch:ipt.toCharArray()){
                    grid[y][idx] = ch;
                    idx++;
                }
            }
            //System.out.println(Arrays.deepToString(grid));
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    if(!visited[i][j] && grid[i][j] == '#'){
                        //System.out.println("i : " + i + ", j : " + j);
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(answer);
        }
    }
}

class Point{
    int r;
    int c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
