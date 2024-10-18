import java.util.*;


class Solution {
    static HashMap<Character, Character> match;
    // static HashSet<Character> start;
    // static HashSet<Character> end;
    public int solution(String s) {
        if(s.length() % 2 == 1) return 0;
        
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String cur;
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for(int rpt = 0; rpt < s.length(); rpt++){
            queue.offer(s.charAt(rpt));
        }
        
        match = new HashMap<>();
        // start = new HashSet<>();
        // end = new HashSet<>();
        
        // match.put('[', ']');
        // match.put('{', '}');
        // match.put('(', ')');
        
        match.put(']', '[');
        match.put('}', '{');
        match.put(')', '(');
        
//         start.add('[');
//         start.add('{');
//         start.add('(');
        
//         end.add(']');
//         end.add('}');
//         end.add(')');
        
        sb.append(s);
        
        // 길이가 N인 문자열은 N-1번까지 회전시킴, 맨 처음 기본 문자열도 검사해야 함
        for(int rpt = 0; rpt < s.length(); rpt++){                        
            // rotate
            sb.append(sb.substring(0, 1));
            sb = sb.deleteCharAt(0);
            
            // init stack
            stack.clear();
            
            cur = sb.toString();
            // System.out.println(cur);
            
            for(char ch:cur.toCharArray()){                
                if(stack.isEmpty()){
                    stack.push(ch);
                    continue;
                }
                
                if(match.get(ch) == stack.peek()){
                    stack.pop();
                    continue;
                }
                
                stack.push(ch);
            }
            
            if(stack.isEmpty()){
               answer++; 
            }
        }
        
        return answer;
    }
}