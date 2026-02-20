import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distanceArr = new int[N+1];
        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        distanceArr[1] = 0;
        
        int[][] graph = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        
        for(int[] edge: road){
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            
            graph[u][v] = Math.min(graph[u][v], dist);
            graph[v][u] = Math.min(graph[v][u], dist);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        
        // 다익스트라로 1번과 각 정점 최단거리
        int start = 1;
        pq.add(new int[] {distanceArr[1], 1});  // [현재 거리, 현재 정점]
        while(!pq.isEmpty()){
            int curDist = pq.peek()[0];
            int cur = pq.peek()[1];            
            pq.poll();
            
            if(distanceArr[cur] < curDist) continue; // 최적화

            for(int next = 1; next <= N; next++){
                if(graph[cur][next] == Integer.MAX_VALUE) continue;

                int cost = curDist + graph[cur][next];
                if(cost < distanceArr[next]){
                    distanceArr[next] = cost;
                    pq.add(new int[] {cost, next});
                }
            }
        }
        
        for(int i = 1; i <= N; i++){
            if(distanceArr[i] <= K) answer++;
        }
        
        return answer;
    }
}