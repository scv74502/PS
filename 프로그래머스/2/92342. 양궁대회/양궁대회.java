import java.util.*;

class Solution {
    int maxDiff = 0;
    int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
        int[] lionRecord = new int[11];
        bt(n, 0, lionRecord, info);
        // System.out.println(Arrays.toString(answer));
        return maxDiff == 0 ? new int[] {-1} : answer;
    }
    
    public void bt(int leftArrow, int idx, int[] lionRecord, int[] apeachRecord){
        if(idx == 11){
            lionRecord[10] += leftArrow;
            int curDiff = calcDiff(lionRecord, apeachRecord);
            
            if(maxDiff < curDiff){
                answer = lionRecord.clone();
                maxDiff = curDiff;                
            } else if(maxDiff == curDiff){
                for(int i = 10; i >= 0; i--){
                    if(lionRecord[i] > answer[i]){
                        answer = lionRecord.clone();
                        lionRecord[10] -= leftArrow;
                        return;
                    } else if(lionRecord[i] < answer[i]) {
                        break;
                    } else{
                        continue;
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
        int answer = 0;
        for(int i = 10; i >= 0; i--){
            if(lionRecord[i] == 0 && apeachRecord[i] == 0){
                continue;
            } else if(lionRecord[i] > apeachRecord[i]){
                answer += (10 - i);
            } else{
                answer -= (10 - i);
            }
        }
        return answer;
    }
}