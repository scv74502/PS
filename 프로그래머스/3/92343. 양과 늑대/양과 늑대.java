import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        ArrayList<Integer>[] graph = new ArrayList[info.length];
        for(int i = 0; i < info.length; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
        }
                
        
        Deque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));
        
        while(!queue.isEmpty()){            
            int curLoc = queue.peek().curLoc;
            int curSheep = queue.peek().sheep;
            int curWolf = queue.peek().wolf;
            HashSet<Integer> visited = queue.peek().visited;
            queue.poll();                        
            answer = Math.max(answer, curSheep);
            
            // 인접 노드에 업데이트
            for(int nextLoc: graph[curLoc]){
                visited.add(nextLoc);
            }
                                    
            for(int nextLoc: visited){                
                int nextSheep = curSheep;
                int nextWolf = curWolf;                
                HashSet<Integer> nextVisited = new HashSet<>(visited);
                
                // 양이 있는 칸
                if(info[nextLoc] == 0){
                    nextVisited.remove(nextLoc);                
                    queue.add(new Info(nextLoc, nextSheep + 1, nextWolf, nextVisited));
                } else {    // 늑대칸   
                    if(curSheep > curWolf + 1){
                        nextVisited.remove(nextLoc);                
                        queue.add(new Info(nextLoc, nextSheep, nextWolf + 1, nextVisited));
                    }
                }                
            }
        }
        
        return answer;
    }
    
}

class Info {
    int curLoc;
    HashSet<Integer> visited;
    int sheep;
    int wolf;
    
    public Info(int curLoc, int sheep, int wolf, HashSet<Integer> visited){
        this.curLoc = curLoc;        
        this.sheep = sheep;
        this.wolf = wolf;
        this.visited = visited;
    }
}