import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int[][] map;
    static int n, minWL, maxCore;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<core> coreList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = null;
        String[] ipt;

        int TC = Integer.parseInt(br.readLine());
        for (int T = 1; T <= TC; T++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            coreList = new ArrayList<>();
            sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                ipt = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(ipt[j]);

                    if(map[i][j] == 1){
                        if(i == 0 || j == 0 || i == n - 1 || j == n - 1) continue;
                        coreList.add(new core(i, j));
                    }
                }
            }

            minWL = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;

            startConnect(0, 0, 0);

            sb.append("#").append(T).append(" ").append(minWL).append("\n");
            bw.write(sb.toString());
            bw.flush();
        }
    }

    public static void startConnect(int idx, int coreCnt, int wireCnt){
        if(idx == coreList.size()){
            if(maxCore < coreCnt){
                maxCore = coreCnt;
                minWL = wireCnt;
            } else if(maxCore == coreCnt){
                minWL = Math.min(wireCnt, minWL);
            }
            return;
        }

        int x = coreList.get(idx).x;
        int y = coreList.get(idx).y;

        for(int d = 0; d < 4; d++){
            int count = 0;
            int nx = x;
            int ny = y;

            while(true){
                nx += dx[d];
                ny += dy[d];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                    break;
                }

                if(map[nx][ny] == 1){
                    count = 0;
                    break;
                }
                count++;
            }

            int fill_x = x;
            int fill_y = y;

            for (int i = 0; i < count; i++) {
                fill_x += dx[d];
                fill_y += dy[d];
                map[fill_x][fill_y] = 1;
            }
            if(count == 0) startConnect(idx+1, coreCnt, wireCnt);
            else{
                startConnect(idx+1, coreCnt+1, wireCnt + count);

                fill_x = x;
                fill_y = y;

                for (int i = 0; i < count; i++) {
                    fill_x += dx[d];
                    fill_y += dy[d];
                    map[fill_x][fill_y] = 0;
                }
            }
        }


    }

    static class core{
        int x;
        int y;

        public core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
