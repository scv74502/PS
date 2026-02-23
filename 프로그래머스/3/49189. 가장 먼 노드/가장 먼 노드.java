import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] distArr = new int[n+1];
        final int START = 1;
        
        HashSet<Integer>[] graph = new HashSet[n + 1];        
        for(int i = 0; i <= n; i++){
            distArr[i] = Integer.MAX_VALUE;
            graph[i] = new HashSet<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int u = edge[i][0];
            int v = edge[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        distArr[START] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        
        pq.add(new int[] {0, START});
        
        while(!pq.isEmpty()){
            int curDist = pq.peek()[0];
            int curVertex = pq.peek()[1];
            pq.poll();
            // System.out.println(curDist + ", " +curVertex);
            
            for(int next:graph[curVertex]){
                int nextDist = curDist + 1;
                if(nextDist < distArr[next]){
                    distArr[next] = nextDist;
                    pq.add(new int[] {nextDist, next});
                    // System.out.println(Arrays.toString(distArr));
                }
            }
        }            
        
        int MAX_VAL = -1;
        int answer = 1;
        for(int i = 1; i <= n; i++){
            if(distArr[i] < Integer.MAX_VALUE && distArr[i] > MAX_VAL){
                MAX_VAL = distArr[i];
                answer = 1;
            } else if(distArr[i] == MAX_VAL){
                answer++;
            }
        }
                
        return answer;
    }
}