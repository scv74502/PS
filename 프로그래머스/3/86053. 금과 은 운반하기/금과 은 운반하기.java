class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = bisect(a, b, g, s, w, t);
        return answer;
    }
    
    public long bisect(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 50000000000000000L;        
        long answer = right;
        
        while(left <= right) {            
            long mid = (left + right) / 2;
            if(isPossible(mid, a, b, g, s, w, t)) {
                right = mid - 1;
                answer = right;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalMix = 0;                
        
        for(int i = 0; i < g.length; i++) {
            long moveCnt = time / (t[i] * 2);
            if(time % (t[i] * 2) > t[i]) moveCnt++;
            
            long maxPayload = moveCnt * w[i];
            
            totalGold += Math.min(maxPayload, g[i]);
            totalSilver += Math.min(maxPayload, s[i]);
            totalMix += Math.min(maxPayload, g[i] + s[i]);
        }
        
        return (totalGold >= a && totalSilver >= b && totalMix >= ((long)a + b));                
    }
}