import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int icebergCount;
        int answer = 0;
        while ((icebergCount = bfs()) == 1) {
            iceMelt();
            answer++;
        }
        
        if (icebergCount == 0) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }

    public static void iceMelt(){
        int[][] meltAmount = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(0 <= nr && 0 <= nc && nr < N && nc < M && map[nr][nc] == 0){
                            meltAmount[i][j]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = Math.max(0, map[i][j] - meltAmount[i][j]);
            }
        }
//        System.out.println(Arrays.deepToString(map));
    }

    public static int bfs(){
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0 && !visited[i][j]){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    count++;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int cr = cur[0];
                        int cc = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int nr = cr + dr[k];
                            int nc = cc + dc[k];
                            if(nr < 0 || nc < 0 || N <= nr || M <= nc || visited[nr][nc]) continue;
                            if(map[nr][nc] > 0) {
                                q.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}