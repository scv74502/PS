import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--){
            if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() != arr[i]) ){
                stack.push(arr[i]);
            }
        }
        // System.out.println(stack);
        int[] answer = new int[stack.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = stack.pop();
        }
        return answer;
    }
}