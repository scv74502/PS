import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        HashSet<Integer>[] graph = new HashSet[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new HashSet<>();        
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i = 0; i < wires.length; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            
            graph[u].remove(v);
            graph[v].remove(u);
            
            int checkResult = check(n, graph);
            answer = Math.min(answer, checkResult);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        
        return answer;
    }
    
    public int check(int n, HashSet<Integer>[] graph){        
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer> grids = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            int result = bfs(n, i, graph, visited);
            grids.add(result);
        }
        
        return (int) Math.abs(grids.get(0) - grids.get(1));
    }
    
    public int bfs(int n, int start, HashSet<Integer>[] graph, boolean[] visited){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;
        int tops = 1;
        
        while(!deque.isEmpty()){
            int cur = deque.poll();
            
            for(int next: graph[cur]){
                if(visited[next]) continue;
                deque.add(next);
                visited[next] = true;
                tops++;
            }
        }
        
        return tops;
    }
}