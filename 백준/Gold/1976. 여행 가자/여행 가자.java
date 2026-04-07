import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashSet<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new HashSet[N + 1];

        for (int i = 0; i < graph.length; i++) {
           graph[i] = new HashSet<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int next = Integer.parseInt(st.nextToken());
                if(next == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        String[] iptArr = br.readLine().split(" ");
        int[] plans = new int[iptArr.length];

        for (int i = 0; i < iptArr.length; i++) {
            plans[i] = Integer.parseInt(iptArr[i]);
        }

        for (int i = 0; i < plans.length - 1; i++) {
            int start = plans[i];
            int dest = plans[i + 1];
            if(!bfs(start, dest)){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static boolean bfs(int start, int end){
        boolean[] visited = new boolean[N + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == end) return true;

            for (int next : graph[cur]) {
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }
}



