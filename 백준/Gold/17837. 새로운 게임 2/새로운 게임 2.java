import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    // X 우 좌 상 하
    public static int[] dr = {0, 0, 0, -1, 1};
    public static int[] dc = {0, 1, -1, 0, 0};
    public static int[][] boardColors;
    public static LinkedList<Integer>[][] piledPieces;
    public static ArrayList<int[]> pieces = new ArrayList<>();
    public static HashSet<Integer> placesPieceExist = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        K = Integer.parseInt(ipts[1]);

        boardColors = new int[N][N];
        piledPieces = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                boardColors[i][j] = Integer.parseInt(ipts[j]);
                piledPieces[i][j] = new LinkedList<>();
            }
        }

        int r, c, direction;
        for (int i = 0; i < K; i++) {
            ipts = br.readLine().split(" ");
            r = Integer.parseInt(ipts[0]) - 1;
            c = Integer.parseInt(ipts[1]) - 1;
            direction = Integer.parseInt(ipts[2]);
            // 행 열 이동방향
            pieces.add(new int[] {r, c, direction});
            // 말 겹침 표현하는 큐에 넣음
            piledPieces[r][c].add(i);

        }

        int nr, nc, num;

        // 1000턴 넘어가면 01 출력
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < K; j++) {
                r = pieces.get(j)[0];
                c = pieces.get(j)[1];
                direction = pieces.get(j)[2];
                num = getDepth(j, r, c);

                // 이동할 다음 칸
                nr = r + dr[direction];
                nc = c + dc[direction];

                // 다음 밟을 곳이 밝을 수 없거나 파란색이면
                if(nr < 0 || N <= nr || nc < 0 || N <= nc || boardColors[nr][nc] == 2){
                    pieces.get(j)[2] = direction = getOppositeDirection(direction);

                    // 이동할 다음 칸 재설정
                    nr = r + dr[direction];
                    nc = c + dc[direction];

                    if(nr < 0 || N <= nr || nc < 0 || N <= nc || boardColors[nr][nc] == 2){
                        continue;
                    }
                }

                if(move(r, c, nr, nc, num, boardColors[nr][nc])){
                    System.out.println(i);
                    return;
                }

            }
        }
        System.out.println(-1);
    }

    // 말의 움직임 구현
    public static boolean move(int r, int c, int nr, int nc, int num, int depth){
        while(piledPieces[r][c].size() > num){
            int temp = -1;
            if(depth == 0) temp = piledPieces[r][c].remove(num);
            else temp = piledPieces[r][c].removeLast();

            pieces.get(temp)[0] = nr;
            pieces.get(temp)[1] = nc;
            piledPieces[nr][nc].add(temp);
        }

        return piledPieces[nr][nc].size() >= 4;
    }

    // 반대방향 구함
    public static int getOppositeDirection(int direction){
        if(direction == 1) return 2;
        else if(direction == 2) return 1;
        else if(direction == 3) return 4;
        else if(direction == 4) return 3;
        return -1;
    }

    // 겹친 말 중에서 몇번째인지 구하는 함수
    public static int getDepth(int n, int r, int c){
        for (int i = 0; i < piledPieces[r][c].size(); i++) {
            if(piledPieces[r][c].get(i) == n)
                return i;
        }
        return -1;
    }
}
