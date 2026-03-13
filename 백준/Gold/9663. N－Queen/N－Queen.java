import java.io.*;

public class Main {
    static int N;
    static int answer = 0;
    static boolean[] isColUsed;   // 열 체크
    static boolean[] isDiag1Used; // / 대각선 체크 (row + col)
    static boolean[] isDiag2Used; // \ 대각선 체크 (row - col + N-1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isColUsed = new boolean[N];
        isDiag1Used = new boolean[2 * N - 1];
        isDiag2Used = new boolean[2 * N - 1];

        bt(0);

        System.out.println(answer);
    }

    public static void bt(int curRow) {
        if (curRow == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isColUsed[i] && !isDiag1Used[curRow + i] && !isDiag2Used[curRow - i + N - 1]) {
                // 상태 변경 (방문 표시)
                isColUsed[i] = isDiag1Used[curRow + i] = isDiag2Used[curRow - i + N - 1] = true;
                bt(curRow + 1);
                isColUsed[i] = isDiag1Used[curRow + i] = isDiag2Used[curRow - i + N - 1] = false;
            }
        }
    }
}