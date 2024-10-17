import java.util.*;


class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int num = 0;
        int idx = 0;
        
        Queue<Integer> conveyer = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 1; i <= order.length; i++){
            conveyer.add(i);
        }
        
        while(true){
            while(!conveyer.isEmpty()){
                num = conveyer.poll();
                
                if(order[idx] == num){
                    answer++;
                    idx++;
                    
                    while(!stack.isEmpty() && order[idx] == stack.peek()){
                        answer++;
                        idx++;
                        stack.pop();
                    }
                } else{
                    stack.add(num);
                }                                
            }
            
            while(!stack.isEmpty() && order[idx] == stack.peek()){
                answer++;
                idx++;
                stack.pop();
            }
            
            if(conveyer.isEmpty() && 
                ((!stack.isEmpty() && order[idx] != stack.peek()) || (stack.isEmpty() && answer == order.length) ) ){
                break;
            }
        }
        
        return answer;
    }
}