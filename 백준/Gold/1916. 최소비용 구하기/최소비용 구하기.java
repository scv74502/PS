import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int u, v, c;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        int[] distance = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            ipts = br.readLine().split(" ");
            u = Integer.parseInt(ipts[0]);
            v = Integer.parseInt(ipts[1]);
            c = Integer.parseInt(ipts[2]);
            graph.get(u).add(new int[] {c, v});
        }

        for(int i = 0; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        int start, end;
        ipts = br.readLine().split(" ");
        start = Integer.parseInt(ipts[0]);
        end = Integer.parseInt(ipts[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        // 자기 자신과 거리는 0으로
        distance[start] = 0;
        pq.add(new int[] {0, start});

        int dist, curNode, cost, nextNode;
        while(!pq.isEmpty()){
            dist = pq.peek()[0];
            curNode = pq.peek()[1];
            pq.poll();
            if(dist > distance[curNode]){
                continue;
            }

            for(int[] nn: graph.get(curNode)){
                cost = dist + nn[0];
                nextNode = nn[1];
                

                if(cost < distance[nextNode]){
                    distance[nextNode] = cost;
                    pq.add(new int[] {cost, nextNode});
                }
            }
        }

        System.out.println(distance[end]);
    }
}
