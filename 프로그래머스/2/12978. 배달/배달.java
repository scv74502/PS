import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        Arrays.sort(road, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){            
                return o1[0] - o2[0];
            }
        });
        
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<int[]>());
        }
        
        // System.out.println(graph.size());
        
        int u, v, time;
        for(int[] vertex:road){
            u = vertex[0];
            v = vertex[1];
            time = vertex[2];
            
            graph.get(u).add(new int[] {time, v});
            graph.get(v).add(new int[] {time, u});
        }
        // System.out.println("graph done");
        // 0번이 시간, 1번이 정점
        int[] cur;
        
        pq.offer(new int[] {0, 1});
        
        int curCost, curNode, nextCost, nextNode;
        while(!pq.isEmpty()){
            cur = pq.poll();
            curCost = cur[0];
            curNode = cur[1];
            
            for(int[] next:graph.get(curNode)){
                nextCost = next[0];
                nextNode = next[1];
                
                if(distance[curNode] + nextCost < distance[nextNode]){
                    // System.out.println("nextNode");
                    distance[nextNode] = distance[curNode] + nextCost;
                    pq.offer(new int[] {distance[curNode] + nextCost, nextNode});
                }                       
            }
        }
        

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println(Arrays.toString(distance));
        
        for(int i = 1; i <= N; i++){
            if(distance[i] <= K){
                answer++;
            }
        }

        return answer;
    }
}