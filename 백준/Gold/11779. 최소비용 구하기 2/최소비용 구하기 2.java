import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dist, pathRec;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        dist = new int[N+1];
        pathRec = new int[N+1];
        Arrays.fill(dist, 100000000);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();  // 각 인덱스마다 새로운 ArrayList 객체 생성
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        ArrayList<Integer> path = new ArrayList<>();
        int current = end;
        while (current != 0) {
            path.add(current);
            current = pathRec[current];
        }
        Collections.reverse(path);

        System.out.println(dist[end]);
        System.out.println(path.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) sb.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.cost > dist[node.vertex]){
                continue;
            }

            for (Edge edge: graph[node.vertex]) {
                int nextCost = edge.cost + node.cost;
                if(nextCost < dist[edge.end]){
                    dist[edge.end] = nextCost;
                    pathRec[edge.end] = node.vertex;
                    pq.add(new Node(edge.end, nextCost));
                }
            }
        }
    }

    public static class Edge{
        public int end;
        public int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static class Node implements Comparable<Node> {
        int vertex, cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
