class Solution {
    int maxDiff = 0;
    int[] answer;
    public int[] solution(int n, int[] info) {
        int[] lionRecord = new int[11];
        answer = new int[11];
        bt(n, 0, lionRecord, info);
        return maxDiff == 0 ? new int[] {-1} : answer;
    }
    
    public void bt(int leftArrow, int idx, int[] lionRecord, int[] apeachRecord){
        if (idx == 11) {
            lionRecord[10] += leftArrow;
            int diff = calcDiff(lionRecord, apeachRecord);
            if (diff > 0 && diff >= maxDiff) {
                if (diff > maxDiff || isBetter(lionRecord)) {
                    maxDiff = diff;
                    answer = lionRecord.clone();
                }
            }
            lionRecord[10] -= leftArrow;
            return;
        }
        
        int required = apeachRecord[idx] + 1;
        if (leftArrow >= required) {
            lionRecord[idx] = required;
            bt(leftArrow - required, idx + 1, lionRecord, apeachRecord);
            lionRecord[idx] = 0;
        }
        
        // 어피치가 0발이어도 라이언이 0발 쏘면 점수 못 얻으므로 로직상 안전함
        bt(leftArrow, idx + 1, lionRecord, apeachRecord);
    }
    
    // 낮은 점수 화살이 더 많은지 체크
    private boolean isBetter(int[] lionRecord) {
        for (int i = 10; i >= 0; i--) {
            if (lionRecord[i] > answer[i]) return true;
            if (lionRecord[i] < answer[i]) return false;
        }
        return false;
    }
    
    private int calcDiff(int[] lionRecord, int[] apeachRecord){
        int lion = 0;
        int apeach = 0;
        for(int i = 10; i >= 0; i--){
            if(lionRecord[i] == 0 && apeachRecord[i] == 0) continue;
            if(lionRecord[i] > apeachRecord[i]) lion += 10 - i;
            else apeach += 10 - i;            
        }
        return lion - apeach;
    }
}