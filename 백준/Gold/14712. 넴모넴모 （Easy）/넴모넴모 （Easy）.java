import java.io.*;

public class Main {
    static int N, M, answer;
    static boolean[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);

        board = new boolean[N][M];
        answer = 0;
        bt(0, 0);
        System.out.println(answer);
    }

    static void bt(int depth, int start){
        answer += isSquareExists(depth) ? 0 : 1;
        if(depth == N * M) return;

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;

            if(board[r][c]) continue;

            board[r][c] = true;
            bt(depth + 1, i + 1);
            board[r][c] = false;
        }
    }

    static boolean isSquareExists(int depth){

        if(depth < 4) return false;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-1; j++) {
                // 사각형 존재하면 true 반환
                if(board[i][j] && board[i+1][j] && board[i][j+1] && board[i+1][j+1]) return true;
            }
        }

        return false;
    }
}
