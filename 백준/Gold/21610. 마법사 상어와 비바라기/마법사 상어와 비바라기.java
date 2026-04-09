import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    // 1번부터 좌, 좌상, 상, 우상, 우, 우하, 하, 좌하
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] cloudRespawnLocations;
    static int[][] waterAmount;
    static ArrayDeque<int[]> clouds = new ArrayDeque<>();       // 구름의 위치
    static ArrayDeque<int[]> squareRainQueue = new ArrayDeque<>();  // 주위 대각선에 물이 있어서 물이 증가할 지역
    static ArrayDeque<int[]> rainingLocation = new ArrayDeque<>();  // 비가 내려 물이 증가한 지역
    static HashSet<Integer> cloudDisappearedLoc = new HashSet<>();  // 구름이 사라진 지역
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        waterAmount = new int[N][N];
        cloudRespawnLocations = new int[][]{{N - 1, 0}, {N - 1, 1}, {N - 2, 0}, {N - 2, 1}};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                waterAmount[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 비바라기 시전
        rainMagic();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            moveCloud(direction, speed);
            rainFromCloud();
            waterGainMagic();
            respawnCloudFromWater();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += waterAmount[i][j];
            }
        }

        System.out.println(answer);
    }

    static void respawnCloudFromWater(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(waterAmount[i][j] >= 2 && !cloudDisappearedLoc.contains(calcLocIdx(i, j))){
                    waterAmount[i][j] -= 2;
                    clouds.add(new int[] {i, j});
                }
            }
        }
        cloudDisappearedLoc.clear();
    }

    static void waterGainMagic(){
        while(!rainingLocation.isEmpty()){
            int cr = rainingLocation.peek()[0];
            int cc = rainingLocation.peek()[1];
            rainingLocation.poll();

            int gainAmount = 0;

            for (int dir = 2; dir <=8 ; dir+=2) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if(nr < 0 || N <= nr || nc < 0 || N <= nc || waterAmount[nr][nc] == 0) continue;
                gainAmount += 1;
            }

            squareRainQueue.add(new int[] {cr, cc, gainAmount});
        }

        while(!squareRainQueue.isEmpty()){
            int cr = squareRainQueue.peek()[0];
            int cc = squareRainQueue.peek()[1];
            int cAmount = squareRainQueue.peek()[2];
            squareRainQueue.poll();

            waterAmount[cr][cc] += cAmount;
        }
    }

    static void rainFromCloud(){
        while(!clouds.isEmpty()){
            int[] cloud = clouds.poll();
            waterAmount[cloud[0]][cloud[1]]++;
            rainingLocation.add(new int[] {cloud[0], cloud[1]});
            cloudDisappearedLoc.add(calcLocIdx(cloud[0], cloud[1]));
        }
    }

    static void moveCloud(int direction, int speed) {
        int amount = clouds.size();

        for (int i = 0; i < amount; i++) {
            int[] cloud = clouds.poll();
            cloud[0] = getLoc(cloud[0] + speed * dr[direction]);
            cloud[1] = getLoc(cloud[1] + speed * dc[direction]);
            clouds.add(cloud);
        }
    }

    static void rainMagic(){
        for(int[] location: cloudRespawnLocations){
            clouds.add(new int[] {location[0], location[1]});
        }
    }

    static int calcLocIdx(int r, int c){
        return r * N + c;
    }

    static int getLoc(int loc) {
        return (loc % N + N) % N;
    }
}


