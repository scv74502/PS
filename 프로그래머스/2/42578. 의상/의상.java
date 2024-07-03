import java.util.*;


class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        
        for(String[] cloth:clothes){            
            if(!hm.containsKey(cloth[1])){
                hm.put(cloth[1], new ArrayList<String>());
                hm.get(cloth[1]).add(cloth[0]);
            }
            else{
                hm.get(cloth[1]).add(cloth[0]);
            }
        }
        System.out.println(hm.keySet());
        for(String key:hm.keySet()){
            //System.out.println(hm.get(key));
            answer *= (hm.get(key).size() + 1);
        }
        return answer - 1;
    }
}