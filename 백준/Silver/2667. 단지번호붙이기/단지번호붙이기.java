import java.io.*;
import java.util.*;

public class Main {
    // 상 하 좌 우
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static int[][] grid;
    public static boolean[][] visited;
    public static int N;
    
    public static int bfs(int sy, int sx){
        int[] cur;
        int cy, cx, ny, nx;
        int cnt = 0;

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sy, sx});
        visited[sy][sx] = true;
        
        while(!dq.isEmpty()){
            cur = dq.pollFirst();
            cy = cur[0];
            cx = cur[1];
            cnt++;
            
            for(int mv = 0; mv < 4; mv++){
                ny = cy + dy[mv];
                nx = cx + dx[mv];

                if(0 <= ny &&  ny < N && 0 <= nx && nx < N){
                    if(!visited[ny][nx] && grid[ny][nx] == 1){
                        visited[ny][nx] = true;
                        dq.add(new int[] {ny, nx});
                    }
                }
            }
        }
        
        return cnt;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;
        String ipt;

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            ipt = br.readLine().strip();
            for(int j = 0; j < N; j++){
                grid[i][j] = ipt.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && grid[i][j] == 1) {
                    pq.add(bfs(i, j));
                }
            }
        }

        sb.append(pq.size());
        sb.append("\n");

        while(!pq.isEmpty()){
            sb.append(pq.poll());
            if(pq.peek() != null){
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
