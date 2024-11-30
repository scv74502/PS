import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public class Main {
    static int N, M;
    static int answer = -1;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] lab;
    static int[][] bfsLab;
    static HashSet<Integer> walls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);
        walls = new HashSet<>();

        lab = new int[N][M];
        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(ipts[j]);
                if(lab[i][j] == 1){
                    walls.add(i * N + M);
                }
            }
        }

        bt(0);
        System.out.println(answer);
    }

    public static void bt(int depth){
        if(depth == 3){
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!walls.contains(i * N + j) && lab[i][j] == 0){
                    lab[i][j] = 1;
                    walls.add(i * N + M);
                    bt(depth + 1);
                    lab[i][j] = 0;
                    walls.remove(i * N + M);
                }
            }
        }
    }

    public static void bfs(){
        Deque<int[]> dq = new ArrayDeque<>();

        labCopy();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(bfsLab[i][j] == 2){
                    dq.add(new int[] {i, j});
                }
            }
        }

//        if(bfsLab[1][0] == 1 && bfsLab[0][1] == 1 && bfsLab[3][5] == 1){
//            System.out.println("TC1 answer");
//        }

        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int cy = cur[0];
            int cx = cur[1];
            int nx, ny;

            for (int i = 0; i < 4; i++) {
                nx = cx + dx[i];
                ny = cy + dy[i];

                if(0 <= nx && nx < M && 0 <= ny && ny < N && bfsLab[ny][nx] == 0){
                    bfsLab[ny][nx] = 2;
                    dq.add(new int[] {ny, nx});
                }
            }
        }
        int cntZero = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(bfsLab[i][j] == 0) cntZero++;
            }
        }

        answer = Math.max(cntZero, answer);
    }

    public static void labCopy(){
        bfsLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfsLab[i][j] = lab[i][j];
            }
        }
    }
}
