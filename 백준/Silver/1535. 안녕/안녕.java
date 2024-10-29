import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        int N = Integer.parseInt(br.readLine());
        int[][] energyAndJoy = new int[N+1][2];

        ipts = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            int health = Integer.parseInt(ipts[i-1]);
            energyAndJoy[i][0] = health;
        }

        ipts = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            int joy = Integer.parseInt(ipts[i-1]);
            energyAndJoy[i][1] = joy;
        }

//        System.out.println(Arrays.deepToString(energyAndJoy));

        // 0~99까지 범위, dp[i]는 체력을 i만큼 썼을 때에 느낄 수 있는 최대 기쁨
        int[] dp = new int[100];

        for(int i = 1; i <= N; i++) {
            int health = energyAndJoy[i][0];
            int joy = energyAndJoy[i][1];

            for(int j = 99; j >= health; j--) {
                dp[j] = Math.max(dp[j], dp[j-health] + joy);
            }

        }

        System.out.println(dp[99]);
    }
}
