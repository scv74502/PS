import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] board;
    static HashMap<Character, Boolean> key;

    public static int findDoc(int h, int w) {
        ArrayList<int[]> foundDoc = new ArrayList<>();  // 획득한 문서 정보 저장
        boolean[][] visited = new boolean[h + 2][w + 2];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == '*') continue;  // 벽을 만났을 경우

                // 문을 만났을 경우
                if ('A' <= board[nx][ny] && board[nx][ny] <= 'Z') {
                    char requiredKey = (char)(board[nx][ny] + 32);
                    if (!key.containsKey(requiredKey)) continue;
                }
                // 열쇠를 만났을 경우
                else if ('a' <= board[nx][ny] && board[nx][ny] <= 'z') {
                    if (!key.containsKey(board[nx][ny])) {
                        key.put(board[nx][ny], true);
                        visited = new boolean[h + 2][w + 2];  // 방문 배열 초기화
                    }
                }
                // 문서를 만났을 경우
                else if (board[nx][ny] == '$') {
                    boolean alreadyFound = false;
                    for (int[] doc : foundDoc) {
                        if (doc[0] == nx && doc[1] == ny) {
                            alreadyFound = true;
                            break;
                        }
                    }
                    if (!alreadyFound) {
                        foundDoc.add(new int[]{nx, ny});
                    }
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        return foundDoc.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] hw = br.readLine().split(" ");
            int h = Integer.parseInt(hw[0]);
            int w = Integer.parseInt(hw[1]);

            // 평면도 정보 입력 (가장자리를 .로 감싸기)
            board = new char[h + 2][w + 2];
            Arrays.fill(board[0], '.');  // 첫 행
            Arrays.fill(board[h + 1], '.');  // 마지막 행

            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                board[i][0] = '.';  // 첫 열
                for (int j = 0; j < w; j++) {
                    board[i][j + 1] = line.charAt(j);
                }
                board[i][w + 1] = '.';  // 마지막 열
            }

            // 소유한 열쇠 정보 저장
            key = new HashMap<>();
            String keyInput = br.readLine();
            if (!keyInput.equals("0")) {
                for (char c : keyInput.toCharArray()) {
                    key.put(c, true);
                }
            }

            System.out.println(findDoc(h, w));
        }
        br.close();
    }
}