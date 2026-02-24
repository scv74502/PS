class Solution {
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        bt(0, 0, k, dungeons, visited);
        return answer;
    }
    
    // 탐색 깊이, 방문한 던전수, 피로도, 던전정보배열, 방문기록
    public void bt(int depth, int checkedDungeon, int health, int[][] dungeons, boolean[] visited){
        if(depth == dungeons.length){
            answer = Math.max(answer, checkedDungeon);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            if(health >= dungeons[i][0]){                
                bt(depth + 1, checkedDungeon + 1, health - dungeons[i][1], dungeons, visited);                
            } else {
                bt(depth + 1, checkedDungeon, health, dungeons, visited);
            }            
            visited[i] = false;
        }
    }
}