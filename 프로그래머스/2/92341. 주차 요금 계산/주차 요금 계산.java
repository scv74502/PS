import java.util.*;

class TimeRecord{
    int arrived;
    int leaved;
    
    TimeRecord(int arrived, int leaved){
        this.arrived = arrived;
        this.leaved = leaved;
    }
    
    @Override
    public String toString(){
        return "arrived : " + arrived + ", leaved : " + leaved;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, TimeRecord> hm = new HashMap<>();
        // 번호별로 총 주차시간 계산하는 해시맵
        Map<String, Integer> numTime = new HashMap<>();
        String[] ipt, time;
        String number, io;
        int hour, minute, temp, price;
        TimeRecord curRec;
        
        for(String record: records){
            ipt = record.split(" ");
            time = ipt[0].split(":");
            hour = Integer.parseInt(time[0]);
            minute = Integer.parseInt(time[1]);
            number = ipt[1];
            io = ipt[2];
            
            if(!hm.containsKey(number)){
                hm.put(number, new TimeRecord(hour * 60 + minute, 23 * 60 + 59));
            } else{
                // 출차된 차량이 다시 들어오는 경우, 현재까지 주차시간 정산하고 새로 기록함
                if(io.equals("IN")){
                    curRec = hm.get(number);
                    temp = curRec.leaved - curRec.arrived;
                    if(!numTime.containsKey(number)){
                        numTime.put(number, 0);
                    }
                    numTime.put(number, numTime.get(number) + temp);
                    curRec.arrived = hour * 60 + minute;
                    curRec.leaved = 23 * 60 + 59;
                    hm.put(number, curRec);                    
                } else{
                    curRec = hm.get(number);
                    curRec.leaved = hour * 60 + minute;
                    hm.put(number, curRec);                    
                }
                
            }
        }
        
        for(String key:hm.keySet()){
            //System.out.println(key);
            curRec = hm.get(key);
            temp = curRec.leaved - curRec.arrived;
            if(!numTime.containsKey(key)){
                numTime.put(key, 0);
            }
            numTime.put(key, numTime.get(key) + temp);
        }
        List<String> keyList = new ArrayList<>(numTime.keySet());
        Collections.sort(keyList);
        //System.out.println(keyList);
        
        //System.out.println(hm);
        System.out.println(numTime);
        
        int[] answer = new int[keyList.size()];
        for(int i = 0; i < keyList.size(); i++){
            temp = numTime.get(keyList.get(i));
            // 기본시간 뺌
            temp -= fees[0];
            // 기본시간 내에 출차하면 기본요금만
            if(temp <= 0){
                answer[i] = fees[1];
                continue;
            // 기본시간 지나 출차하면 기본요금에 추가시간만큼
            } else{                                
                price = (temp / fees[2] * fees[3]) + fees[1];
                // 단위시간 배수에서 1분이라도 넘겨 출차시 단위시간만큼 추가요금 + 기본요금
                 if(temp % fees[2] != 0){
                     price += fees[3];
                 }
                answer[i] = price;
            }
            // System.out.println(price);
        }
        return answer;
    }
}