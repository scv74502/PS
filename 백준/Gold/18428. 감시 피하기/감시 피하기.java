import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static boolean result = false;
    static ArrayDeque<int[]> teachers = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'T') teachers.add(new int[] {i, j});
            }
        }

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

    public static boolean check(){
        int size = teachers.size();

        for (int i = 0; i < size; i++) {
            int tr = teachers.peek()[0];
            int tc = teachers.peek()[1];
            teachers.add(teachers.poll());

            for (int j = tc + 1; j < N; j++) {
                if(map[tr][j] == 'T' ||map[tr][j] == 'B') break;
                if(map[tr][j] == 'S') return false;
            }

            for (int j = tc - 1; j >= 0; j--) {
                if(map[tr][j] == 'T' ||map[tr][j] == 'B') break;
                if(map[tr][j] == 'S') return false;
            }

            for (int j = tr + 1; j < N; j++) {
                if(map[j][tc] == 'T' ||map[j][tc] == 'B') break;
                if(map[j][tc] == 'S') return false;
            }

            for (int j = tr - 1; j >= 0; j--) {
                if(map[j][tc] == 'T' ||map[j][tc] == 'B') break;
                if(map[j][tc] == 'S') return false;
            }
        }

        return true;
    }
}
