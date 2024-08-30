import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);
        int K = Integer.parseInt(ipts[2]);
        int X = Integer.parseInt(ipts[3]);

        // 거리 저장 배열 및 거리를 최대값으로 초기화
        int[] distance = new int[N+1];
        for(int i = 0; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[X] = 0;    // 자기 자신과 거리는 0

        int[] now;
        int u, v, node, dist, cost;
        int ndist;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            ipts = br.readLine().split(" ");
            u = Integer.parseInt(ipts[0]);
            v = Integer.parseInt(ipts[1]);
            graph.get(u).add(v);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        pq.add(new int[] {0, X});

        while(!pq.isEmpty()){
            now = pq.poll();
            dist = now[0];
            node = now[1];


            for(int nextNode:graph.get(node)){
                cost = distance[node] + 1;

                if(distance[nextNode] < dist){
                    continue;
                }

                if(cost < distance[nextNode]){
                    distance[nextNode] = cost;
                    pq.add(new int[] {cost, nextNode});
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(distance[i] == K){
                answer++;
                sb.append(i);
                sb.append("\n");
            }
        }

        if(answer == 0){
            System.out.println(-1);
        } else{
            bw.write(sb.toString());
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
