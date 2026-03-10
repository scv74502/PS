class Solution {
    final int ARROW_AMOUNT = 10;
    int maxDiff = 0;
    int[] answer = new int[ARROW_AMOUNT + 1];
    public int[] solution(int n, int[] info) {        
        int[] lionRecord = new int[ARROW_AMOUNT + 1];
        bt(n, 0, lionRecord, info);
        if(maxDiff == 0) return new int[] {-1};    
        return answer;
    }
    
    public void bt(int leftArrow, int idx, int[] lionRecord, int[] apeachRecord){
        if(idx == ARROW_AMOUNT + 1){
            lionRecord[ARROW_AMOUNT] += leftArrow;
            int curDiff = calcDiff(lionRecord, apeachRecord);
            
            if(curDiff > maxDiff){
                maxDiff = curDiff;
                answer = lionRecord.clone();
            } else if(curDiff == maxDiff){
                // 점수차 같다면 낮은 점수 많이 맞춘 기록으로 대체
                for(int i = ARROW_AMOUNT; i >= 0; i--){
                    if(lionRecord[i] > answer[i]){
                        answer = lionRecord.clone();
                        break;
                    } else if(lionRecord[i] < answer[i]){
                        lionRecord[ARROW_AMOUNT] -= leftArrow;
                        return;
                    }
                }
            }
            
            lionRecord[ARROW_AMOUNT] -= leftArrow;
            return;
        }
        
        for(int i = 0; i <= leftArrow; i++){
            lionRecord[idx] += i;
            bt(leftArrow - i, idx + 1, lionRecord, apeachRecord);
            lionRecord[idx] -= i;
        }
    }
    
    public int calcDiff(int[] lionRecord, int[] apeachRecord){
        int lion = 0;
        int apeach = 0;
        for(int i = ARROW_AMOUNT; i >= 0; i--){
            if(lionRecord[i] == 0 && apeachRecord[i] == 0) continue;
            else if(lionRecord[i] > apeachRecord[i]){
                lion += (ARROW_AMOUNT - i);
            } else {
                apeach += (ARROW_AMOUNT - i);
            }
        }
        return lion - apeach;
    }
}