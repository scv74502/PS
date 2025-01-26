import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    // 상 하 좌 우 좌상 우상 좌하 우하
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static char[][] map;
    static int[][] heightMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        heightMap = new int[N][N];

        int sr = 0, sc = 0, target = 0;

        for (int i = 0; i < N; i++) {
            ipt = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = ipt.charAt(j);
                if(map[i][j] == 'P'){
                    sr = i;
                    sc = j;
                } else if(map[i][j] == 'K'){
                    target++;
                }
            }
        }

        int maxHeight = -1, minHeight = Integer.MAX_VALUE;
        List<Integer> heightList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                heightMap[i][j] = Integer.parseInt(ipts[j]);
                heightList.add(heightMap[i][j]);
                if(map[i][j] == 'P' || map[i][j] == 'K'){
                    maxHeight = Math.max(maxHeight, heightMap[i][j]);
                    minHeight = Math.min(minHeight, heightMap[i][j]);
                }
            }
        }

        Collections.sort(heightList);
        int lowest = 0;
        int highest = heightList.indexOf(maxHeight);
        int lowestIdx = heightList.indexOf(minHeight);
        int highestIdx = heightList.size();
        int result = Integer.MAX_VALUE;
        while(lowest <= lowestIdx && lowest <= highest && highest < highestIdx){
            int left = heightList.get(lowest);
            int right = heightList.get(highest);
            if(bfs(sr, sc, left, right, target) == 0){
                result = Math.min(result, (right - left));
                lowest++;
            } else {
                highest++;
            }
        }

        System.out.println(result);
    }

    static int bfs(int r, int c, int lowest, int highest, int target){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0], cc = cur[1];

            if(target == 0) return target;

            for(int d=0; d<8; d++) {
                int nr = cr+dr[d];
                int nc = cc+dc[d];

                if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;
                if(visited[nr][nc] || heightMap[nr][nc] < lowest || highest < heightMap[nr][nc]) continue;

                visited[nr][nc] = true;
                if(map[nr][nc] == 'K') {
                    target--;
                }
                queue.add(new int[] {nr,nc});
            }
        }
        return target;
    }
}
