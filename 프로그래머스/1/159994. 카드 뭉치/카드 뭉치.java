import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {        
        int idx = 0;
        int cards = cards1.length + cards2.length;
        int words = goal.length;
        
        Queue<String> cardsQueue1 = new ArrayDeque<>();
        Queue<String> cardsQueue2 = new ArrayDeque<>();
        
        for(String card: cards1){
            cardsQueue1.add(card);
        }
        
        for(String card: cards2){
            cardsQueue2.add(card);
        }
        
        while(idx < goal.length || (!cardsQueue1.isEmpty() && cardsQueue2.isEmpty())){
            if(!cardsQueue1.isEmpty() && cardsQueue1.peek().equals(goal[idx])){
                cardsQueue1.poll();                
            } else if (!cardsQueue2.isEmpty() && cardsQueue2.peek().equals(goal[idx])){
                cardsQueue2.poll();                
            }
            idx++;
            
            if(idx == goal.length) break;
        }
        
        if(words == cards - cardsQueue1.size() - cardsQueue2.size()) {
            return "Yes";
        } else { 
            return "No";
        }
            
    }
}