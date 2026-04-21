import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            String[] place = places[i];
            answer[i] = checkDistancing(place) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean checkDistancing(String[] place) {
        ArrayList<int[]> persons = new ArrayList<>();
        for(int i = 0; i < place.length; i++){
            for(int j = 0; j < place[i].length(); j++){
                if(place[i].charAt(j) == 'P') persons.add(new int[] {i, j});
            }
        }
        
        for(int i = 0; i < persons.size() - 1; i++){
            for(int j = i + 1; j < persons.size(); j++){
                int p1r = persons.get(i)[0];
                int p1c = persons.get(i)[1];
                int p2r = persons.get(j)[0];
                int p2c = persons.get(j)[1];            
                
                if(getMenDist(p1r, p1c, p2r, p2c) < 2) return false;
                else if (getMenDist(p1r, p1c, p2r, p2c) > 2) continue;
                else {
                    if(!checkPartition(p1r, p1c, p2r, p2c, place)) return false;
                }
            }
        }
        
        return true;
    }
    
    public int getMenDist(int r1, int c1, int r2, int c2){
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public boolean checkPartition(int p1r, int p1c, int p2r, int p2c, String[] place){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        deque.add(new int[] {p1r, p1c});
        visited[p1r][p1c] = true;
        
        while(!deque.isEmpty()){
            int cr = deque.peek()[0];
            int cc = deque.peek()[1];
            deque.poll();
            
            if(cr == p2r && cc == p2c) return false;
            
            for(int d = 0; d < 4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(nr < 0 || 5 <= nr || nc < 0 || 5 <= nc || nr < Math.min(p1r, p2r) || Math.max(p1r, p2r) < nr 
                   || nc < Math.min(p1c, p2c) || Math.max(p1c, p2c) < nc  || visited[nr][nc] || place[nr].charAt(nc) == 'X') continue;                
                
                visited[nr][nc] = true;
                deque.add(new int[] {nr, nc});
            }
        }
        
        return true;
    }
}