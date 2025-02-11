import java.util.*;


class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {                
        int answer = 0;
        int workers = schedules.length;
        int[] cntChk = new int[workers];
        
        
        for(int i = 0; i < workers; i++){
            int deadline = schedules[i] + 10;
            deadline = ((deadline / 100) + ((deadline % 100) / 60)) * 100 + ((deadline % 100) % 60);
            // System.out.println(deadline);
            
            for(int j = 0; j < 7; j++){
                // 0 ~ 6까지 요일 나타내기
                // 0이 월요일이고 6이 일요일
                int curDay = startday - 1 + j;
                // 현재 요일
                int day = curDay % 7;
                // System.out.println("day : "+day+", time : " + timelogs[i][j] +", deadline : "+deadline);
                
                // 토요일 일요일은 무시
                if(5 <= day) continue;
                
                if(timelogs[i][j] <= deadline){
                    cntChk[i]++;                                
                // System.out.println("day : "+day+", "+Arrays.toString(cntChk));
                }
            }
            if(cntChk[i] >= 5) answer++;            
            // System.out.println(Arrays.toString(cntChk));
        }
        
        
        
        return answer;
    }
}