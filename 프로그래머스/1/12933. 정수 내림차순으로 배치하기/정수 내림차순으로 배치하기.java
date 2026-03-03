import java.util.*;

class Solution {
    public long solution(long n) {
        char[] charArr = String.valueOf(n).toCharArray();
        Arrays.sort(charArr);                
        StringBuilder sb = new StringBuilder(new String(charArr));
        return Long.parseLong(sb.reverse().toString());
    }
}