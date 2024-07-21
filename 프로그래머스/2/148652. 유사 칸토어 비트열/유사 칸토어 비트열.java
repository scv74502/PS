import java.util.*;

class Solution {
    public static long count_1(long num){
        if(num <= 5){
            int right = (int)num;
            return "11011".substring(0, right).chars()                
                .filter(c -> c == '1')                
                .count();            
        }
        int base = 1;
        while(Math.pow(5, base + 1) < num){
            base++;
        }
        
        long section = num / (long)Math.pow(5, base);
        long remainder = num % (long)Math.pow(5, base);
        
        long answer = section * (long)(Math.pow(4, base));
        
        if(section >= 3){
            answer -= (Math.pow(4, base));
        }
        
        if(section == 2){
            return answer;
        } else {
          return answer + count_1(remainder);
        }
    }
    
    public long solution(int n, long l, long r) {
        return count_1(r) - count_1(l-1);
    }
}