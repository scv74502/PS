import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);
        int R = Integer.parseInt(ipts[2]);

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            ipts = br.readLine().split(" ");

            int u = Integer.parseInt(ipts[0]);
            int v = Integer.parseInt(ipts[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        int order = 1;
        int[] visitOrder = new int[N+1];
        boolean[] visited = new boolean[N + 1];

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(R);
        visited[R] = true;

        while(!dq.isEmpty()){
            int curNode = dq.poll();
            visitOrder[curNode] = order;
            order++;

            for(int nextNode:graph[curNode]){
                if(!visited[nextNode]){
                    dq.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(i != N) sb.append(visitOrder[i]).append("\n");
            else sb.append(visitOrder[i]);
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}

