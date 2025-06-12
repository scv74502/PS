import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(char ch:s.toCharArray()){
            // System.out.println(stack);
            if(stack.isEmpty() || stack.peek() != ch){
                stack.add(ch);
            } else{
                if(ch == stack.peek()) stack.pop();
            }
        }
        
        // System.out.println(stack);
        
        return stack.isEmpty() ? 1 : 0;
    }
}