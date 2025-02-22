import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts = br.readLine().split(" ");

        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);

        int[] dist = new int[N + 1];
        graph = new int[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], 50000000);
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            ipts = br.readLine().split(" ");

            int u = Integer.parseInt(ipts[0]);
            int v = Integer.parseInt(ipts[1]);

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if(graph[j][k] > graph[i][j] + graph[i][k]){
                        graph[j][k] = graph[i][j] + graph[i][k];
                    }
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                } else{
                    return o1[1] - o2[1];
                }
            }
        });

//        System.out.println(Arrays.deepToString(graph));
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i] += graph[i][j];
            }
            pq.add(new int[] {i, dist[i]});
        }

        if(!pq.isEmpty()) System.out.println(pq.peek()[0]);
    }
}
