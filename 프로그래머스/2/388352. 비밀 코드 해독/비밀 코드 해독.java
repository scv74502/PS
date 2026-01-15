import java.util.*;

class Solution {
    private int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        dfs(1, n, 0, new ArrayList<>(), q, ans);        
        return answer;
    }
    
    // 반복문의 시작하는 수, 비밀 코드의 최대 수, 현재 깊이, 비밀 코드 후보군의 수들, 질의 정보, 정답 정보
    public void dfs(int start, int n, int depth, ArrayList<Integer> curNumbers, int[][] q, int[] ans){
        if(depth == 5){
            checkAns(curNumbers, q, ans);
            return;
        }
        
        for(int i = start; i <= n; i++){
            curNumbers.add(i);
            dfs(i + 1, n, depth + 1, curNumbers, q, ans);
            curNumbers.remove(curNumbers.size() - 1);
        }
    }
    
    public void checkAns(ArrayList<Integer> curNumbers, int[][] q, int[] ans){
        HashSet<Integer> numbers = new HashSet<>(curNumbers);     
        // System.out.println(numbers);
        
        for(int i = 0; i < q.length; i++){
            int matchNumberAmount = 0;        
            for(int j = 0; j < 5; j++){
                
                if(numbers.contains(q[i][j])){
                    matchNumberAmount++;
                }
            }
            
            
            if(ans[i] != matchNumberAmount) return;
        }
        
        answer++;
    }
}