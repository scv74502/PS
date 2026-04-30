import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        String[] words = message.split(" ");
        boolean[] spoilerRange = new boolean[message.length() + 1];
        int[][] wordInfo = new int[words.length][2];    // 단어의 시작과 끝
        
        for(int[] spoiler: spoiler_ranges) {
            int start = spoiler[0];
            int end = spoiler[1];
            
            for(int i = start; i <= end; i++) {
                spoilerRange[i] = true;
            }
        }
        
        // 단어별로 시작위치, 끝나는 위치 설정
        int wordStart = 0;        
        for(int i = 0; i < words.length; i++){
            int wordEnd = wordStart + words[i].length() - 1;
            wordInfo[i][0] = wordStart;
            wordInfo[i][1] = wordEnd;
            wordStart = wordEnd + 2;
        }
                
        // 각각 스포일러 방지 단어, 중요하지 않은 단어, 이전에 등장했던 단어(스포방지 구간 외)
        HashSet<String> spoilerAlertWords = new HashSet<>();
        HashSet<String> notImportantWords = new HashSet<>();        
                
        // System.out.println(Arrays.toString(words));
        // System.out.println(Arrays.toString(spoilerRange));
        // System.out.println(Arrays.deepToString(wordInfo));
        
        for(int i = 0; i < words.length; i++) {
            boolean isSpoilerWord = false;
            for(int j = wordInfo[i][0]; j <= wordInfo[i][1]; j++){                
                if(spoilerRange[j]) {                    
                    spoilerAlertWords.add(words[i]);                    
                    isSpoilerWord = true;
                    break;
                }
            }
            
            if(!isSpoilerWord) {
                notImportantWords.add(words[i]);
            }
        }
        
        // System.out.println(spoilerAlertWords);
        // System.out.println(notImportantWords);
        
        spoilerAlertWords.removeAll(notImportantWords);        
        return spoilerAlertWords.size();
    }
}