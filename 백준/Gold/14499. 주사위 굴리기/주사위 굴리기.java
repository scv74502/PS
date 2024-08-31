import java.io.*;

public class Main {
    static int N, M;
    static int[][] board;
    // 주사위의 값 저장
    static int[] dice = new int[] {0, 0, 0, 0, 0, 0, 0};
    static int temp1, temp2, temp3, temp4, temp5, temp6;

    // 동서북남, 각각 세로와 가로
    static int[] dr = new int[] {0, 0, 0, -1, 1};
    static int[] dc = new int[] {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;
        int x, y, K;
        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);
        x = Integer.parseInt(ipts[2]);
        y = Integer.parseInt(ipts[3]);
        K = Integer.parseInt(ipts[4]);

        board = new int[N][M];
        for(int i = 0; i < N; i++){
        ipts = br.readLine().split(" ");
            for (int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        // 현재 맨 밑에 있는 주사위의 인덱스
        int bottomIdx = 6;

//        if(board[x][y] == 0){
//            board[x][y] = dice[bottomIdx];
//        } else{
//            dice[bottomIdx] = board[x][y];
//            board[x][y] = 0;
//        }

        int order, nx, ny;
        ipts = br.readLine().split(" ");
        for(int i = 0; i < K; i++){
            order = Integer.parseInt(ipts[i]);
            nx = x + dr[order];
            ny = y + dc[order];

            // 지도 범위 벗어나는 명령 무시
            if(nx < 0 || N <= nx || ny < 0 || M <= ny ){
                continue;
            }


            // 이동 및 주사위 변경
            x = nx;
            y = ny;

            // 동서북남
            if(order == 1){
                rollEast();
            } else if(order == 2){
                rollWest();
            } else if(order == 3){
                rollNorth();
            } else if(order == 4){
                rollSouth();
            }


            if(board[x][y] == 0){
                board[x][y] = dice[bottomIdx];
            } else{
                dice[bottomIdx] = board[x][y];
                board[x][y] = 0;
            }

            System.out.println(dice[getTop(bottomIdx)]);
        }
    }

    static void swap(int a, int b){
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

    static int getTop(int bottom){
        if(bottom == 1){
            return 6;
        } else if(bottom == 2){
            return 5;
        } else if(bottom == 3){
            return 4;
        } else if(bottom == 4){
            return 3;
        } else if(bottom == 5){
            return 2;
        } else{
            return 1;
        }
    }

    static void rollEast(){
        temp1 = dice[1];
        temp2 = dice[2];
        temp3 = dice[3];
        temp4 = dice[4];
        temp5 = dice[5];
        temp6 = dice[6];

        dice[1] = temp4;
        dice[2] = temp2;
        dice[3] = temp1;
        dice[4] = temp6;
        dice[5] = temp5;
        dice[6] = temp3;
    }

    static void rollWest(){
        temp1 = dice[1];
        temp2 = dice[2];
        temp3 = dice[3];
        temp4 = dice[4];
        temp5 = dice[5];
        temp6 = dice[6];

        dice[1] = temp3;
        dice[2] = temp2;
        dice[3] = temp6;
        dice[4] = temp1;
        dice[5] = temp5;
        dice[6] = temp4;
    }

    static void rollNorth(){
        temp1 = dice[1];
        temp2 = dice[2];
        temp3 = dice[3];
        temp4 = dice[4];
        temp5 = dice[5];
        temp6 = dice[6];

        dice[1] = temp2;
        dice[2] = temp6;
        dice[3] = temp3;
        dice[4] = temp4;
        dice[5] = temp1;
        dice[6] = temp5;
    }

    static void rollSouth(){
        temp1 = dice[1];
        temp2 = dice[2];
        temp3 = dice[3];
        temp4 = dice[4];
        temp5 = dice[5];
        temp6 = dice[6];

        dice[1] = temp5;
        dice[2] = temp1;
        dice[3] = temp3;
        dice[4] = temp4;
        dice[5] = temp6;
        dice[6] = temp2;
    }


}
