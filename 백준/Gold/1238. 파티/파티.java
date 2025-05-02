import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<int[]>[] graph;
    static ArrayList<int[]>[] reversedGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        reversedGraph = new ArrayList[N+1];


        final int MAX_DIST = 10_000_000;

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reversedGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, weight});
            reversedGraph[v].add(new int[] {u, weight});
        }

        int[] goDest = dijk(X, true);
        int[] backDest = dijk(X, false);

        int answer = -1;

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, goDest[i] + backDest[i]);
        }

        System.out.println(answer);
    }

    static int[] dijk(int start, boolean isGo){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 100000000);
        dist[X] = 0;
        ArrayList<int[]>[] curGraph = isGo ? graph : reversedGraph;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.offer(new int[] {start, 0});

        boolean[] visited = new boolean[N + 1];


        while(!pq.isEmpty()){
            int curVertex = pq.peek()[0];
            int curDist = pq.peek()[1];
            pq.poll();

            if(!visited[curVertex]){
                visited[curVertex] = true;

                for (int[] curEdge: curGraph[curVertex]){
                    int nextVertex =curEdge[0];
                    int nextDist =curEdge[1];

                    if(!visited[nextVertex] && dist[curVertex] + nextDist <= dist[nextVertex]){
                        dist[nextVertex] = dist[curVertex] + nextDist;
                        pq.add(new int[] {nextVertex, dist[nextVertex]});
                    }
                }
            }
        }

        return dist;
    }
}
