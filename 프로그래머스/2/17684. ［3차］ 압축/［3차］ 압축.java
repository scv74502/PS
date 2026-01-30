import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> chMap = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for(char ch = 'A'; ch <= 'Z'; ch++){
            chMap.put(Character.toString(ch), (int)(ch - 'A' + 1));
        }
        
        char[] message = msg.toCharArray();        
        StringBuilder sb = new StringBuilder();        
        
        int idx = 0;
        
        while(idx < msg.length()){
            sb.setLength(0);
            sb.append(message[idx]);
            int nextIdx = idx + 1;
            
            while(nextIdx < msg.length()){
                sb.append(message[nextIdx]);
                
                if(chMap.containsKey(sb.toString())){
                    nextIdx++;
                } else {
                    sb.setLength(sb.length() - 1);
                    break;
                }
            }
            
            resultList.add(chMap.get( sb.toString()) );
            
            if (nextIdx < msg.length()) {
                sb.append(message[nextIdx]);
                chMap.put(sb.toString(), chMap.size() + 1);                
            }
            idx = nextIdx;
        }
                
      
        int[] answer = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) answer[i] = resultList.get(i);
        
        return answer;
    }
} 