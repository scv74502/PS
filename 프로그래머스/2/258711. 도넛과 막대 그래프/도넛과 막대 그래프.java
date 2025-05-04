class Solution {
    public int[] solution(int[][] edges) {
        int VERTEX_COUNT = -1;
        
        for(int[] edge:edges){
            VERTEX_COUNT = Math.max(VERTEX_COUNT, edge[0]);
            VERTEX_COUNT = Math.max(VERTEX_COUNT, edge[1]);
        }
        
        int[] inCnt = new int[VERTEX_COUNT + 1];
        int[] outCnt = new int[VERTEX_COUNT + 1];
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            inCnt[v]++;
            outCnt[u]++;
        }
        
        // System.out.println(VERTEX_COUNT);
        
        int[] answer = {0, 0, 0, 0};
        
        for(int i = 1; i <= VERTEX_COUNT; i++){
            if(inCnt[i] == 0 && outCnt[i] >= 2){    // 생성 노드
                answer[0] = i;
            } 
            
            else if (inCnt[i] >= 1 && outCnt[i] == 0){  // 막대 그래프
                answer[2] += 1;
            } 
            
            else if (inCnt[i] >= 2 && outCnt[i] == 2){  // 8자 그래프
                answer[3] += 1;
            } 
        }
        
        answer[1] = outCnt[answer[0]] - (answer[2] + answer[3]);
        
        return answer;
    }
}