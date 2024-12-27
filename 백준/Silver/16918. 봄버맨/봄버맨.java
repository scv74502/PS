import java.io.*;

public class Main {
    static int R, C, N;
    static char[][] board;
    // 상 하 좌 우
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");
        R = Integer.parseInt(ipts[0]);
        C = Integer.parseInt(ipts[1]);
        N = Integer.parseInt(ipts[2]);
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int second = 0;


        // 처음 1초는 아무것도 안 함
        second++;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = '3';
                }
            }
        }
        secondElapse();

        // 그 다음에는 폭탄 설치함
        if(second < N){
            secondElapse();
            second++;
            setBomb();
        }

        while(second < N){
            // 3초가 지났으므로 폭탄이 폭발함
            second++;
            secondElapse();
            explodeBomb();
            if(second == N) break;

            second++;
            secondElapse();
            setBomb();
            if(second == N) break;
        }

        // 마지막으로 모양 변경함
        finalShape();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
    }

    // 맵 빈 공간에 폭탄 설치
    public static void setBomb(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == '.'){
                    board[i][j] = '3';
                }
            }
        }
    }

    // 규칙에 따라 설치된 폭탄들이 터짐
    public static void explodeBomb(){
        int nr, nc;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == '0'){
                    for (int k = 0; k < 4; k++) {
                        nr = i + dr[k];
                        nc = j + dc[k];

                        if(0 <= nr && nr < R && 0 <= nc && nc < C && '0' != board[nr][nc]){
                            board[nr][nc] = '.';
                        }
                    }
                    board[i][j] = '.';
                }
            }
        }
    }

    // 폭탄들 시간이 감
    public static void secondElapse(){
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if('1' <= board[i][j] && board[i][j] > '0'){
                    board[i][j] -= 1;
                }
            }
        }
    }


    // 마지막에 숫자들은 폭탄모양으로 바꿈
    public static void finalShape(){
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if('1' <= board[i][j] && board[i][j] <= '3'){
                    board[i][j] = 'O';
                }
            }
        }
    }

}
