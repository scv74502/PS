import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < N; i++){
            // System.out.println(stack);
            // 스택이 비지 않았고 가격이 떨어졌다면
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                // System.out.println("check : " + stack);
                // 그 가격이 얼마나 떨어지지 않았는지 체크
                int cur_idx = stack.pop();
                answer[cur_idx] = i - cur_idx;
            }
            
            stack.add(i);
        }
        
        // 스택이 비지 않았고 가격이 떨어졌다면
        while(!stack.isEmpty()){
            // 그 가격이 얼마나 떨어지지 않았는지 체크
            int cur_idx = stack.pop();
            answer[cur_idx] = N - 1 - cur_idx;
        }
            
        return answer;
    }
}