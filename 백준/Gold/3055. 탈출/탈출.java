import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());

        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        int startR = 0, startC = 0, endR = 0, endC = 0;
        ArrayDeque<int[]> waterQueue = new ArrayDeque<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String ipt = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = ipt.charAt(j);
                if(map[i][j] == 'S'){
                    startR = i;
                    startC = j;
                    queue.add(new int[] {startR, startC, 0});
                    visited[i][j] = true;
                }

                if(map[i][j] == 'D'){
                    endR = i;
                    endC = j;
                }

                if(map[i][j] == '*'){
                    waterQueue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int waterQueueSize = waterQueue.size();
            for (int i = 0; i < waterQueueSize; i++) {
                int[] cur = waterQueue.poll();
                int cr = cur[0];
                int cc = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];

                    if(0 <= nr && 0 <= nc && nr < R && nc < C){
                        if(map[nr][nc] == '.'){
                            waterQueue.add(new int[] {nr, nc});
                            map[nr][nc] = '*';
                        }
                    }
                }
            }

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] cur = queue.poll();
                int cr = cur[0];
                int cc = cur[1];
                int cTime = cur[2];

                if(cr == endR && cc == endC){
                    System.out.println(cTime);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];

                    if(0 <= nr && 0 <= nc && nr < R && nc < C){
                        if(!visited[nr][nc] && map[nr][nc] == '.' || map[nr][nc] == 'D'){
                            queue.add(new int[] {nr, nc, cTime+1});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }
}
