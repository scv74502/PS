import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        int[] giftResult = new int[N];  // 최종적으로 선물 받은 수 기록
        int[] giftIndex = new int[N];
        int[][] giftExchangeRecord = new int[N][N];
        
        // 친구의 번호 구하는 함수
        HashMap<String, Integer> getIndex = new HashMap<>();
        
        Arrays.fill(giftIndex, 0);
        for(int i = 0; i < N; i++){
            getIndex.put(friends[i], i);
            Arrays.fill(giftExchangeRecord[i], 0);
        }
        
        for(String record: gifts){
            String[] info = record.split(" ");
            int senderIdx = getIndex.get(info[0]);
            int receiverIdx = getIndex.get(info[1]);
            
            // 선물지수 반영
            giftIndex[senderIdx] += 1;
            giftIndex[receiverIdx] -= 1;
            
            // 서로 선물 보내준 횟수 반영
            giftExchangeRecord[senderIdx][receiverIdx] += 1;
        }
        
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(i == j) continue;
                
                // 서로 선물 주고받는 횟수
                if(giftExchangeRecord[i][j] > giftExchangeRecord[j][i]){
                    giftResult[i]++;
                } 
                
                else if(giftExchangeRecord[i][j] < giftExchangeRecord[j][i]){
                    giftResult[j]++;
                } 

                // 서로 선물 주고받은 횟수 같으면 선물지수 비교한다
                else if(giftExchangeRecord[i][j] == giftExchangeRecord[j][i]) { 
                    if(giftIndex[i] > giftIndex[j]) giftResult[i]++;
                    else if(giftIndex[i] < giftIndex[j]) giftResult[j]++;
                }
            }
        }
        
        int answer = -1;
        
        for(int i = 0; i < N; i++){
            answer = Math.max(answer, giftResult[i]);
        }
        
        // System.out.println(Arrays.deepToString(giftExchangeRecord));
        // System.out.println(Arrays.toString(giftIndex));
        // System.out.println(Arrays.toString(giftResult));
        
        return answer;
    }
}