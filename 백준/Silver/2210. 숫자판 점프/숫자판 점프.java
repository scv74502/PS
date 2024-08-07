import java.io.*;
import java.util.*;

public class Main {
    public static int[][] board;
    // 상하좌우 움직임
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static Set<Integer> hs;

    public static void dfs(int depth, int sum, int r, int c){
        // head recursion, 종료 조건
        if(depth == 6){
            hs.add(sum);
            return;
        }

        for(int move = 0; move < 4; move++){
            int nr = r + dr[move];
            int nc = c + dc[move];

            if(0 <= nr && nr < 5 && 0 <= nc && nc < 5){
                dfs(depth + 1, sum + board[nr][nc] * (int)(Math.pow(10, depth)), nr, nc);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        board = new int[5][5];
        hs = new HashSet<>();

        for(int i = 0; i < 5; i++){
            ipts = br.readLine().strip().split(" ");
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(ipts[j]);
            }
        }


        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(1, board[i][j], i, j);
            }
        }

        System.out.println(hs.size());
    }
}
