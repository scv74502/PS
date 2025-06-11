import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challengeCnt = new int[N+2];
        PercentAndStage[] percentAndStage = new PercentAndStage[N];
        
        // 스테이지별 도전자 수를 구함
        for(int stage: stages){
            challengeCnt[stage]++;
        }
        
        int totalUser = stages.length;
        
        for(int i = 1; i <= N; i++){
            if(challengeCnt[i] == 0){
                percentAndStage[i-1] = new PercentAndStage(0f, i);
            } else{
                percentAndStage[i-1] = new PercentAndStage((float)challengeCnt[i] / totalUser, i);                
                totalUser -= challengeCnt[i];
            }
        }
        
      
        
        Arrays.sort(percentAndStage);
        // System.out.println(Arrays.toString(percentAndStage));
        
        int[] answer = new int[N];                
        
        for(int i = 0; i < N; i++){
            answer[i] = percentAndStage[i].stageNum;
        }
        
        return answer;
    }
    
    class PercentAndStage implements Comparable<PercentAndStage> {
        float percent;
        int stageNum;
        
        public PercentAndStage(float percent, int stageNum){
            this.percent = percent;
            this.stageNum = stageNum;
        }
        
        @Override
        public int compareTo(PercentAndStage p){
            if(p.percent == percent) return stageNum - p.stageNum;
            else return ((Float)p.percent).compareTo((Float)percent);
        }
        
        @Override
        public String toString(){
            return "percent : " + percent + ", stageNum : " + stageNum;
        }
    }
}