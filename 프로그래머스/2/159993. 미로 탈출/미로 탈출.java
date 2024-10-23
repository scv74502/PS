import java.util.*;

class Solution {
    static int col, row;
    public int solution(String[] maps) {
        int answer = 0;
        col = maps.length;
        row = maps[0].length();    
        
        char[][] charMap = new char[col][row];
        
        int startCol = 0;
        int startRow = 0;
        int leverCol = 0;
        int leverRow = 0;
        int exitCol = 0;
        int exitRow = 0;
        
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){                
                if(maps[i].charAt(j) == 'S'){
                    startCol = i;
                    startRow = j;
                } 
                
                if(maps[i].charAt(j) == 'L'){
                    leverCol = i;
                    leverRow = j;
                } 
                
                if(maps[i].charAt(j) == 'E'){
                    exitCol = i;
                    exitRow = j;
                }
                charMap[i][j] = maps[i].charAt(j);
            }            
        }
        
        answer = bfs(startCol, startRow, leverCol, leverRow, charMap);
        // System.out.println(answer);
        if(answer > -1){
            int temp = bfs(leverCol, leverRow, exitCol, exitRow, charMap);
            if(temp > -1){
                answer += temp;
            } else{
                answer = temp;
            }
        }
        return answer;
    }
    
    public static int bfs(int start_c, int start_r, int dest_c, int dest_r, char[][] map){
        boolean[][] visited = new boolean[col][row];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start_c, start_r, 0});
        visited[start_c][start_r] = true;
            
        int[] mc = new int[] {-1, 1, 0, 0};
        int[] mr = new int[] {0, 0, -1, 1};
        int cc, cr, cd, nc, nr;
        
        while(!queue.isEmpty()){
            cc = queue.peek()[0];
            cr = queue.peek()[1];
            cd = queue.peek()[2];
            queue.poll();
            
            if(cc == dest_c && cr == dest_r){
                return cd;
            }
            
            for(int mv = 0; mv < 4; mv++){
                nc = cc + mc[mv];
                nr = cr + mr[mv];
                
                if(nc < 0 || col <= nc || nr < 0 || row <= nr){
                    continue;
                }
                
                if(map[nc][nr] != 'X' && !visited[nc][nr]){
                    visited[nc][nr] = true;
                    queue.add(new int[] {nc, nr, cd+1});
                }
            }
        }
        return -1;
    }
}