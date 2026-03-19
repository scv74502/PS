import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ipt = br.readLine().split(" ");
        int N = Integer.parseInt(ipt[0]);
        int[] peoples = new int[N];
        ipt = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            peoples[i] = Integer.parseInt(ipt[i]);
        }
        int[] seats = new int[N];

        for (int i = 0; i < N; i++) {
            int count = peoples[i]; // 건너뛰어야 할 빈칸의 개수
            for (int j = 0; j < N; j++) {
                // 빈칸을 발견했을 때
                if (seats[j] == 0) {
                    if (count == 0) { // 더 이상 건너뛸 빈칸이 없으면 이 자리에 앉음
                        seats[j] = i + 1;
                        break;
                    }
                    count--; // 빈칸 하나를 건너뜀
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(seats[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
