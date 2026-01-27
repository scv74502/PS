import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<Integer> cards1Queue = new LinkedList<>();
        Queue<Integer> cards2Queue = new LinkedList<>();
        
        for(int i = 0; i < cards1.length; i++){
            cards1Queue.add(i);
        }
        
        for(int i = 0; i < cards2.length; i++){
            cards2Queue.add(i);
        }
        
        int goalIdx = 0;
        
        while(goalIdx < goal.length){
            if(!cards1Queue.isEmpty() && cards1[cards1Queue.peek()].equals(goal[goalIdx])){
                cards1Queue.poll();
            } else if(!cards2Queue.isEmpty() && cards2[cards2Queue.peek()].equals(goal[goalIdx])){
                cards2Queue.poll();
            } else{
                return "No";
            }
            goalIdx++;
        }
        

        return "Yes";
    }
}