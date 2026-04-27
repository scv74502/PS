class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = bisect(a, b, g, s, w, t);
        return answer;
    }
    
    public long bisect(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 500_000_000_000_000L;
        
        long answer = Long.MAX_VALUE;
        
        while(left < right){
            long mid = (left + right) / 2;            
            
            if(isAvailable(mid, a, b, g, s, w, t)) {                
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean isAvailable(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalCombined = 0;

        for (int i = 0; i < g.length; i++) {            
            long moveCount = time / (t[i] * 2L);
            
            // 마지막에 편도로 끝나는 경우
            if (time % (t[i] * 2L) >= t[i]) {
                moveCount++;
            }
            
            long maxPayload = moveCount * w[i];
            
            totalGold += Math.min(g[i], maxPayload);
            totalSilver += Math.min(s[i], maxPayload);
            totalCombined += Math.min(g[i] + s[i], maxPayload);
        }
        
        return totalGold >= a && totalSilver >= b && totalCombined >= (long)a + b;            
    }
}