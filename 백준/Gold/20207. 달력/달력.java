import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        int N = Integer.parseInt(br.readLine());

        int start, end, len;
        PriorityQueue<int[]> schedules = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 일정 정렬은 시작일 앞선순, 일정이 긴 순서
                if(o1[0] == o2[0]) {
                    return o2[2] - o1[2];
                }
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            start = Integer.parseInt(ipts[0]);
            end = Integer.parseInt(ipts[1]);
            len = end - start + 1;

            schedules.add(new int[]{start, end, len});
        }

        int[] reservations = new int[366];

        while(!schedules.isEmpty()) {
            start = schedules.peek()[0];
            end = schedules.peek()[1];
            len = schedules.peek()[2];
            schedules.poll();

            for(int i=start; i<=end; i++) {
                reservations[i]++;
            }
        }

        int scLen = 0;
        int maxDaySc = 0;
        int ans = 0;

        for(int i=1; i<366; i++) {
            if(reservations[i] > 0) {
                scLen++;
                maxDaySc = Math.max(reservations[i], maxDaySc);
            } else{
                ans += scLen * maxDaySc;
                scLen = 0;
                maxDaySc = 0;
            }
        }
        ans += scLen * maxDaySc;
        System.out.println(ans);
    }
}
