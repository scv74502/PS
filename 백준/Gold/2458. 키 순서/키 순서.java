import java.io.*;

public class Main {
    static int N, M;    // N이 학생 수 - 정점, M이 학생 키 비교수 - 간선
    static boolean[][] connected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;
        int x, y;
        //int TC = Integer.parseInt(br.readLine());

        //for (int T = 1; T <= TC; T++) {
            ipt = br.readLine().split(" ");
            N = Integer.parseInt(ipt[0]);
            M = Integer.parseInt(ipt[1]);
            connected = new boolean[N][N];
            for (int c = 0; c < M; c++) {
                ipt = br.readLine().split(" ");
                x = Integer.parseInt(ipt[0]);
                y = Integer.parseInt(ipt[1]);
                connected[x-1][y-1] = true; // 키는 작거나 크거나만 비교함, 방향이 있으므로 양방향으로 처리하면 안 됨
            }


            floyd();
            System.out.println(check());
        //}

    }

    public static void floyd(){ // 플로이드 와샬 알고리즘
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(connected[i][k] && connected[k][j]) connected[i][j] = true;
                }
            }
        }
    }

    public static int check(){
        int cnt = 0;
        int temp;
        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = 0; j < N; j++) {
                if(connected[i][j] || connected[j][i]) temp++;  // 큰지 비교, 작은지 비교 양쪽을 모두 따져야 함
            }
            if(temp == N-1) cnt++;
        }
        return cnt;
    }
}
