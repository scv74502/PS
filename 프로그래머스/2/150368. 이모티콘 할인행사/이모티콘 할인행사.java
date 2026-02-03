class Solution {
    int bestJoined = 0;
    int bestSales = 0;
    int[] discountRate = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        findBest(0, users, emoticons, new int[emoticons.length]);
        int[] answer = {bestJoined, bestSales};
        return answer;
    }
    
    public void findBest(int curIdx, int[][] users, int[] emoticons, int[] discountPerEmoticon){
        if(curIdx == emoticons.length){
            calculate(curIdx, users, emoticons, discountPerEmoticon);
            return;
        }                        
                
        for(int i = 0; i < 4; i++){
            // 현재 curIdx번 이모티콘의 할인율 변경
            discountPerEmoticon[curIdx] = discountRate[i];
            findBest(curIdx+1, users, emoticons, discountPerEmoticon);
        }
    }
    
    public void calculate(int curIdx, int[][] users, int[] emoticons, int[] discountPerEmoticon){
        int totalJoined = 0;
        int totalSales = 0;
        
        for(int[] user:users){
            int buyRate = user[0];
            int buyLimit = user[1];
            
            int curSales = 0;
            
            for(int i = 0; i < emoticons.length; i++){
                // 원하는 할인비율보다 낮으면 사지 않음
                if(discountPerEmoticon[i] >= buyRate) {
                    curSales += (emoticons[i] * (100 - discountPerEmoticon[i]) / 100);
                }
            }
            
            // 현재 구매액이 가입기준액 이상이면 가입
            if(curSales >= buyLimit) totalJoined++;
            else totalSales += curSales;
        }
        
        if(totalJoined > bestJoined){ 
            bestJoined = totalJoined;
            bestSales = totalSales; // Joined가 바뀌면 Sales도 바뀌어야 함
        }
        else if (totalJoined == bestJoined) bestSales = Math.max(bestSales, totalSales);
        
        return;
    }
}