import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    // 왼쪽 위부터 시계방향으로 대각선 이동 구현
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {-1, 1, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;
        int N = Integer.parseInt(br.readLine());
        int xc, xr, yc, yr;

        for (int i = 0; i < N; i++) {
            visited = new boolean[8][8];
            ipts = br.readLine().split(" ");
            xc = ipts[0].charAt(0) - 'A';
            xr = 8 - Integer.parseInt(ipts[1]);
            yc = ipts[2].charAt(0) - 'A';
            yr = 8 - Integer.parseInt(ipts[3]);

            String resultRecord = bfs(xr, xc, yr, yc);
            if(resultRecord == null){
                bw.write("Impossible\n");
            } else{
                bw.write(resultRecord);
            }
        }

        bw.flush();
    }



    public static String bfs(int sr, int sc, int tr, int tc){
        Deque<MoveRecord> dq = new ArrayDeque<>();
        MoveRecord record =new MoveRecord(sr, sc, 0, new int[5][2]);
        record.record[0][0] = sr;
        record.record[0][1] = sc;
        dq.add(record);
        visited[sr][sc] = true;

        while(!dq.isEmpty()){
            MoveRecord curMoveRecord = dq.poll();
            int cr = curMoveRecord.cr;
            int cc = curMoveRecord.cc;
            int curMoveCount = curMoveRecord.moveCount;
            int[][] curRecord = curMoveRecord.record;

            if(cr == tr && cc == tc){
                sb.setLength(0);
                sb.append(curMoveCount);
                sb.append(" ");
                for (int i = 0; i <= curMoveCount; i++) {
                    for (int j = 1; j >= 0; j--) {
                        if(j == 0){
                            sb.append(8 - curRecord[i][j]);
                        } else{
                            sb.append(Character.toChars('A' + curRecord[i][j]));
                        }

                        sb.append(" ");
                    }
                }
                sb.setLength(sb.length() - 1);
                sb.append("\n");
                return sb.toString();
            }

            if(curMoveCount == 4){
                continue;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 8; j++) {
                    int nr = cr + dr[i] * j;
                    int nc = cc + dc[i] * j;

                    if(0 <= nr && nr < 8 && 0 <= nc && nc < 8){
                        if(!visited[nr][nc]){
                            visited[nr][nc] = true;

                            MoveRecord newRecord =new MoveRecord(nr, nc, curMoveCount + 1, getClone(curRecord));
                            newRecord.record[curMoveCount + 1][0] = nr;
                            newRecord.record[curMoveCount + 1][1] = nc;
                            dq.add(newRecord);
                        }
                    }
                }
            }
        }

        return null;
    }

    public static int[][] getClone(int[][] origin){
        int row = origin.length;
        int col = origin[0].length;

        int[][] copy = new int [row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][j] = origin[i][j];
            }
        }

        return copy;
    }
}

class MoveRecord{
    int cr;
    int cc;
    int moveCount;
    int[][] record;

    public MoveRecord(int cr, int cc, int moveCount, int[][] record) {
        this.cr = cr;
        this.cc = cc;
        this.moveCount = moveCount;
        this.record = record;
    }
}
