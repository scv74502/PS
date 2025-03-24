import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sc = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());

            for (int j = sr; j < er; j++) {
                for (int k = sc; k < ec; k++) {
                    visited[j][k] = true;
                }
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    int result = bfs(i, j);
                    answerList.add(result);
                }
            }
        }

        Collections.sort(answerList);

        System.out.println(answerList.size());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < answerList.size(); i++) {
            sb.append(answerList.get(i));
            if(i != answerList.size() - 1) sb.append(" ");
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }

    public static int bfs(int sr, int sc){
        int area = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sr, sc});
        visited[sr][sc] = true;

        while(!queue.isEmpty()){
            int cr = queue.peek()[0];
            int cc = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || nc < 0 || M <= nr || N <= nc || visited[nr][nc]) continue;

                queue.add(new int[] {nr, nc});
                visited[nr][nc] = true;
                area++;
            }
        }

        return area;
    }
}
