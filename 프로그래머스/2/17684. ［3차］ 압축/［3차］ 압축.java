import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int msg_idx = 0;
        int cursor = 0;
        int hm_idx = 'Z'-'A';
        String key, existsKey;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> hm = new HashMap<>();
        for(int i = 'A'; i <= 'Z'; i++){
            hm.put(String.valueOf((char)i), i - 'A' + 1);
        }
        // System.out.println(hm);
        
        //String test = "KAKAO";
        //for(int i = 0; i < test.length(); i++){
            //System.out.println(test.substring(4, 5));
        //}
        
        while(msg_idx < msg.length() && cursor < msg.length()){
            key = msg.substring(msg_idx, msg_idx + 1);
            while(hm.containsKey(key) && cursor < msg.length() ){                
                cursor++;                
                key += msg.substring(cursor, Math.min(cursor+1, msg.length()));                                            
                
            }
            System.out.println(key);
            if(!hm.containsKey(key)){
                if(key.length() > 1) {
                    //System.out.println(key.substring(0, key.length() - 1));
                    answer.add(hm.get(key.substring(0, key.length() - 1)));
                } else{
                    //System.out.println(key);
                    answer.add(hm.get(key));
                }
                hm.put(key, hm_idx + 2);
                //System.out.println(hm);
                hm_idx++;
            } else {
                answer.add(hm.get(key));
            }
            msg_idx = cursor;
        } 
        // System.out.println(hm);
        // System.out.println(answer);
        
        int[] answers = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            answers[i] = answer.get(i);
        }
        
        //return answers;
        return answers;
    }
}