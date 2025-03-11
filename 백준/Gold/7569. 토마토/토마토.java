import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 0, -1, 1};
    static int[][][] box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        int result = bfs();
        System.out.println(result);
    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(box[i][j][k] == 1){
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int ch = arr[0];
            int cr = arr[1];
            int cc = arr[2];

            for (int i = 0; i < 6; i++) {
                int nh = ch + dh[i];
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(0 <= nh && 0 <= nr && 0 <= nc && nh < H && nr < N && nc < M && box[nh][nr][nc] != -1){
                    if(box[nh][nr][nc] == 0){
                        box[nh][nr][nc] = box[ch][cr][cc] + 1;
                        q.add(new int[] {nh, nr, nc, box[nh][nr][nc]});
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    answer = Math.max(answer, box[i][j][k]);
                    if(box[i][j][k] == 0){
                        return -1;
                    }
                }
            }
        }

        return answer - 1;
    }
}
