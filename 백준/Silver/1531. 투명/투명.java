import java.io.*;

public class Main {
    static int[][] paint = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");
        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            // 왼쪽 아래 x1, y1
            int y1 = Integer.parseInt(ipts[0]);
            int x1 = Integer.parseInt(ipts[1]);
            // 오른쪽 위 x2, y2
            int y2 = Integer.parseInt(ipts[2]);
            int x2 = Integer.parseInt(ipts[3]);

            hidePicture(x1, y1, x2, y2);
        }

        System.out.println(count(M));

        br.close();
        bw.close();
    }

    public static void hidePicture(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                paint[i][j]++;
            }
        }
    }

    public static int count(int n){
        int answer = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if(paint[i][j] > n) answer++;
            }
        }

        return answer;
    }
}
