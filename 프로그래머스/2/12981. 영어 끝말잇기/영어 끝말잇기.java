import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int idx = 0;
        HashSet<String> checkedWord = new HashSet<>();
        char firstChar = ' ';
        
        while(idx < words.length){             
            String curWord = words[idx];
            System.out.println(idx + ", curWord: " + curWord);
            // 처음 등장 단어면 통과
            if(idx == 0) {
                firstChar = curWord.charAt(curWord.length() - 1);
                checkedWord.add(curWord);
                idx++;
                continue;
            }
            
            // 다음 단어로 넘어가기 전 검사
            if(curWord.charAt(0) != firstChar || checkedWord.contains(curWord)) {
                System.out.println("defeated! -> " + idx + ", curWord: " + curWord);
                int defeatedUserIdx = (idx) % n + 1;
                int defeatedTurnIdx = idx / n + 1;
                return new int[] {defeatedUserIdx, defeatedTurnIdx};
            }
            
            idx++;                        
            
            firstChar = curWord.charAt(curWord.length() - 1);
            checkedWord.add(curWord);                        
        }

        return new int[] {0, 0};
    }
}