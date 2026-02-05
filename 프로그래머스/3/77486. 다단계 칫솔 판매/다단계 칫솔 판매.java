import java.util.*;

class Solution {
    HashMap<String, String> memberReferenceMap = new HashMap<>();
    HashMap<String, Integer> memberSalesMap = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i = 0; i < enroll.length; i++){
            memberReferenceMap.put(enroll[i], referral[i]);
            memberSalesMap.put(enroll[i], 0);
        }
        
        for(int i = 0; i < seller.length; i++){
            String curSeller = seller[i];
            int curSales = amount[i] * 100;

            // 추천인이 없고 매출도 없으면 종료
            while(!curSeller.equals("-") && curSales > 0){
                String curReference = memberReferenceMap.get(curSeller);
                int curFee = curSales / 10;
                
                // 수수료가 0원이면 트리 상향 중단
                if(curFee == 0){
                    memberSalesMap.put(curSeller, memberSalesMap.get(curSeller) + curSales);
                    break;
                }
                    
                // 수수료가 있으므로 차감 후 판매액 지급
                memberSalesMap.put(curSeller, memberSalesMap.get(curSeller) + curSales - curFee);                                                   
                                
                curSeller = curReference;
                curSales = curFee;                
            }                                    
        }
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++){                
            answer[i] = memberSalesMap.get(enroll[i]);
        }            
        
        return answer;
    }
    
    public int getFee(int sales){
        return sales / 10;
    }
}
