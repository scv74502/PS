import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int startR = 0, startC = 0;
        int leverR = 0, leverC = 0;
        int exitR = 0, exitC = 0;
            
        for(int r = 0; r < maps.length; r++){
            for(int c = 0; c < maps[r].length(); c++){
                if(maps[r].charAt(c) == 'S'){
                    startR = r;
                    startC = c;
                } else if(maps[r].charAt(c) == 'L'){
                    leverR = r;
                    leverC = c;
                } else if(maps[r].charAt(c) == 'E'){
                    exitR = r;
                    exitC = c;
                }
            }
        }                        
        
        int startToLever = bfs(startR, startC, leverR, leverC, maps);
        if(startToLever == -1) return -1;
        
        int leverToExit = bfs(leverR, leverC, exitR, exitC, maps);
        if(leverToExit == -1) return -1;
        
        return startToLever + leverToExit;
    }
    
    public int bfs(int startR, int startC, int endR, int endC, String[] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startR, startC, 0});
        
        int R = maps.length;
        int C = maps[0].length();
        
        boolean[][] visited = new boolean[R][C];
        visited[startR][startC] = true;
        
        while(!queue.isEmpty()){
            int curR = queue.peek()[0];
            int curC = queue.peek()[1];
            int curD = queue.peek()[2];
            queue.poll();
            
            if(curR == endR && curC == endC){
                return curD;
            }
            
            for(int d = 0; d < 4; d++){
                int nextR = curR + dr[d];
                int nextC = curC + dc[d];
                
                if(nextR < 0 || R <= nextR || nextC < 0 || C <= nextC || maps[nextR].charAt(nextC) == 'X'|| visited[nextR][nextC]) continue;
                queue.add(new int[] {nextR, nextC, curD + 1});
                visited[nextR][nextC] = true;
            }
        }
        
        return -1;
    }
}