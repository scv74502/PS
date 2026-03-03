import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {        
        int[] answer = new int[commands.length];
        for(int j = 0; j < commands.length; j++){
            int startIdx = commands[j][0] - 1;
            int endIdx = commands[j][1];
            int targetIdx = commands[j][2] - 1;
            
            int[] arr = new int[endIdx - startIdx];
            for(int i = startIdx; i < endIdx; i++){
                arr[i-startIdx] = array[i];
            }
            
            Arrays.sort(arr);
            answer[j] = arr[targetIdx];
        }
                
        return answer;
    }
}