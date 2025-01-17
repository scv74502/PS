import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K;
    // 우 좌 상 하
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] board;
    static int[][] temperature;
    static boolean[][][] walls;
    static ArrayList<int[]> checkList = new ArrayList<>();
    static ArrayList<int[]> heaters = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        // 지도 정보
        R = Integer.parseInt(ipts[0]);
        C = Integer.parseInt(ipts[1]);
        K = Integer.parseInt(ipts[2]);

        board = new int[R][C];
        temperature = new int[R][C];
        walls = new boolean[R][C][4];

        for (int i = 0; i < R; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        // 벽 정보
        int w = Integer.parseInt(br.readLine());

        int r, c, t;

        // 벽 설치
        for (int i = 0; i < w; i++) {
            ipts = br.readLine().split(" ");
            r = Integer.parseInt(ipts[0]);
            c = Integer.parseInt(ipts[1]);
            t = Integer.parseInt(ipts[2]);

            if(t == 0){
                walls[r-1][c-1][2] = true;
                walls[r-2][c-1][3] = true;
            } else if(t == 1){
                walls[r-1][c-1][0] = true;
                walls[r-1][c][1] = true;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(1 <= board[i][j] && board[i][j] <= 4){
                    heaters.add(new int[] {i, j, board[i][j] - 1});
                } else if (board[i][j] == 5){
                    checkList.add(new int[] {i, j});
                }
            }
        }

        int answer = 0;
        while(true){
            for(int[] heater:heaters){
                heatOn(heater[0], heater[1], heater[2]);
            }

            spreadTemperature();

            lowEdgeHeat();

            answer += 1;

            if(checkTarget()){
                System.out.println(answer);
                return;
            }

            if(answer == 100){
                System.out.println(101);
                return;
            }
        }

    }

    // 온풍기에서 바람이 나오는 함수
    static void heatOn(int r, int c, int dir){
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        // 범위 체크
        if(nr < 0 || R <= nr || nc < 0 || C <= nc) return;

        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        visited[nr][nc] = true;
        // queue에 최초 위치 넣고 bfs 탐색
        queue.add(new int[] {nr, nc, 5});

        while (!queue.isEmpty()){
            int[] current = queue.pollFirst();
            r = current[0];
            c = current[1];
            int value = current[2];

            temperature[r][c] += value;
            // visited[r][c] = true;

            // 오른쪽 방향 온도 전달
            if(dir == 0){
                // (r, c) -> (r-1, c+1)
                if(r - 1 >= 0 && c + 1 < C && !visited[r - 1][c + 1]){
                    if(!walls[r][c][2] && !walls[r-1][c][0]){
                        visited[r - 1][c + 1] = true;
                        if(value > 1) queue.add(new int[] {r - 1, c + 1, value - 1});
                    }
                }

                // (r, c) -> (r, c+1)
                if(c + 1 < C && !visited[r][c+1]){
                    if(!walls[r][c][0]){
                        visited[r][c+1] = true;
                        if(value > 1) queue.add(new int[] {r, c + 1, value - 1});
                    }
                }

                // (r, c) -> (r+1, c+1)
                if(r + 1 < R && c + 1 < C && !visited[r+1][c+1]){
                    if(!walls[r][c][3] && !walls[r+1][c][0]){
                        visited[r+1][c+1] = true;
                        if(value > 1) queue.add(new int[] {r + 1, c + 1, value - 1});
                    }
                }
            }

            // 왼른쪽 방향 온도 전달
            else if(dir == 1){
                // (r, c) -> (r-1, c-1)
                if(r - 1 >= 0 && c - 1 >= 0 && !visited[r - 1][c - 1]){
                    if(!walls[r][c][2] && !walls[r-1][c][1]){
                        visited[r - 1][c - 1] = true;
                        if(value > 1) queue.add(new int[] {r - 1, c - 1, value - 1});
                    }
                }

                // (r, c) -> (r, c-1)
                if(c - 1 >= 0 && !visited[r][c-1]){
                    if(!walls[r][c][1]){
                        visited[r][c-1] = true;
                        if(value > 1) queue.add(new int[] {r, c - 1, value - 1});
                    }
                }

                // (r, c) -> (r+1, c-1)
                if(r + 1 < R && c - 1 >= 0 && !visited[r+1][c-1]){
                    if(!walls[r][c][3] && !walls[r+1][c][1]){
                        visited[r+1][c-1] = true;
                        if(value > 1) queue.add(new int[] {r + 1, c - 1, value - 1});
                    }
                }
            }

            // 위쪽 방향 온도 전달
            else if(dir == 2){
                // (r, c) -> (r-1, c-1)
                if(r - 1 >= 0 && c - 1 >= 0 && !visited[r - 1][c - 1]){
                    if(!walls[r][c][1] && !walls[r][c - 1][2]){
                        visited[r - 1][c - 1] = true;
                        if(value > 1) queue.add(new int[] {r - 1, c - 1, value - 1});
                    }
                }

                // (r, c) -> (r - 1, c)
                if(r -1 >= 0 && !visited[r - 1][c]){
                    if(!walls[r][c][2]){
                        visited[r - 1][c] = true;
                        if(value > 1) queue.add(new int[] {r - 1, c, value - 1});
                    }
                }

                // (r, c) -> (r-1, c+1)
                if(r - 1 >= 0 && c + 1 < C && !visited[r-1][c+1]){
                    if(!walls[r][c][0] && !walls[r][c + 1][2]){
                        visited[r-1][c+1] = true;
                        if(value > 1) queue.add(new int[] {r - 1, c + 1, value - 1});
                    }
                }
            }

            // 아래쪽 방향 온도 전달
            else if(dir == 3){
                // (r, c) -> (r+1, c-1)
                if(r + 1 < R && c - 1 >= 0 && !visited[r + 1][c - 1]){
                    if(!walls[r][c][1] && !walls[r][c - 1][3]){
                        visited[r + 1][c - 1] = true;
                        if(value > 1) queue.add(new int[] {r + 1, c - 1, value - 1});
                    }
                }

                // (r, c) -> (r + 1, c)
                if(r + 1 < R && !visited[r + 1][c]){
                    if(!walls[r][c][3]){
                        visited[r + 1][c] = true;
                        if(value > 1) queue.add(new int[] {r + 1, c, value - 1});
                    }
                }

                // (r, c) -> (r+1, c+1)
                if(r + 1 < R && c + 1 < C && !visited[r+1][c+1]){
                    if(!walls[r][c][0] && !walls[r][c + 1][3]){
                        visited[r+1][c+1] = true;
                        if(value > 1) queue.add(new int[] {r + 1, c + 1, value - 1});
                    }
                }
            }
        }
    }

    // 온도 조절 과정 시뮬레이션
    static void spreadTemperature(){
        int[][] changeTemperatureBoard = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];

                    if(0 <= nr && nr < R && 0 <= nc && nc < C){
                        if(walls[i][j][dir]) continue;
                        if(temperature[i][j] > temperature[nr][nc]){
                            int diff = (temperature[i][j] - temperature[nr][nc]) / 4;
                            changeTemperatureBoard[i][j] -= diff;
                            changeTemperatureBoard[nr][nc] += diff;
                        }
                    }
                }
            }
        }

        // 원래 온도값에 변경된 값 업데이트
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temperature[i][j] += changeTemperatureBoard[i][j];
            }
        }
    }

    // 가장 바깥쪽 칸의 온도 감소
    static void lowEdgeHeat(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(i == 0 || i == R - 1|| j == 0 || j == C - 1){
                    if(temperature[i][j] > 0) temperature[i][j] -= 1;
                }
            }
        }
    }

    // 조사 대상 온도 확인하는 함수
    static boolean checkTarget(){
        for (int[] target:checkList){
            if(temperature[target[0]][target[1]] < K){
                return false;
            }
        }
        return true;
    }
}
