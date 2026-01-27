import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int THRESHOLD = 10;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < THRESHOLD; i++){
            if(!hm.containsKey(discount[i])) hm.put(discount[i], 1);
            else hm.put(discount[i], hm.get(discount[i]) + 1);
        }
        
        HashMap<String, Integer> target = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            target.put(want[i], number[i]);
        }
        
        int joinDay = 1;
        int answer = 0;
        
        // 첫날 검사
        if(check(hm, target)) answer++;
        
        while(joinDay + THRESHOLD <= discount.length){            
            hm.put(discount[joinDay - 1], hm.get(discount[joinDay - 1]) - 1);            
            if(!hm.containsKey(discount[THRESHOLD + joinDay - 1])) hm.put(discount[THRESHOLD + joinDay - 1], 1);
            else hm.put(discount[THRESHOLD + joinDay - 1], hm.get(discount[THRESHOLD + joinDay - 1]) + 1);
            
            joinDay++;
            
            if(check(hm, target)) answer++;                        
        }
        
        return answer;
    }
    
    public boolean check(HashMap<String, Integer> hm, HashMap<String, Integer> target){        
        for(String key: target.keySet()){
            if(!hm.containsKey(key) || hm.get(key) != target.get(key)) return false;
        }
        
        return true;
    }
}