import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> chul = new HashMap<>();
        HashMap<Integer, Integer> brother = new HashMap<>();
        
        for(int ing:topping){
            if(!chul.containsKey(ing)){
                chul.put(ing, 1);
            } else{
                chul.put(ing, chul.get(ing) + 1);
            }
        }
        
        System.out.println(chul);        
        int answer = 0;
        
        for(int ing:topping){
            if(!brother.containsKey(ing)){
                brother.put(ing, 1);                
            } else{
                brother.put(ing, brother.get(ing) + 1);                
            }            
            
            chul.put(ing, chul.get(ing) - 1);                
            if(chul.get(ing) == 0){
                chul.remove(ing);
            }
            
            if(chul.size() == brother.size()){
                answer++;
            }
            // System.out.println("chul : " + chul);
            // System.out.println("brother : " + brother);
        }
        
        
        return answer;
    }
}