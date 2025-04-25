import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
//        dist = new int[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        int result = bfs(start, end);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    static int bfs(int start, int end){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {start, 0});
        visited[start] = true;
        int answer = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curVertex = cur[0];
            int curDist = cur[1];

            if(curVertex == end){
                answer = Math.min(answer, curDist);
                return answer;
            }

            for(int next:graph[curVertex]){
                if(visited[next]) continue;

                visited[next] = true;
                int nextDist = curDist + 1;
                queue.add(new int[] {next, nextDist});
            }
        }

        return Integer.MAX_VALUE;
    }
}