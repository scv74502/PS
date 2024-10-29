import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int answer, N;
    static int[][] energyAndJoy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        N = Integer.parseInt(br.readLine());
        energyAndJoy = new int[N+1][2];

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

        Arrays.sort(energyAndJoy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        answer = 0;
        bt(1, 100, 0);
        System.out.println(answer);
    }

    public static void bt(int depth, int curEnergy, int curJoy){
        if(depth == N+1){
            answer = Math.max(curJoy, answer);
            return;
        }

        int nextEnergy = curEnergy - energyAndJoy[depth][0];
        if(nextEnergy > 0){
            int nextJoy = curJoy + energyAndJoy[depth][1];
            bt(depth+1, nextEnergy, nextJoy);
        }
        bt(depth+1, curEnergy, curJoy);
    }
}
