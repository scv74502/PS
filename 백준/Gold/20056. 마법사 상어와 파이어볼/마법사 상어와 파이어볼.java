import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    
    // 존재하는 모든 파이어볼을 관리하는 리스트
    static List<FireBall> fireballs = new ArrayList<>();
    // 이동 후 파이어볼이 위치할 2차원 격자
    static Queue<FireBall>[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new LinkedList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            fireballs.add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            moveFireballs();
            mergeAndSplitFireballs();
        }

        int totalMass = 0;
        for (FireBall fb : fireballs) {
            totalMass += fb.mass;
        }
        System.out.println(totalMass);
    }

    // 모든 파이어볼 이동
    static void moveFireballs() {
        for (FireBall fb : fireballs) {
            fb.r = (fb.r + N + (dr[fb.dir] * (fb.speed % N))) % N;
            fb.c = (fb.c + N + (dc[fb.dir] * (fb.speed % N))) % N;
            
            grid[fb.r][fb.c].add(fb);
        }
    }

    // 이동 후 겹치는 파이어볼 분할 및 관리 리스트 갱신
    static void mergeAndSplitFireballs() {
        fireballs.clear(); // 기존 파이어볼 리스트 초기화 (격자에서 다시 추출)

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j].isEmpty()) continue;

                int count = grid[i][j].size();
                // 1개만 있는 경우 그대로 리스트에 추가
                if (count == 1) {
                    fireballs.add(grid[i][j].poll());
                    continue;
                }

                // 2개 이상인 경우 병합 후 분할 로직 수행
                int massSum = 0;
                int speedSum = 0;
                boolean allEven = true;
                boolean allOdd = true;

                while (!grid[i][j].isEmpty()) {
                    FireBall cur = grid[i][j].poll();
                    massSum += cur.mass;
                    speedSum += cur.speed;

                    if (cur.dir % 2 == 0) allOdd = false;
                    else allEven = false;
                }

                int nextMass = massSum / 5;
                if (nextMass == 0) continue; // 질량이 0이면 소멸

                int nextSpeed = speedSum / count;
                int[] nextDirs = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};

                for (int d : nextDirs) {
                    fireballs.add(new FireBall(i, j, nextMass, nextSpeed, d));
                }
            }
        }
    }

    static class FireBall {
        int r, c, mass, speed, dir;

        public FireBall(int r, int c, int mass, int speed, int dir) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.speed = speed;
            this.dir = dir;
        }
    }
}