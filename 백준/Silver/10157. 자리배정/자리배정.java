import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;
        // R은 세로, C는 가로
        int R, C, K;
        int[][] seats;

        ipts = br.readLine().split(" ");
        C = Integer.parseInt(ipts[0]);
        R = Integer.parseInt(ipts[1]);
        K = Integer.parseInt(br.readLine());
        seats = new int[R][C];

        int answer = 1;
        int cur = 1;

        // 상 우 하 좌
        int[] dr = new int[] {-1,0, 1, 0};
        int[] dc = new int[] {0, 1, 0, -1};

        // 대기번호가 좌석보다 큰 경우
        if(K > R*C){
            sb.append(0);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
            return;
        } else if(K == 1){
            sb.append(1);
            sb.append(" ");
            sb.append(1);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        } else{
            // 현재 위치
            int cr = R - 1;
            int cc = 0;
            int cd = 0;
            int nr, nc;

            while(true){
                seats[cr][cc] = answer;
                if(answer == K){
                    break;
                }

                nr = cr + dr[cd];
                nc = cc + dc[cd];

                if(0 <= nr && nr < R && 0 <= nc && nc < C && seats[nr][nc] == 0){
                    cr = nr;
                    cc = nc;
                    answer++;
                } else{
                    cd = (cd + 1) % 4;
                }
            }
            sb.append(cc + 1);
            sb.append(" ");
            sb.append(R - cr);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        }

    }
}
