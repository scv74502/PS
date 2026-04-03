import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] iptArr = br.readLine().split(" ");

        int H = Integer.parseInt(iptArr[0]);
        int W = Integer.parseInt(iptArr[1]);
        int X = Integer.parseInt(iptArr[2]);
        int Y = Integer.parseInt(iptArr[3]);

        int[][] createdArr = new int[H + X][W + Y];
        int[][] originalArr = new int[H][W];

        for (int i = 0; i < H + X; i++) {
            iptArr = br.readLine().split(" ");
            for (int j = 0; j < W + Y; j++) {
                createdArr[i][j] = Integer.parseInt(iptArr[j]);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 겹치는 영역인지 판단 (A[i][j]와 A[i-X][j-Y]가 겹치는 지점)
                if (i >= X && j >= Y) {
                    // 겹치는 영역이면 B[i][j]에서 이미 복원된 A[i-X][j-Y]를 뺌
                    originalArr[i][j] = createdArr[i][j] - originalArr[i - X][j - Y];
                } else {
                    // 겹치지 않는 영역은 B[i][j] 값이 곧 A[i][j]
                    originalArr[i][j] = createdArr[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(originalArr[i][j]);
                if (j < W - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
