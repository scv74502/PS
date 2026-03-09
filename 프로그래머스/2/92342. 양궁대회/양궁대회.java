import java.util.*;

class Solution {
    int maxDiff = -1;
    int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        int[] lionRecord = new int[11];
        bt(n, 0, lionRecord, info);
        if(maxDiff == -1) return new int[] {-1};        
        return answer;
    }
    
    // 남은 화살, 몇점 계산 중인지 체크하는 idx, 라이온의 기록, 어피치의 기록
    public void bt(int leftArrow, int idx, int[] lionRecord, int[] info){
        if(idx == 10){
            lionRecord[10] += leftArrow;    // 낮은 점수를 최대한 쏘는 쪽이 유리하므로 0점에 남은 화살 몰아주기
            int curDiff = getDiff(lionRecord, info);                                                            
            
            if(curDiff <= 0){
                lionRecord[10] -= leftArrow;
                return;
            }                        
            
            if(curDiff > maxDiff){                
                maxDiff = curDiff;
                answer = lionRecord.clone();
            } else if (curDiff == maxDiff){
                for(int i = 10; i >= 0; i--){
                    if(answer[i] > lionRecord[i]){
                        break;
                    } else if(answer[i] < lionRecord[i]){
                        answer = lionRecord.clone();
                        break;
                    }
                }
            }
            
            lionRecord[10] -= leftArrow;
            return;
        }
        
        for(int j = 0; j <= leftArrow; j++){
            lionRecord[idx] += j;            
            bt(leftArrow - j, idx + 1, lionRecord, info);
            lionRecord[idx] -= j;
        }                                
    }
    
    public int getDiff(int[] lionRecord, int[] info){
        int lionScore = 0;
        int apeachScore = 0;
        
        for(int i = 0; i <= 10; i++){
            if(lionRecord[i] == 0 && info[i] == 0) continue;
            if(lionRecord[i] > info[i]){
                lionScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }
        return lionScore - apeachScore;
    }
}