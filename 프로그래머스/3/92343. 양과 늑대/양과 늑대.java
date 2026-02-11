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
        deque.add(new Info(0, 1, 0, new HashSet<>()));  // 시작은 0부터
        
        // visited는 최근 방문 기록, 중복체크가 아닌 다음 노드 탐색할 위치
        while(!deque.isEmpty()){
            System.out.println(deque.peek());
            int curLoc = deque.peek().location;
            int curSheep = deque.peek().sheepCnt;
            int curWolf = deque.peek().wolfCnt;
            answer = Math.max(answer, curSheep);
            HashSet<Integer> curVisited = new HashSet<>(deque.peek().visited);
            deque.poll();
            
            // 현재 마지막 방문지역의 하위 노드 방문처리 
            for(int childLoc: graph[curLoc]){
                curVisited.add(childLoc);
            }
            
            // 마지막 방문지역으로부터 현재 방문할 노드들 탐색
            for(int nextLoc: curVisited){
                if(info[nextLoc] == 0){ // 다음 노드에 양이 있다면
                    HashSet<Integer> nextVisited = new HashSet<>(curVisited);
                    nextVisited.remove(nextLoc);
                    deque.add(new Info(nextLoc, curSheep + 1, curWolf, nextVisited));
                }
                
                if(info[nextLoc] == 1){ // 다음 노드에 늑대가 있다면
                    if(curSheep > curWolf + 1){
                        HashSet<Integer> nextVisited = new HashSet<>(curVisited);
                        nextVisited.remove(nextLoc);
                        deque.add(new Info(nextLoc, curSheep, curWolf + 1, nextVisited));
                    }
                }
            }
        }
        
        
        return answer;
    }
}

class Info{
    int location;
    int sheepCnt;
    int wolfCnt;
    HashSet<Integer> visited;
    
    public Info(int location, int sheepCnt, int wolfCnt, HashSet<Integer> visited){
        this.location = location;
        this.sheepCnt = sheepCnt;
        this.wolfCnt = wolfCnt;
        this.visited = visited;
    }
    
    // @Override
    // public String toString(){
    //     return "location: " + location + ", sheelCnt: " + sheepCnt + ", wolfCnt: " + wolfCnt + "\nvisited: " + visited + "\n";
    // }
}