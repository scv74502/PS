import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> numberSum = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1;i++){
            for(int j = i + 1; j < numbers.length; j++){
                numberSum.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[numberSum.size()];
        int idx = 0;
        for(int num:numberSum){
            answer[idx] = num;
            idx++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}