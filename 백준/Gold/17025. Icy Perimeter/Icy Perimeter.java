import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int maxAmount = 0;
    static int minWidth = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] fridge;
    static boolean[][] checkedBfs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        fridge = new char[N][N];
        checkedBfs = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String ipt = br.readLine();
            for (int j = 0; j < N; j++) {
                fridge[i][j] = ipt.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!checkedBfs[i][j] && fridge[i][j] == '#'){
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxAmount).append(" ").append(minWidth);
        System.out.println(sb);
    }

    public static void bfs(int r, int c){
        int area = 0;
        int width = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{r, c});
        checkedBfs[r][c] = true;

        while(!deque.isEmpty()){
            int cr = deque.peek()[0];
            int cc = deque.peek()[1];
            deque.poll();
            area++;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || N <= nr || nc < 0 || N <= nc) {
                    width++;
                    continue;
                }

                if(fridge[nr][nc] == '#' && checkedBfs[nr][nc]) continue;
                else if(fridge[nr][nc] == '#' && !checkedBfs[nr][nc]){
                    checkedBfs[nr][nc] = true;
                    deque.add(new int[]{nr, nc});
                }

                if(fridge[nr][nc] == '.'){
                    width++;
                }
            }
        }

        if(maxAmount < area){
            maxAmount = area;
            minWidth = width;
        } else if(maxAmount == area){
            minWidth = Math.min(minWidth, width);
        }
    }
}
