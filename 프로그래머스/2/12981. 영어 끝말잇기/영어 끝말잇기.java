import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        char lastChar = words[0].charAt(0); // 첫 단어 통과를 위해 첫 글자로 초기화

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // 탈락 조건: 끝말이 이어지지 않거나 이미 사용된 단어인 경우
            if (word.charAt(0) != lastChar || usedWords.contains(word)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            usedWords.add(word);
            lastChar = word.charAt(word.length() - 1);
        }

        return new int[]{0, 0};
    }
}