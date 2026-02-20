import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] checked = new boolean[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        // System.out.println(Arrays.toString(graph));
        
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if(checked[i]) continue;
            bfs(i, graph, checked);
            answer++;
        }
        return answer;
    }
    
    public void bfs(int start, ArrayList<Integer>[] graph, boolean[] checked){
        Deque<Integer> queue = new ArrayDeque<>();
        checked[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next:graph[cur]){
                if(checked[next]) continue;
                queue.add(next);
                checked[next] = true;
            }
        }
    }
}