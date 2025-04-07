import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int white = 0;
    static int blue = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkBoard(0, 0, N, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static int filledColor(int startRow, int startCol, int endRow, int endCol) {
        int whiteCnt = 0;
        int blueCnt = 0;
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] == 0) whiteCnt++;
                else if (board[i][j] == 1) blueCnt++;
                if(whiteCnt != 0 && blueCnt != 0) return -1;
            }
        }
        if(whiteCnt == 0) return 1;
        else return 0;
    }

    public static void checkBoard(int startRow, int startCol, int endRow, int endCol){
        int color = filledColor(startRow, startCol, endRow, endCol);
        if(color == 0){
            white++;
            return;
        } else if(color == 1){
            blue++;
            return;
        }

        int midRow = startRow + (endRow - startRow) / 2;
        int midCol = startCol + (endCol - startCol) / 2;

        // 왼쪽 위
        checkBoard(startRow, startCol, midRow, midCol);
        // 오른쪽 위
        checkBoard(startRow, midCol, midRow, endCol);
        // 왼쪽 아래
        checkBoard(midRow, startCol, endRow, midCol);
        // 오른쪽 아래
        checkBoard(midRow, midCol, endRow, endCol);
    }
}