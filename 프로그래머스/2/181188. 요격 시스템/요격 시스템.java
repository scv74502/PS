import java.util.*;


class Solution {
    public int solution(int[][] targets) {
        // targets의 끝나는 e에 따라서 오름차순 정렬
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override 
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int answer = 0;
        // 이차원 어레이를 출력하는 코드
        // System.out.println(Arrays.deepToString(targets));
        int ce = 0;
        
        for(int[] info:targets){
            if(info[0] >= ce){
                answer += 1;
                ce = info[1];
            }
        }
        return answer;
    }
    
    
}