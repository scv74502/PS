import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        ArrayList<Integer>[] graph = new ArrayList[info.length];
        for(int i = 0; i < info.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
        }
        
        Deque<Info> deque = new ArrayDeque<>();
        deque.add(new Info(0, 1, 0, new HashSet<>()));
        
        while(!deque.isEmpty()){
            int curLoc = deque.peek().location;
            int curSheep = deque.peek().sheep;
            int curWolf = deque.peek().wolf;
            HashSet<Integer> visited = deque.peek().visited;
            deque.poll();
            
            // 모든 경우의 양 마리수 최대화
            answer = Math.max(answer, curSheep);
            
            // 현재 위치에 자식 정점을 다음 방문 포인트에 추가
            for(int childNodeLoc: graph[curLoc]){
                visited.add(childNodeLoc);
            }
            
            // 방문 예정 포인트들 체크 
            for(int nextLoc: visited) {                
                if(info[nextLoc] == 0){
                    HashSet<Integer> nextVisit = new HashSet<>(visited);
                    nextVisit.remove(nextLoc);
                    deque.add(new Info(nextLoc, curSheep + 1, curWolf, nextVisit));
                } else {
                    if(curSheep > curWolf + 1){
                        HashSet<Integer> nextVisit = new HashSet<>(visited);
                        nextVisit.remove(nextLoc);
                        deque.add(new Info(nextLoc, curSheep, curWolf + 1, nextVisit));
                    }
                }
            }
        }
        
        
        return answer;
    }
}

class Info{
    int location;
    int sheep;
    int wolf;
    HashSet<Integer> visited;
    
    public Info(int location, int sheep, int wolf, HashSet<Integer> visited) {
        this.location = location;
        this.sheep = sheep;
        this.wolf = wolf;
        this.visited = visited;
    }
}