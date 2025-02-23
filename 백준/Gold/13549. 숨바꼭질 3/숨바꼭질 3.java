import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] spentTime = new int[100001];
        Arrays.fill(spentTime, 100000);
        spentTime[N] = 0;

        // 소요시간, 위치
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        pq.add(new int[] {0, N});

        while(!pq.isEmpty()){
            int curTime = pq.peek()[0];
            int curLoc = pq.peek()[1];
            pq.poll();

            if(curLoc == K) break;

            // 1. 1초 후 1칸 전
            int nTime = curTime + 1;
            int nLoc = curLoc - 1;
            if(0 <= nLoc && nLoc <= 100000 && spentTime[nLoc] > nTime){
                pq.add(new int[] {nTime, nLoc});
                spentTime[nLoc] = nTime;
            }

            // 2. 1초 후 1칸 후
            nTime = curTime + 1;
            nLoc = curLoc + 1;
            if(0 <= nLoc && nLoc <= 100000 && spentTime[nLoc] > nTime){
                pq.add(new int[] {nTime, nLoc});
                spentTime[nLoc] = nTime;
            }

            // 3. 즉시 2X로 순간이동
            nTime = curTime;
            nLoc = curLoc * 2;
            if(0 <= nLoc && nLoc <= 100000 && spentTime[nLoc] > nTime){
                pq.add(new int[] {nTime, nLoc});
                spentTime[nLoc] = nTime;
            }
        }

        System.out.println(spentTime[K]);
    }
}
