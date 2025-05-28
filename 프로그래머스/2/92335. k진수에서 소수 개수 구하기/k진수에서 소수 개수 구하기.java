import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String kNum = Integer.toString(n, k);
        // System.out.println(kNum);
                
        String[] splited = kNum.split("0");
        // System.out.println(Arrays.toString(splited));
        int answer = 0;
        
        for(String str:splited){
            if(str.equals("")) continue;
            long num = Long.parseLong(str);
            
            // System.out.println(num);                
            
            if(isPrime(num)) answer++;
            // else System.out.println("not Prime");
        }                                
                
        return answer;
    }
    
    public static boolean isPrime(long number){
        if(number <= 1) return false;
        
        // System.out.println("isPrime()");
        // System.out.println(number);
        // System.out.println(Math.sqrt(number));
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) {
                // System.out.println("edge case : " + i);
                return false;
            }
        }
        // System.out.println("isPrime!");
        return true;
    }
}