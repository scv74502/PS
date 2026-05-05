import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] convertedTime = new int[timetable.length];
        for(int i = 0; i < convertedTime.length; i++) {
            convertedTime[i] = toIntTime(timetable[i]);
        }
        
        Arrays.sort(convertedTime);        
        
        // 9시인 540분부터 버스 태우기 시뮬레이션
        int curTime = 540;
        int crewIdx = 0;
        
        for(int i = 0; i < n; i++) {
            int crewOnBus = 0;
            int lastCrewTime = -1;
            while(crewIdx < convertedTime.length && convertedTime[crewIdx] <= curTime && crewOnBus < m) {
                lastCrewTime = convertedTime[crewIdx];
                crewOnBus++;
                crewIdx++;
            }
            
            // System.out.println("crewIdx:" + crewIdx);
            
            // 현재 마지막 버스라면
            if(i == n - 1) {
                // System.out.println(curTime + ", crewIdx:" + crewIdx + ", crewOnBus:" + crewOnBus);
                if(crewOnBus < m) return toStringTime(curTime);
                else {
                    return toStringTime(lastCrewTime - 1);   
                }
            }
            curTime += t;
        }
        
        return "";
    }
    
    public int toIntTime(String time){
        String[] splitedTime = time.split(":");
        return Integer.parseInt(splitedTime[0]) * 60 + Integer.parseInt(splitedTime[1]);
    }
    
    public String toStringTime(int time) {
        int hour = time / 60;
        int minute = time % 60;
        
        StringBuilder sb = new StringBuilder();
        
        if(hour < 10) sb.append("0");
        sb.append(hour);
        
        sb.append(":");
        
        if(minute < 10) sb.append("0");
        sb.append(minute);
        
        return sb.toString();
    }
}