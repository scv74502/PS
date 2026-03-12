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
        if(idx == 11){
            lionRecord[10] += leftArrow;
            int diff = calcDiff(lionRecord, apeachRecord);
            
            if(diff > maxDiff){
                maxDiff = diff;
                answer = lionRecord.clone();                                    
                lionRecord[10] -= leftArrow;
                return;
            } else if(diff == maxDiff){
                // 낮은 점수가 많은 쪽
                for(int i = 10; i >= 0; i--){                    
                    if(lionRecord[i] == 0 && answer[i] == 0) continue;
                    else if(lionRecord[i] > answer[i]){
                        answer = lionRecord.clone();                
                        lionRecord[10] -= leftArrow;
                        return;
                    } else{
                        lionRecord[10] -= leftArrow;
                        return;
                    }
                }
            }
            
            lionRecord[10] -= leftArrow;
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
        for(int i = 10; i >= 0; i--){
            if(lionRecord[i] == 0 && apeachRecord[i] == 0) continue;
            if(lionRecord[i] > apeachRecord[i]) lion += 10 - i;
            else apeach += 10 - i;            
        }
        return lion - apeach;
    }
}