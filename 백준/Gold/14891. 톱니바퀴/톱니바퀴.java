import java.io.*;
import java.util.*;

public class Main {
    // i번 톱니바퀴의 j번 톱니 값
    static int[][] cogWheels = new int[4][8];
    // i번 톱니바퀴가 다른 톱니와 닿아 있는 값들(0번 인덱스가 왼쪽, 1번 인덱스가 오른쪽)
    static int[][] cogStatus = new int[4][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 톱니바퀴 4개 입력
        for (int i = 0; i < 4; i++) {
            String ipt = br.readLine();
            char[] numbers = ipt.toCharArray();
            for (int j = 0; j < 8; j++) {
                cogWheels[i][j] = numbers[j] - '0';
            }

            cogStatus[i][0] = 6;
            cogStatus[i][1] = 2;
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] iptArray = br.readLine().split(" ");
            int cogWheelIdx = Integer.parseInt(iptArray[0]) - 1;
            int rotateDir = Integer.parseInt(iptArray[1]);
            rotate(cogWheelIdx, rotateDir);
        }

        int answer = 0;

        for (int i = 0; i < 4; i++) {
            int topIdx = (cogStatus[i][0] + 2) % 8;
            if (cogWheels[i][topIdx] == 1) {
                answer += (1 << i);
            }
        }

        System.out.println(answer);
    }

    // 회전 함수, rotateDir이 1이면 시계방향 -1이면 반시계방향
    public static void rotate(int cogWheelIdx, int rotateDir) {
        int[] directions = new int[4];
        directions[cogWheelIdx] = rotateDir;

        // 회전 방향 먼저 모두 결정 (회전 전 상태 기준 비교)
        // 왼쪽 전파
        for (int i = cogWheelIdx; i > 0; i--) {
            if (cogWheels[i - 1][cogStatus[i - 1][1]] != cogWheels[i][cogStatus[i][0]]) {
                directions[i - 1] = -directions[i];
            } else break;
        }
        // 오른쪽 전파
        for (int i = cogWheelIdx; i < 3; i++) {
            if (cogWheels[i][cogStatus[i][1]] != cogWheels[i + 1][cogStatus[i + 1][0]]) {
                directions[i + 1] = -directions[i];
            } else break;
        }

        // 결정된 방향으로 인덱스 일괄 업데이트
        for (int i = 0; i < 4; i++) {
            if (directions[i] == 0) continue;
            // 시계 방향(1)이면 인덱스 -1, 반시계(-1)면 인덱스 +1
            cogStatus[i][0] = calcCog(cogStatus[i][0], -directions[i]);
            cogStatus[i][1] = calcCog(cogStatus[i][1], -directions[i]);
        }
    }

    // 톱니 계산 함수
    public static int calcCog(int cog, int dir){
        int result = cog + dir;

        if(result > 7) result -= 8;
        else if(result < 0) result += 8;

        return result;
    }
}


