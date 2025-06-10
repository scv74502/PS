import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int questionAmount = answers.length;
        
        int[] firstAnswer = new int[questionAmount];
        int[] secondAnswer = new int[questionAmount];
        int[] thirdAnswer = new int[questionAmount];
        
        int[] secondPattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < questionAmount; i++){
            firstAnswer[i] = (i % 5) + 1;
            secondAnswer[i] = secondPattern[i % secondPattern.length];
            thirdAnswer[i] = thirdPattern[i % thirdPattern.length];
        }
        
        // System.out.println(Arrays.toString(firstAnswer));
        // System.out.println(Arrays.toString(secondAnswer));
        // System.out.println(Arrays.toString(thirdAnswer));
        int[] result = new int[3];
        
        for(int i = 0; i < questionAmount; i++){
            if(firstAnswer[i] == answers[i]) result[0]++;
            if(secondAnswer[i] == answers[i]) result[1]++;
            if(thirdAnswer[i] == answers[i]) result[2]++;
        }
        
        ArrayList<Integer> maxScoreStudents = new ArrayList<>();
        
        int curMaxScore = -1;
        
        for(int i = 0; i < 3; i++){
            if(result[i] > curMaxScore){
                curMaxScore = result[i];
                maxScoreStudents.clear();
                maxScoreStudents.add(i + 1);
            } else if (result[i] == curMaxScore){
                maxScoreStudents.add(i + 1);
            }
        }
        
        int[] answer = new int[maxScoreStudents.size()];
        
        for(int i = 0; i < maxScoreStudents.size(); i++){
            answer[i] = maxScoreStudents.get(i);
        }
        return answer;
    }
}