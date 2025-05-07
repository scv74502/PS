import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, usado});
            graph[v].add(new int[] {u, usado});
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[N+1];
            visited[start] = true;

            queue.add(new int[] {start, Integer.MAX_VALUE});
            int result = 0;

            while(!queue.isEmpty()){
                int cur = queue.peek()[0];
                int curUsado = queue.peek()[1];
                queue.poll();

                for(int[] nextGraph:graph[cur]){
                    int next = nextGraph[0];
                    int nextUsado = Math.min(curUsado, nextGraph[1]);

                    if(nextUsado >= k && !visited[next]) {
                        result++;
                        queue.add(new int[] {next, nextUsado});
                        visited[next] = true;
                    }
                }
            }

            System.out.println(result);
        }
    }
}

