import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean isBipartite;
    static boolean[] visited;
    static int[] check;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        for (int RPT = 0; RPT < TC; RPT++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            check = new int[V+1];
            graph = new ArrayList[V+1];
            visited = new boolean[V+1];
            isBipartite = true;

            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            for (int i = 1; i <= V; i++) {
                if(!isBipartite) break;
                dfs(i);
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static void dfs(int start){
        if(!isBipartite) return;

        visited[start] = true;

        for(int next:graph[start]){
            if(!visited[next]){
                check[next] = (check[start] + 1) % 2;
                dfs(next);
            } else if(check[next] == check[start]){
                isBipartite = false;
            }
        }
    }

}