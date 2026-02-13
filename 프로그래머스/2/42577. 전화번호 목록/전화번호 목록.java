import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length).reversed()
                                  .thenComparing(Comparator.naturalOrder()));
        
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String pNum: phone_book){
            set.add(pNum);
        }
        
        for(String pNum: phone_book){
            for(int i = 0; i < pNum.length() - 1; i++){
                sb.append(pNum.charAt(i));
                if (set.contains(sb.toString())) return false;                
            }
            sb.setLength(0);
        }
        
        return true;
    }
}