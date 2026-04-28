class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = bisect(a, b, g, s, w, t);
        return answer;
    }
    
    public long bisect(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        final long MAX_RANGE = 1000000000000000L;
        long left = 0;
        long right = MAX_RANGE;
        long result = MAX_RANGE;
        
        while(left < right){
            long mid = (left + right) / 2;
            if(isAvailable(mid, a, b, g, s, w, t)){
                result = mid;
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    public boolean isAvailable(long time, int a, int b, int[] g, int[] s, int[] w, int[] t){
        // 각 마을에서 가져오는 은 총합, 금 총합, 혼합 총합
        long totalSilver = 0;
        long totalGold = 0;
        long totalCombine = 0;        
                    
        for(int i = 0; i < g.length; i++){
            // 시간 내 전달(왕복) 가능한 횟수 구하기
            long moveCnt = time / (t[i] * 2);
            if(time % (t[i] * 2) >= t[i]) moveCnt++;
            
            long maxPayLoad = moveCnt * w[i];
            
            totalSilver += Math.min(maxPayLoad, s[i]);
            totalGold += Math.min(maxPayLoad, g[i]);
            totalCombine += Math.min(maxPayLoad, s[i] + g[i]);
        }                
        
        if(totalGold >= a && totalSilver >= b && totalCombine >= (a + b)) return true;
        return false;
    }
}