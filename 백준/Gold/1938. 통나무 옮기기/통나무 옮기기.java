import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    static int[][] board;
    static boolean woodIsRow = false;
    static boolean endIsRow = false;
    static boolean[][][] visited;
    static ArrayList<int[]> woodLocations = new ArrayList<>();
    static ArrayList<int[]> endLocations = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N][2];

        for (int i = 0; i < N; i++) {
            ipt = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = ipt.charAt(j);
                if(ch == 'B') woodLocations.add(new int[] {i, j});
                else if(ch == 'E') endLocations.add(new int[] {i, j});
                else board[i][j] = ch - '0';
            }
        }

        positionCheck();
        bfs();
        System.out.println(answer);
    }

    public static void positionCheck(){
        // 나무 위치에서 세로 위치가 차이나는지 체크하기
        int diff = woodLocations.get(0)[0] - woodLocations.get(1)[0];
        if(diff == 1 || diff == -1) woodIsRow = false;
        else woodIsRow = true;

        // 종료 위치에서 세로 위치가 차이나는지 체크하기
        diff = endLocations.get(0)[0] - endLocations.get(1)[0];
        if(diff == 1 || diff == -1) endIsRow = false;
        else endIsRow = true;
    }
    
    public static boolean isImpossibleRange(int r, int c, int pos){
        // 가로
        if(pos == 1){
            if(r < 0 || N <= r || c < 1 || N - 1 <= c) return true;
        }
        // 세로
        else{
            if(r < 1 || N - 1 <= r || c < 0 || N <= c) return true;
        }

        return false;
    }

    // 회전 가능여부 체크하기
    public static boolean isRotatePossible(int r, int c, int pos){
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) continue;

                int nr = r + i;
                int nc = c + j;

                if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;;
                
                if(board[nr][nc] == 1) return false;
            }
        }

        if(pos == 1) pos = 0;
        else pos = 1;

        // 범위가 불가능하거나, 나무가 있으면 불가능
        if(isImpossibleRange(r, c, pos) || isTreeExists(r, c, pos)) return false;

        // 방문한 적 있으면 패스
        if(visited[r][c][pos]) return false;

        visited[r][c][pos] = true;

        return true;
    }

    public static boolean isTreeExists(int r, int c, int pos){
        for (int i = -1; i <= 1; i++) {
            if(pos == 0){
                int nr = r + i;

                if(board[nr][c] == 1) return true;
            } else{
                int nc = c + i;
                if(board[r][nc] == 1) return true;
            }
        }

        return false;
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        // 나무 중앙 위치, 방향(가로가 1, 움직인 횟수
        queue.offer(new int[]{woodLocations.get(1)[0], woodLocations.get(1)[1], woodIsRow ? 1 : 0, 0});
        visited[woodLocations.get(1)[0]][woodLocations.get(1)[1]][woodIsRow ? 1 : 0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int pos = cur[2];
            int cnt = cur[3];

            if(r == endLocations.get(1)[0] && c == endLocations.get(1)[1] && ((pos == 1 && endIsRow) || (pos == 0 && !endIsRow))){
                answer = cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(isImpossibleRange(nr, nc, pos)) continue;

                if(visited[nr][nc][pos]) continue;

                if(isTreeExists(nr, nc, pos)) continue;

                visited[nr][nc][pos] = true;
                queue.offer(new int[]{nr, nc, pos, cnt+1});
            }

            if(isRotatePossible(r, c, pos)){
                if(pos == 1){
                    queue.offer(new int[] {r, c, 0, cnt+1});
                } else {
                    queue.offer(new int[] {r, c, 1, cnt+1});
                }
            }
        }
    }
}
