import java.io.*;

public class Main {
    public static int H, W, N;
    public static void main(String[] args) throws IOException {
        // 입출력 객체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 변수들 사전 정의
        String[] ipts;
        String ipt;
        int r, c;
        int r1, r2, c1, c2;
        int answer = 0;
        int area = 0;

        ipts = br.readLine().strip().split(" ");
        H = Integer.parseInt(ipts[0]);
        W = Integer.parseInt(ipts[1]);
        ipt = br.readLine().strip();
        N = Integer.parseInt(ipt);

        // stickers[i][0] = 세로, stickers[i][1] = 가로;
        int[][] stickers = new int[N][2];

        for(int i = 0; i < N; i++){
            ipts = br.readLine().strip().split(" ");
            r = Integer.parseInt(ipts[0]);
            c = Integer.parseInt(ipts[1]);
            stickers[i][0] = r;
            stickers[i][1] = c;
        }

        // 스티커 2개만 고르기 때문에 2중 for문으로 개별 스티커 비교
        // 90도 뒤집는 경우에는 r, c를 맞바꿈
        for(int i = 0; i < N; i++){
            r1 = stickers[i][0];
            c1 = stickers[i][1];
            for(int j = i+1; j < N; j++){
                r2 = stickers[j][0];
                c2 = stickers[j][1];
                area = r1 * c1 + r2 * c2;

                // 스티커를 어떻게 붙이건 간에 겹치지 않기 때문에 넓이는 항상 동일하다
                // 가로로 맞닿게 나란히 붙이는 케이스(그대로, 하나만 회전하는 두 케이스, 둘 다 회전하는 케이스
                if((r1 + r2 <= W && Math.max(c1, c2) <= H) || (c1 + r2 <= W && Math.max(r1, c2) <= H) ||
                    (r1 + c2 <= W && Math.max(c1, r2) <= H) || (c1 + c2 <= W && Math.max(r1, r2) <= H) ){
                    answer = Math.max(answer, area);
                }

                // 세로로 맞닿게 나란히 붙이는 케이스(그대로, 하나만 회전하는 두 케이스, 둘 다 회전하는 케이스
                else if((r1 + r2 <= H && Math.max(c1, c2) <= W) || (c1 + r2 <= H && Math.max(r1, c2) <= W) ||
                        (r1 + c2 <= H && Math.max(c1, r2) <= W) || (c1 + c2 <= H && Math.max(r1, r2) <= W) ){
                    answer = Math.max(answer, area);
                }
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
    }
}
