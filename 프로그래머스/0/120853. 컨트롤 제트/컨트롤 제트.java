import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Integer> numbers = new Stack<>();
        String[] ipt = s.split(" ");
        
        for(String str: ipt){
            if(str.equals("Z")) numbers.pop();
            else numbers.push(Integer.parseInt(str));
        }
        
        while(!numbers.isEmpty()){
            answer += numbers.pop();
        }
        
        return answer;
    }
}