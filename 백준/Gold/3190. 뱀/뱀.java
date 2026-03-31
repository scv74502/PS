import java.io.*;
import java.util.*;

public class Main {
    static int N;
    // 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] board;
    static HashMap<Integer, String> changeDirInfo = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] iptArr = br.readLine().split(" ");
            int row = Integer.parseInt(iptArr[0]) - 1;
            int col = Integer.parseInt(iptArr[1]) - 1;
            board[row][col] = 1;    // 사과 표시
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] iptArr = br.readLine().split(" ");
            int turn = Integer.parseInt(iptArr[0]);
            String dir = iptArr[1];

            changeDirInfo.put(turn, dir);
        }

        game();
    }

    public static void game(){
        int turn = 0;
        int direction = 1;  // 최초에는 오른쪽
        ArrayDeque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[] {0, 0});
        board[0][0] = 2;    // 뱀의 몸이 있는 칸은 2로 표현

        while(true){
            turn++;
            int cr = snake.peek()[0];
            int cc = snake.peek()[1];

            int nr = cr + dr[direction];
            int nc = cc + dc[direction];
            // 벽이나 자신의 몸과 부딪히면 게임 종료
            if(nr < 0 || N <= nr || nc < 0 || N <= nc || board[nr][nc] == 2) break;

            // 다음 칸에 뱀의 머리가 위치함
            snake.addFirst(new int[] {nr, nc});

            // 사과가 없으면 몸 늘리지 않음, 꼬리가 움직임
            if(board[nr][nc] != 1){
                int tailR = snake.peekLast()[0];
                int tailC = snake.peekLast()[1];
                snake.pollLast();
                board[tailR][tailC] = 0;
            }

            // 꼬리가 움직이는지 체크한 다음 머리 움직임 반영
            board[nr][nc] = 2;

            // 게임 시작후 X초가 끝나면 회전시킴
            if(changeDirInfo.containsKey(turn)){
                String dir = changeDirInfo.get(turn);
                if(dir.equals("L")){
                    direction = calcDir(direction - 1);
                } else {
                    direction = calcDir(direction + 1);
                }
            }
        }

        System.out.println(turn);
    }

    public static int calcDir(int dir){
        if(dir < 0) return dir + 4;
        return dir % 4;
    }
}



