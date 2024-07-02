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
            // 현재 위치에서 새 미사일의 요격범위 밖이라면(양 끝 지점에서 요격 불가함)
            if(ce <= info[0]){
                // 새 미사일을 소비하고, 위치를 현 미사일 범위의 맨 끝으로 옮김(실제로는 끝에서 아주 약간 전의 실수이나, 정수로 표현하기 위해)
                ce = info[1];
                answer += 1;
            }
        }
        return answer;
    }
    
    
}