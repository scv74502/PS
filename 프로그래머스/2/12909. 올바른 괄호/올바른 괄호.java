import java.util.*;

class Solution {
    boolean solution(String s) {        

        Stack<Character> stack = new Stack<>();
        
        for(char ch:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            } else if(ch == ']' && stack.peek() == '['){
                stack.pop();
                continue;
            } else if(ch == '}' && stack.peek() == '{'){
                stack.pop();
                continue;
            } else if(ch == ')' && stack.peek() == '('){
                stack.pop();
                continue;
            }
            
            stack.push(ch);
        }

        return stack.isEmpty();
    }
}