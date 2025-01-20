import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static HashMap<Integer, int[]> customers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);
        int initialFuel = Integer.parseInt(ipts[2]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        ipts = br.readLine().split(" ");
        int curRow = Integer.parseInt(ipts[0]) - 1;
        int curCol = Integer.parseInt(ipts[1]) - 1;

        customers = new HashMap<>();

        int rLoc, cLoc, rDest, cDest;
        for (int i = 0; i < M; i++) {
            ipts = br.readLine().split(" ");
            rLoc = Integer.parseInt(ipts[0]) - 1;
            cLoc = Integer.parseInt(ipts[1]) - 1;
            rDest = Integer.parseInt(ipts[2]) - 1;
            cDest = Integer.parseInt(ipts[3]) - 1;


            customers.put(rLoc * N + cLoc, new int[] {rLoc, cLoc, rDest, cDest});
        }

        while(!customers.isEmpty()){
            // 승객 위치한 행, 열과 거리르 반환받는다
            int[] current = findCustomer(curRow, curCol);
            // 해당 위치의 승객 현재행, 현재열, 도착지행, 도착지열
            curRow = current[0];
            curCol = current[1];
            // 승객 태우러 갈 때의 연료 소모량
            int takingFuelConsumption = current[2];

            int[] customerInfo = customers.get((current[0] * N + current[1]));
            // 이제 승객 제거하기
            customers.remove(current[0] * N + current[1]);

            if(initialFuel < takingFuelConsumption || takingFuelConsumption == -1){
                System.out.println(-1);
                return;
            }
            initialFuel -= takingFuelConsumption;

            int destFuelConsumption = findDestDist(customerInfo[0], customerInfo[1], customerInfo[2], customerInfo[3]);
            if(initialFuel < destFuelConsumption || destFuelConsumption == -1){
                System.out.println(-1);
                return;
            }
            initialFuel += destFuelConsumption;

            curRow = customerInfo[2];
            curCol = customerInfo[3];
        }

        System.out.println(initialFuel);
    }

    public static int[] findCustomer(int startR, int startC){
        boolean[][] visited = new boolean[N][N];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {startR, startC, 0});
        visited[startR][startC] = true;
        int curMinDist = Integer.MAX_VALUE;
        int[] answer = {startR, startC, Integer.MAX_VALUE};
        boolean foundCustomer = false;

        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            int curDist = cur[2];

            if(curDist > curMinDist) continue;  // 최단거리보다 큰 경우는 더 볼 필요 없음


            int loc = cr * N + cc;
            if(customers.containsKey(loc)){
                foundCustomer = true;
                if(curDist < curMinDist){
                    curMinDist = curDist;
                    answer[0] = cr;
                    answer[1] = cc;
                    answer[2] = curDist;
                } else {
                    if(cr < answer[0] || (cr == answer[0] && cc < answer[1])){
                        answer[0] = cr;
                        answer[1] = cc;
                        answer[2] = curDist;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                // 범위 체크
                if(nr < 0 || N <= nr || nc < 0 || N <= nc || visited[nr][nc] || map[nr][nc] == 1) continue;

                deque.add(new int[] {nr, nc, curDist+1});
                visited[nr][nc] = true;
            }
        }

        return foundCustomer ? answer : new int[] {-1, -1, -1};
    }

    public static int findDestDist(int startR, int startC, int destR, int destC){
        boolean[][] visited = new boolean[N][N];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {startR, startC, 0});
        visited[startR][startC] = true;

        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int cr = cur[0];
            int cc = cur[1];
            int curDist = cur[2];

            if(cr == destR && cc == destC){
                return curDist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                // 범위 체크
                if(nr < 0 || N <= nr || nc < 0 || N <= nc || visited[nr][nc] || map[nr][nc] == 1) continue;

                deque.add(new int[] {nr, nc, curDist+1});
                visited[nr][nc] = true;
            }
        }

        return -1;
    }
}
