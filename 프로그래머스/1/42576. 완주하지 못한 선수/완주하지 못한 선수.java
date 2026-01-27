import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        // 동명이인
        for(String person:participant){
            if(hm.containsKey(person)){
                hm.put(person, hm.get(person) + 1);
            } else {
                hm.put(person, 1);
            }
        }
        
        for(String person:completion){
            hm.put(person, hm.get(person) - 1);
        }
        
        for(String person:hm.keySet()){
            if(hm.get(person) != 0){
                return person;
            }
        }
        
        String answer = "";
        return answer;
    }
}