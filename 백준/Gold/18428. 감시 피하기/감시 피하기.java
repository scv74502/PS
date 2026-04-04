import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static boolean result = false;
    // 변경: 큐 대신 리스트를 사용하여 단순 데이터 보관 및 순회에 최적화
    static ArrayList<int[]> teachers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'T') teachers.add(new int[] {i, j});
            }
        }

        // 1차원 인덱스 기준 탐색 시작점 0 전달
        bt(0, 0, 0);

        System.out.println(result ? "YES" : "NO");
    }

    public static void bt(int block, int r, int c){
        if(block == 3){
            if(check()) result = true;
            return;
        }

        for (int i = r; i < N; i++) {
            for (int j = c; j < N; j++) {
                if(map[i][j] != 'X') continue;
                map[i][j] = 'B';
                bt(block + 1, r, c);
                map[i][j] = 'X';
            }
        }
    }

    public static boolean check() {
        // 리스트를 순회하며 각 선생님의 위치에서 검사
        for (int[] teacher : teachers) {
            int tr = teacher[0];
            int tc = teacher[1];

            for (int j = tc + 1; j < N; j++) {
                if(map[tr][j] == 'B') break;
                if(map[tr][j] == 'S') return false;
            }

            for (int j = tc - 1; j >= 0; j--) {
                if(map[tr][j] == 'B') break;
                if(map[tr][j] == 'S') return false;
            }

            for (int j = tr + 1; j < N; j++) {
                if(map[j][tc] == 'B') break;
                if(map[j][tc] == 'S') return false;
            }

            for (int j = tr - 1; j >= 0; j--) {
                if(map[j][tc] == 'B') break;
                if(map[j][tc] == 'S') return false;
            }
        }

        return true;
    }
}