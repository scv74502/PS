import java.util.*;
class Solution {
    // 상 하 좌 우
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    static boolean[][] isRemoved;
    static boolean[][] containerWithExit;
    static boolean[][] visited;
    static int Row, Col;
    public int solution(String[] storage, String[] requests) {
        Row = storage.length;
        Col = storage[0].length();
        isRemoved = new boolean[Row][Col];
        containerWithExit = new boolean[Row][Col];

        int answer = 0;

        for(String request:requests){
            if(request.length() == 1){
                useForkLift(storage, request.charAt(0));
            } else{
                useCrane(storage, request.charAt(0));
            }
            // System.out.println(Arrays.deepToString(isRemoved));
            // System.out.println(Arrays.deepToString(containerWithExit));
            // System.out.println();
        }
        // System.out.println("final answer = "+answer);
        return countRemainContainers();
    }
    
    public static void useForkLift(String[] storage, char target) {
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Col; j++){
                if(!isRemoved[i][j] && storage[i].charAt(j) == target){
                    if(isAccessible(i, j)){
                        isRemoved[i][j] = true;                        
                    }
                }
            }
        }
        accessRenew();
    }
    
    public static void useCrane(String[] storage, char target){
        // 1. 하나씩 target와 같은 알파벳 블럭 제거하며 주위 탐색하여 접근 가능한지 판단
        // 2. 접근 가능하다면 주위 4칸도 접근 가능하게 처리함        
        
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Col; j++){
                if(!isRemoved[i][j] && storage[i].charAt(j) == target){                    
                    isRemoved[i][j] = true;                    
                    // if(isAccessible(i, j)){
                        // System.out.println("isAccessible i = " + i + ", j : " + j);
//                         for(int mv = 0; mv < 4; mv++){
//                             int nr = i + dr[mv];
//                             int nc = j + dc[mv];
                
//                             if(nr >= 0 && nc >= 0 && Row > nr && Col > nc){
//                                 containerWithExit[nr][nc] = true;
//                             }                            
//                         }        
                        // containerWithExit[i][j] = true;
                    // }
                }
            }
        }
        accessRenew();
    }
    
    private static boolean isAccessible(int r, int c) {
        for(int mv = 0; mv < 4; mv++){
            int nr = r + dr[mv];
            int nc = c + dc[mv];
            
            if(nr < 0 || nc < 0 || Row <= nr || Col <= nc || (containerWithExit[nr][nc] && isRemoved[nr][nc])) return true;
        }
        return false;
    }
    
    // 접근가능 판단 가능하게 하는 함수
    public static void accessRenew(){
        visited = new boolean[Row][Col];
        
        for(int i = 0; i < Row; i++){
            if(isRemoved[i][0] && !visited[i][0]){
                bfs(i, 0);
            }
            
            if(isRemoved[i][Col-1] && !visited[i][Col-1]){
                bfs(i, Col-1);
            }
        }
        
        for(int i = 1; i < Col - 1; i++){
            if(isRemoved[0][i] && !visited[0][i]){
                bfs(0, i);
            }
            
            if(isRemoved[Row-1][i] && !visited[Row-1][i]){
                bfs(Row-1, i);
            }
        }
    }
    
    public static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        
        
        while(!queue.isEmpty()){
            int cr = queue.peek()[0];
            int cc = queue.peek()[1];
            queue.poll();
                        
            containerWithExit[cr][cc] = true;
            
             for(int mv = 0; mv < 4; mv++){
                 int nr = cr + dr[mv];
                 int nc = cc + dc[mv];
                 
                 if(nr >= 0 && nc >= 0 && Row > nr && Col > nc && !visited[nr][nc] && isRemoved[nr][nc]){
                     queue.add(new int[] {nr, nc});
                     visited[nr][nc] = true;
                 }
             }
        }
    }
    
    public static int countRemainContainers(){
        int result = 0;
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Col; j++){           
                if(!isRemoved[i][j]) result++;
            }
        }
        return result;
    }
}