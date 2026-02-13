import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 사전순 정렬, 문자열 오름차순 - 길이 오름차순
        Arrays.sort(phone_book);        

        // 인접한 두 번호만 비교 
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {  // 사전순 정렬로 인해 접두어는 바로 뒤에 위치함
                return false;
            }
        }

        return true;
    }
}