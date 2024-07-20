import java.util.*;
import java.time.*;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int[] result;
        Map<String, Integer> termsMap = new HashMap<>();
        String[] ipt, days;
        int year, month, day;
        String[] date;        
        StringBuilder sb = new StringBuilder();
        int[] curDate = new int[3];
        ipt = today.split("[.]");
        for(int i = 0; i < 3; i++){
            curDate[i] = Integer.parseInt(ipt[i]);
        }
        
        // 약관 처리하기
        for(String term:terms){
            ipt = term.split(" ");
            termsMap.put(ipt[0], Integer.parseInt(ipt[1]));
        }
        
        // 반복문 끝나고 변수영역에서 소멸되면 새로 선언
        String term;
        
        // 만료일 처리하는 배열
        int[][] expireDates = new int[privacies.length][3];
        
        for(int i = 0; i < privacies.length; i++){
            ipt = privacies[i].split(" ");
            date = ipt[0].split("[.]");
            term = ipt[1];
            year = Integer.parseInt(date[0]);
            month = Integer.parseInt(date[1]);
            day = Integer.parseInt(date[2]);
            
            month += termsMap.get(term);
            // 12월 넘어가는 경우라면
            if(month > 12){
                // 몫과 나머지로 처리하면 12월을 처리할 수 없으므로 12를 빼줌
                while(month > 12){
                    month -= 12;
                    year += 1;
                }
            }
            
            if(day == 1){
                month -= 1;
                day = 28;
            } else {
                day -= 1;
            }
            expireDates[i][0] = year;
            expireDates[i][1] = month;
            expireDates[i][2] = day;
            
            if(curDate[0] > expireDates[i][0]){ 
              //  System.out.println(Arrays.toString(expireDates[i]));
                answer.add(i+1);
            } else if(curDate[0] == expireDates[i][0] && curDate[1] > expireDates[i][1]){
                //System.out.println(Arrays.toString(expireDates[i]));
                answer.add(i+1);                
            } else if(curDate[0] == expireDates[i][0] && curDate[1] == expireDates[i][1] && curDate[2] > expireDates[i][2]){
               // System.out.println(Arrays.toString(expireDates[i]));
                answer.add(i+1);    
            } else{
                continue;
            }
        }
        //for(int[] expireDate:expireDates){
//            System.out.println(Arrays.toString(expireDate));
  //      }
        //System.out.println(answer);
        //return new int[3];
        result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}