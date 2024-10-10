import java.io.*;
import java.util.*;

public class Main {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int curX, curY, curDist, nx, ny, nd;
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] ipts = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        // dist 대신 방문 여부
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++){

            for(int j = 0; j < N; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        // x, y, 경사를 저장함
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]){
                    if(o1[0] == o2[0]){
                        return o1[1] - o2[1];
                    } else{
                        return o1[0] - o2[0];
                    }
                } else{
                    return o1[2] - o2[2];
                }
            }
        });
        pq.add(new int[] {0, 0, 0});

        while(!pq.isEmpty()){
            curX = pq.peek()[0];
            curY = pq.peek()[1];
            curDist = pq.peek()[2];
            pq.poll();

            if(dist[curX][curY] < curDist){
                continue;
            }

            for(int m = 0; m < 4; m++){
                nx = curX + dx[m];
                ny = curY + dy[m];

                if(0 <= nx && nx < N && 0 <= ny && ny < N){
                    nd = Math.max(Math.abs(map[nx][ny] - map[curX][curY]), curDist);
                    if(nd < dist[nx][ny]){
                        dist[nx][ny] = nd;
                        pq.add(new int[] {nx, ny, nd});
                    }
                }
            }
        }

        System.out.println(dist[N-1][N-1]);
    }
}

