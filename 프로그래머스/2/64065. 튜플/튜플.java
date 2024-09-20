import java.util.*;

class Solution {
    public String[] parseString(String s){
        return s.replace("{", "").replace("}", "").split(",");
    }
    
    public int[] solution(String s) {
        String[] parsed = parseString(s);  
        HashMap<String, Integer> hm = new HashMap<>();        
        
        for(String str:parsed){
            // int num = Integer.parseInt(str);
            if(!hm.containsKey(str)){
                hm.put(str, 1);
            } else{
                hm.put(str, hm.get(str) + 1);
            }
        }
        
        //System.out.println(Arrays.toString());
        
        String[] answer = hm.keySet().toArray(new String[0]);
        
        Arrays.sort(answer, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return hm.get(o2) - hm.get(o1);
            }
        });
        
        // System.out.println(Arrays.toString(answer));
        
        return Arrays.stream(answer).mapToInt(Integer::parseInt).toArray();
    }
}