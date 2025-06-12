import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){        
            if(isValidString(s)) answer++;
            s = rotateString(s);
        }
        
        return answer;
    }
    
    public boolean isValidString(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.add(ch);
            } else{
                if(stack.isEmpty()) return false;
                
                if(ch == ')' && stack.peek() == '(') stack.pop();
                else if(ch == '}' && stack.peek() == '{') stack.pop();
                else if(ch == ']' && stack.peek() == '[') stack.pop();
                else break;
            }
        }
        return stack.isEmpty();
    }
    
    public String rotateString(String str){
        return str.substring(1, str.length()) + str.charAt(0);
    }
}