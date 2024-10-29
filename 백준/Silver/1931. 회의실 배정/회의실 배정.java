import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] schedule;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for(int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            int start = Integer.parseInt(ipts[0]);
            int end = Integer.parseInt(ipts[1]);
            schedule[i][0] = start;
            schedule[i][1] = end;
        }

        Arrays.sort(schedule, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

//        System.out.println(Arrays.deepToString(schedule));
        int answer = 0;
        int curTime = 0;

        for(int i = 0; i < N; i++) {
            if(curTime <= schedule[i][0]) {
                curTime = schedule[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
