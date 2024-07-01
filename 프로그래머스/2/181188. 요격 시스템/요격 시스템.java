import java.util.*;
import java.lang.Math;


class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1]==o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int ce = 0;
        // System.out.println(Arrays.deepToString(targets));
        for(int[] tgt:targets){
            if(ce <= tgt[0]){
                answer += 1;
                ce = tgt[1];
            }
        }
        
        return answer;
    }
}