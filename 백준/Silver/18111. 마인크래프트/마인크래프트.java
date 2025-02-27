import java.io.*;
import java.util.*;

public class Main {
    static int spentTime = Integer.MAX_VALUE;
    static int groundHeight = Integer.MIN_VALUE;
    static int N, M, B;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                map[i][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }

        for (int height = 0; height < 257; height++) {
            int curTime = 0;
            int gatheredBlock = 0;
            int usedBlock = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(height > map[i][j]){
                        usedBlock += height - map[i][j];
                    } else{
                        gatheredBlock += map[i][j] - height;
                    }
                }
            }

            if(usedBlock > gatheredBlock + B) continue;
            curTime = usedBlock + gatheredBlock * 2;
            if(spentTime >= curTime){
                spentTime = curTime;
                if(height > groundHeight) groundHeight = height;
            }
        }

        System.out.println(spentTime + " " + groundHeight);
    }
}
