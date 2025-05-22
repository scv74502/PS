import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int R = Integer.parseInt(stringTokenizer.nextToken());

        int[] values = new int[N+1];
        int[] distance = new int[N+1];
        HashMap<Integer, Integer>[] graph  = new HashMap[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new HashMap<>();
        }

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < R; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());

            graph[u].put(v, d);
            graph[v].put(u, d);
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < N; i++) {
            Arrays.fill(distance, 1_000_000);
            distance[i] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            // 현재 거리, 현재 위치
            pq.offer(new int[]{0, i});
            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                int curDist = cur[0];
                int curLocation = cur[1];

                for(int key:graph[curLocation].keySet()){
                    int nextLocation = key;
                    int nextDist = graph[curLocation].get(key);

                    if(distance[nextLocation] > curDist + nextDist){
                        distance[nextLocation] = curDist + nextDist;
                        pq.offer(new int[]{distance[nextLocation], nextLocation});
                    }
                }
            }

            int valueSum = 0;

            for (int j = 1; j <= N; j++) {
                if(distance[j] <= M) {
                    valueSum += values[j];
                }
            }

            answer = Math.max(answer, valueSum);
        }

        System.out.println(answer);
    }
}
