class Solution {
    public int solution(int[][] signals) {
        int timeUpperBound = 1;
        int[] cycle = new int[signals.length];
        
        for(int i = 0; i < signals.length; i++){            
            int summary = 0;
            for(int time: signals[i]){
                summary += time;
            }
            cycle[i] = summary;
            timeUpperBound *= summary;
        }
        
        for(int curTime = 1; curTime <= timeUpperBound; curTime++){
            boolean isAllYellow = true;
            
            for(int i = 0; i < signals.length; i++){
                int modTime = (curTime - 1) % cycle[i];
                int greenBound = signals[i][0];
                int yellowBound = signals[i][0] + signals[i][1];
                
                if(!(greenBound <= modTime && modTime < yellowBound)){
                    isAllYellow = false;
                    break;
                }
            }
            
            if(isAllYellow) return curTime;
        }
        System.out.println(timeUpperBound);
        return -1;
    }
}