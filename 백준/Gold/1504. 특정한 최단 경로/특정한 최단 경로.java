import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int INF = 200000000;
    static int[][] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        N = Integer.parseInt(ipts[0]);
        int E = Integer.parseInt(ipts[1]);

        dist = new int[N+1];
        graph = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;  // 자기 자신으로의 거리는 0
        }

        int a, b, c;
        for (int i = 0; i < E; i++) {
            ipts = br.readLine().split(" ");
            a = Integer.parseInt(ipts[0]);
            b = Integer.parseInt(ipts[1]);
            c = Integer.parseInt(ipts[2]);

            graph[a][b] = c;
            graph[b][a] = c;
        }

        int v1, v2;
        ipts = br.readLine().split(" ");
        v1 = Integer.parseInt(ipts[0]);
        v2 = Integer.parseInt(ipts[1]);

        dijkstra(1);

        int startToV1 = dist[v1];
        int startToV2 = dist[v2];

        dijkstra(v1);
        int v1ToV2 = dist[v2];
        int v1ToEnd = dist[N];

        dijkstra(v2);
        int v2ToV1 = dist[v1];
        int v2ToEnd = dist[N];

        int v1First = startToV1 + v1ToV2 + v2ToEnd;
        int v2First = startToV2 + v2ToV1 + v1ToEnd;
        if(v1First >= INF && v2First >= INF) System.out.println(-1);
        else System.out.println(Math.min(v1First, v2First));
    }

    public static void dijkstra(int start){
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[] {0, start});

        while(!pq.isEmpty()){
            int curDist = pq.peek()[0];
            int curV = pq.peek()[1];
            pq.poll();

            if(visited[curV]) continue;
            visited[curV] = true;

            for (int i = 1; i <= N; i++) {
                int cost = curDist + graph[curV][i];

                if(cost < dist[i]){
                    dist[i] = cost;
                    pq.add(new int[] {cost, i});
                }
            }
        }

        return;
    }
}
