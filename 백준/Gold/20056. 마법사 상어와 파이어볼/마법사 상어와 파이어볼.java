import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    // 순서대로 위, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] fireballCountArray;
    static ArrayDeque<FireBall> moveFireBallQueue = new ArrayDeque<>();
    static ArrayDeque<int[]> splitFireBallQueue = new ArrayDeque<>();
//    static ArrayList<FireBall> fireballArr;
    static HashMap<Integer, ArrayDeque<FireBall>> locationFireballMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fireballCountArray = new int[N][N];
//        fireballArr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int loc = i * N + j;
                locationFireballMap.put(loc, new ArrayDeque<>());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireballCountArray[r][c] += 1;
//            fireballArr.add(new FireBall(r, c, m, s, d));

            int loc = r * N + c;
            locationFireballMap.get(loc).add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            fireballMove();
            if(!isSplitNeeded()) continue;
            splitFireBall();
        }

        System.out.println(getFireBallMassSum());
    }

    // 파이어볼의 이동
    static void fireballMove(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int loc = i * N + j;
                if(locationFireballMap.get(loc).isEmpty()) continue;
                int queueSize = locationFireballMap.get(loc).size();
                for (int k = 0; k < queueSize; k++) {
                    FireBall cur = locationFireballMap.get(loc).poll();
                    moveFireBallQueue.add(cur);
                }
            }
        }

        while(!moveFireBallQueue.isEmpty()){
            FireBall cur = moveFireBallQueue.poll();
            int nr = calcLoc(cur.r + cur.speed * dr[cur.dir]);
            int nc = calcLoc(cur.c + cur.speed * dc[cur.dir]);

            cur.r = nr;
            cur.c = nc;

            int nextLoc = nr * N + nc;
            locationFireballMap.get(nextLoc).add(cur);
        }
    }

    // 분할이 필요한지 체크
    static boolean isSplitNeeded(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int loc = i * N + j;
                if(locationFireballMap.get(loc).size() >= 2) splitFireBallQueue.add(new int[] {i, j});
            }
        }

        return !splitFireBallQueue.isEmpty();
    }


    static void splitFireBall() {
        while (!splitFireBallQueue.isEmpty()) {
            int[] curLoc = splitFireBallQueue.poll();
            int i = curLoc[0];
            int j = curLoc[1];
            int loc = i * N + j;

            ArrayDeque<FireBall> currentQueue = locationFireballMap.get(loc);
            int fireBallCnt = currentQueue.size();

            int massSum = 0;
            int speedSum = 0;
            boolean allEven = true;
            boolean allOdd = true;

            // 해당 칸의 모든 파이어볼을 꺼내며 정보 합산
            while (!currentQueue.isEmpty()) {
                FireBall cur = currentQueue.poll();
                massSum += cur.mass;
                speedSum += cur.speed;

                if (cur.dir % 2 == 0) allOdd = false;
                else allEven = false;
            }

            // 나누어진 파이어볼의 질량 및 스피드 계산
            int nextMass = massSum / 5;
            // 나누어진 파이어볼 질량이 0이면 소멸
            if (nextMass == 0) continue;

            int nextSpeed = speedSum / fireBallCnt;

            // 모두 짝수이거나 모두 홀수이면 0, 2, 4, 6 아니면 1, 3, 5, 7
            int[] nextDirs = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};

            // 생성된 4개의 파이어볼을 현재 위치(loc)에 추가
            for (int k = 0; k < 4; k++) {
                currentQueue.add(new FireBall(i, j, nextMass, nextSpeed, nextDirs[k]));
            }
        }
    }

    // r, c 모두 공용사용 가능한 좌표계산 함수
    static int calcLoc(int loc) {
        return (loc % N + N) % N;
    }

    // 남은 파이어볼 질량 총합
    static int getFireBallMassSum(){
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int loc = i * N + j;
                if(locationFireballMap.get(loc).isEmpty()) continue;
                int queueSize = locationFireballMap.get(loc).size();
                for (int k = 0; k < queueSize; k++) {
                    answer += locationFireballMap.get(loc).peek().mass;
                    locationFireballMap.get(loc).add(locationFireballMap.get(loc).poll());
                }
            }
        }

        return answer;
    }

    static class FireBall{
        int r;  // 행
        int c;  // 열
        int mass;   // 질량
        int speed;  // 속도
        int dir;    // 방향

        public FireBall(int r, int c, int mass, int speed, int dir) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.speed = speed;
            this.dir = dir;
        }
    }
}