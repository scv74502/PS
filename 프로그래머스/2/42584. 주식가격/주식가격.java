import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();        
        stack.add(0);
        
        for(int i = 1; i < N; i++) {
            int curPrice = prices[i];
            // System.out.println(stack + ", " + stack.peek()  + ", " +  curPrice);            
            while(!stack.isEmpty() && prices[stack.peek()] > curPrice) {
                int curIdx = stack.pop();                    
                answer[curIdx] = i - curIdx;                
            }
            stack.add(i);
            // System.out.println(Arrays.toString(answer));
        }
        // System.out.println(stack + ", " + stack.peek());
        while(!stack.isEmpty()) {
            int curIdx = stack.pop();                    
            answer[curIdx] = N - curIdx - 1;
        }
        
        return answer;
    }
}