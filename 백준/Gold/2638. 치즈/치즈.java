import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] dices;
    static int[][] cheeses;
    static boolean[][] visited;
    static HashSet<Integer> unMeltedCheese = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);

        cheeses = new int[N][M];

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                cheeses[i][j] = Integer.parseInt(ipts[j]);
                if(cheeses[i][j] == 1) unMeltedCheese.add(i * M + j);
            }
        }

        int answer = 0;
        while(!unMeltedCheese.isEmpty()){
            checkOuterAir();
            cheeseMelt();
            answer++;
        }

        System.out.println(answer);
    }

    public static void checkOuterAir(){
        boolean[][] isOuterAir = new boolean[N][M];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        isOuterAir[0][0] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            int r = cur / M;
            int c = cur % M;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
                if(isOuterAir[nr][nc] || cheeses[nr][nc] == 1) continue;
                isOuterAir[nr][nc] = true;
                queue.add(nr * M + nc);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(isOuterAir[i][j]) cheeses[i][j] = 2;
            }
        }
    }

    public static void cheeseMelt(){
        visited = new boolean[N][M];
        visited[0][0] = true;
        Deque<Integer> meltingCheese = new ArrayDeque<>();
        if(unMeltedCheese.isEmpty()) return;

        for (int loc:unMeltedCheese){
            int r = loc / M;
            int c = loc % M;
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
                if(cheeses[nr][nc] == 2) cnt++;
            }
            if (cnt >= 2){
                meltingCheese.add(loc);
            }
        }

        while(!meltingCheese.isEmpty()){
            int cur = meltingCheese.poll();
            int r = cur / M;
            int c = cur % M;
            cheeses[r][c] = 0;
            unMeltedCheese.remove(cur);
        }
    }
}
