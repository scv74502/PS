import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0, -1, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        int startR = 0, startC = 0, endR = 0, endC = 0;
        Queue<int[]> waterQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String ipt = br.readLine();
            for (int j = 0; j < ipt.length(); j++) {
                map[i][j] = ipt.charAt(j);
                if(map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }

                if(map[i][j] == 'D') {
                    endR = i;
                    endC = j;
                }

                if(map[i][j] == '*'){
                    waterQueue.add(new int[] {i, j});
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startR, startC, 0});
        visited[startR][startC] = true;

        boolean isEscaped = false;
        int time = 0;

        while(!queue.isEmpty()) {
            int curWater = waterQueue.size();
            for (int i = 0; i < curWater; i++) {
                int[] cur = waterQueue.poll();
                int cwr = cur[0];
                int cwc = cur[1];

                for (int j = 0; j < 4; j++) {
                    int nwr = cwr + dr[j];
                    int nwc = cwc + dc[j];

                    if(0 <= nwc && nwc < M && 0 <= nwr && nwr < N && map[nwr][nwc] == '.') {
                        map[nwr][nwc] = '*';
                        waterQueue.add(new int[] {nwr, nwc});
                    }
                }
            }

            int curHedgehog = queue.size();
            for (int i = 0; i < curHedgehog; i++) {
                int[] cur = queue.poll();
                int cr = cur[0];
                int cc = cur[1];
                int cTurn = cur[2];

                if(cr == endR && cc == endC){
                    isEscaped = true;
                    System.out.println(time);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nr = cr + dr[j];
                    int nc = cc + dc[j];

                    if(0 <= nc && nc < M && 0 <= nr && nr < N && !visited[nr][nc]) {
                        if(map[nr][nc] == '.' || map[nr][nc] == 'D'){
                            queue.add(new int[] {nr, nc, cTurn + 1});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            time++;
        }

        System.out.println("KAKTUS");
    }
}