import java.io.*;

public class Main {
    static int[][] cogWheels = new int[4][8];
    static int[][] wheelStatus = new int[4][2]; // i번 휠의 왼쪽 접점 6번 인덱스, 오른쪽 접점 2번 인덱스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 4; i++) {
            String ipt = br.readLine();
            char[] numbers = ipt.toCharArray();
            for (int j = 0; j < 8; j++) {
                cogWheels[i][j] = numbers[j] - '0';
            }

            wheelStatus[i][0] = 6;
            wheelStatus[i][1] = 2;
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] iptArr = br.readLine().split(" ");
            int cogWheelIdx = Integer.parseInt(iptArr[0]) - 1;
            int rotateDir = Integer.parseInt(iptArr[1]);

            rotate(cogWheelIdx, rotateDir);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if(cogWheels[i][calcCog(wheelStatus[i][1], -2)] == 1) answer += (1 << i);
        }

        System.out.println(answer);
    }

    static void rotate(int idx, int rotateDir){
        int[] dir = new int[4];
        dir[idx] = rotateDir;

        // 회전 왼쪽으로 전파
        for(int i = idx; i > 0; i--){
            if(cogWheels[i][wheelStatus[i][0]] == cogWheels[i-1][wheelStatus[i-1][1]]) break;
            dir[i-1] = -dir[i];
        }

        // 회전 오른쪽으로 전파
        for(int i = idx; i < 3; i++){
            if(cogWheels[i][wheelStatus[i][1]] == cogWheels[i+1][wheelStatus[i+1][0]]) break;
            dir[i+1] = -dir[i];
        }

        // 결정된 방향으로 회전하여 인덱스 일괄 업데이트
        for (int i = 0; i < 4; i++) {
            if (dir[i] == 0) continue;
            // 시계 방향으로 톱니를 돌리면, 실제 인덱스는 그 반대로(반시계도 마찬가지)
            wheelStatus[i][0] = calcCog(wheelStatus[i][0], -dir[i]);
            wheelStatus[i][1] = calcCog(wheelStatus[i][1], -dir[i]);
        }
    }

    public static int calcCog(int cog, int dir){
        cog += dir;
        if(cog < 0) return cog + 8;
        return cog % 8;
    }
}


