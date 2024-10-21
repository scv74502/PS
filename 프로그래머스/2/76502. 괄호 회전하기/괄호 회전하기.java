import java.util.*;


class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String cur = s;
        sb.append(s);
        Stack<Character> stack = new Stack();
        
        for(int rpt = 0; rpt < s.length(); rpt++) {
            // System.out.println("cur : "+cur);
            for(char ch:cur.toCharArray()){
                if(stack.isEmpty()){
                    stack.push(ch);
                    continue;
                }
                else if(ch == ']'){
                    if(stack.peek() == '['){
                        stack.pop();
                        continue;
                    }
                } else if(ch == '}'){
                    if(stack.peek() == '{'){
                        stack.pop();
                        continue;
                    }
                } else if(ch == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                        continue;
                    }
                } 
                
                stack.push(ch);                
            }
            // System.out.println("stack : "+stack);
            if(stack.isEmpty()){
                answer++;
            }
            
            sb.setLength(0);
            // System.out.println(cur.substring(1));
            // System.out.println(cur.substring(0, 1));
            sb.append(cur.substring(1));
            sb.append(cur.substring(0, 1));
            cur = sb.toString();
            // System.out.println("cur : " + cur);
            stack.clear();
        }
        return answer;
    }
}