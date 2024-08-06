import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] strNum = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            strNum[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strNum, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){                
                sb.append(s1);
                sb.append(s2);
                int test1 = Integer.parseInt(sb.toString());
                sb.setLength(0);
                
                sb.append(s2);
                sb.append(s1);
                int test2 = Integer.parseInt(sb.toString());
                sb.setLength(0);
                
                return test2 - test1;                
            }
        });
        
        // System.out.println(Arrays.toString(strNum));
        for(int i = 0; i < numbers.length; i++){
            sb.append(strNum[i]);
        }
        
        // 배열이 모두 0인 경우가 있다!!
        if(strNum[0].equals("0")){
            return "0";
        }         
        
        String answer = sb.toString();
        return answer;        
    }
}