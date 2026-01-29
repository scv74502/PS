import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
        HashMap<String, HashSet<String>> userReportRecord = new HashMap<>();    // key의 사용자를 신고한 사용자들 목록이 value에 담김
        HashMap<String, Integer> userReportedCnt = new HashMap<>();
        HashMap<String, Integer> userNumberDict = new HashMap<>();
        
        int idx = 0;
        for(String user: id_list){
            userReportRecord.put(user, new HashSet<>());            
            userReportedCnt.put(user, 0);
            userNumberDict.put(user, idx++);
        }
        
        for(String record: report) {
            String[] ipt = record.split(" ");
            String reporter = ipt[0];
            String reported = ipt[1];
            
            // 사용자가 여러 번 신고했으면 생략한다
            if(userReportRecord.get(reported).contains(reporter)){                
                continue;
            }
            
            userReportRecord.get(reported).add(reporter);
            userReportedCnt.put(reported, userReportedCnt.get(reported) + 1);                
        }
         
        int[] answer = new int[N];        
        for(int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            // 해당 사용자가 정지되었으면, 정지된 사용자 신고했던 다른 사용자들은 메일 받음
            if(userReportedCnt.get(user) >= k) {
                for(String receiver: userReportRecord.get(user)){
                    answer[userNumberDict.get(receiver)] += 1;                
                }                
            }        
        }                
        
        return answer;
    }
}