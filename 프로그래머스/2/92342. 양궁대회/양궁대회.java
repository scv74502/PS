class Solution {
    int[] answer = {};
    int maxDiff = -1;
    public int[] solution(int n, int[] info) {
        int[] record = new int[info.length];
        bt(n, 0, info, record);    
        if(maxDiff == -1) return new int[] {-1};
        return answer;
    }
    
    public void bt(int leftArrow, int idx, int[] apeach, int[] lion){
        // 마지막 인덱스(0점)에서 남은 화살 모두 소모
        if (idx == 10) {
            lion[10] += leftArrow; 
            int diff = calcDiff(apeach, lion);
            if (diff > 0 && diff >= maxDiff) {
                if (maxDiff < diff) {
                    maxDiff = diff;
                    answer = lion.clone();
                } else {
                    answer = moreLowScore(answer, lion).clone();
                }
            }
            lion[10] -= leftArrow; // 복구
            return;
        }
        
        for(int i = 0; i <= leftArrow; i++){            
            lion[idx] += i;
            bt(leftArrow - i, idx + 1, apeach, lion);
            lion[idx] -= i;            
        }        
    }
    
    public int calcDiff(int[] apeach, int[] lion){
        int apeachScore = 0;
        int lionScore = 0;
        for (int i = 0; i <= 10; i++) {
            if (apeach[i] == 0 && lion[i] == 0) continue; 
            if (apeach[i] >= lion[i]) {
                apeachScore += (10 - i);
            } else {
                lionScore += (10 - i);
            }
        }
        
        return lionScore - apeachScore;
    }
    
    public int[] moreLowScore(int[] answer, int[] lion){
        for(int i = 10; i >= 0; i--) {
            if (lion[i] > answer[i]) return lion;
            else if (lion[i] < answer[i]) return answer;
        }
        // 두 배열이 같은 경우
        return answer;
    }
}