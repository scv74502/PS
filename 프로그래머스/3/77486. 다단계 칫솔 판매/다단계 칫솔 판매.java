import java.util.*;

class Solution {    
    // 가입자 - 추천인 관계 저장한 맵
    HashMap<String, String> referralMap = new HashMap<>();
    
    // 조직원 - 이익 관계 저장한 맵
    HashMap<String, Integer> memberSalesMap = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i = 0; i < enroll.length; i++){
            referralMap.put(enroll[i], referral[i]);
            memberSalesMap.put(enroll[i], 0);
        }                
        
       for(int i = 0; i < seller.length; i++){
            String curSeller = seller[i];
            int totalSales = amount[i] * 100;
            
            while (!curSeller.equals("-") && totalSales > 0) {
                int fee = totalSales / 10;
                int memberProfit = totalSales - fee;
                
                memberSalesMap.put(curSeller, memberSalesMap.get(curSeller) + memberProfit);
                
                totalSales = fee;
                curSeller = referralMap.get(curSeller);
                
                if (totalSales < 1) break;
            }
        }

        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = memberSalesMap.get(enroll[i]);
        }
        
        return answer;
    }
    
    // 수수료 제공 함수
    public int calcFee(int sales){
        // 수수류가 1원 미만이면 상납 안함
        if(sales < 10) return 0;
        
        int result = (int)Math.ceil((float)sales * 0.1);        
        return result;
    }
}