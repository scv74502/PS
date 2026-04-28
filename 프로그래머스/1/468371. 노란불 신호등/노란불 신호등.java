import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int N = signals.length;
        
        // 각각 몇 초마다 사이클이 생기는지, 현재 색깔 정보, 몇 초에 어떤 색깔인지 정보
        int[] cycleInfo = new int[N];
        int[] curStatus = new int[N];
        ArrayList<Integer>[] colorInfo = new ArrayList[N];    // 0이 초록색, 1이 노란색, 2가 빨간색        
        
        for(int i = 0; i < N; i++){
            colorInfo[i] = new ArrayList<>();
            colorInfo[i].add(-1);
            
            // 현재 신호등 R, G, B
            int[] curArr = signals[i];            
            int sum = 0;            
            for(int j = 0; j < curArr.length; j++) {                
                sum += curArr[j];    
                for(int k = 0; k < curArr[j]; k++){
                    colorInfo[i].add(j);
                }
            }
            cycleInfo[i] = sum;                                    
        }
        
        // System.out.println(Arrays.toString(colorInfo));
        int maxTime = 1;
        for(int time:cycleInfo){
            maxTime *= time;
        }
        
        for(int curTime = 1; curTime <= maxTime; curTime++){
            for(int i = 0; i < N; i++){
                int curColor = colorInfo[i].get(curTime % cycleInfo[i]);
                curStatus[i] = curColor;
            }
                        
            boolean allSameColor = true;
            for(int i = 1; i < N; i++){                
                if(curStatus[i-1] != curStatus[i]){
                    allSameColor = false;
                    break;
                }
            }                        
            if(allSameColor && curStatus[0] == 1) return curTime;
        }
                
        return -1;
    }
}