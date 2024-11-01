import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int[] health;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        ipts = br.readLine().split(" ");
        int N = Integer.parseInt(ipts[0]);
        K = Integer.parseInt(ipts[1]);

        health = new int[2 * N];
        boolean[] robots = new boolean[N];
        ipts = br.readLine().split(" ");
        for (int i = 0; i < health.length; i++) {
            health[i] = Integer.parseInt(ipts[i]);
        }

        int cnt = 0;

        while(check()){
            // 1. 컨테이너와 로봇 회전시킴
            // 1.1 컨테이너의 회전
            int tmpH = health[health.length - 1];
            for(int i = health.length - 1; i > 0; i--) {
                health[i] = health[i - 1];
            }
            health[0] = tmpH;

            // 1.2 로봇의 회전
            for(int i = robots.length - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false;  // 맨 처음 자리는 로봇 없어야 함
            // 로봇이 내리는 위치에 도달하면 즉시 내린다
            robots[robots.length - 1] = false;
            // 2. 로봇의 컨베이어 진행방향 전진
            for(int i = N-1; i > 0; i--) {
                // 현재칸 내구도가 남아있고 비었으며, 전 칸에 로봇이 있다면
                if(!robots[i] && health[i] > 0 && robots[i-1]){
                    // 로봇 한 칸 전진시킴
                    robots[i] = true;
                    // 로봇이 닿은 칸 내구도 감소
                    health[i]--;
                    // 전 칸은 로봇 비움 처리
                    robots[i-1] = false;
                }
            }

            // 3. 올리는 칸의 내구도 남았으면 로봇을 올림
            if(health[0] > 0){
                robots[0] = true;
                health[0]--;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean check(){
        int cnt = 0;
        for (int j : health) {
            if (j == 0) {
                cnt++;
            }
            if (cnt >= K) return false;
        }
        return true;
    }
}
