import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int idx = 1;
        int answer = 0;
        for (int s : stations) {
            if (0 < s - w) {
                answer += Math.ceil((s - w - idx) / (double) (2 * w + 1));
            }
            idx = s + w + 1;
        }

        if(idx - 1 < n){
            answer += Math.ceil((n - (idx - 1)) / (double) (2 * w + 1));
        }

        return answer;
    }
}