import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 빨리 끝나는 순으로 정렬되는 pq
        PriorityQueue<Integer> waitingQueue = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            int curStart = meeting[0];
            int curEnd = meeting[1];

            // 현재 회의시작보다 일찍 끝나는 회의실 있으면 그 회의실을 이용함
            if(!waitingQueue.isEmpty() && waitingQueue.peek() <= curStart){
                waitingQueue.poll();
            }

            waitingQueue.add(curEnd);
        }

        System.out.println(waitingQueue.size());
    }
}
