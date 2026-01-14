import java.util.*;

class Solution {
    private int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        dfs(1, n, 0, new ArrayList<Integer>(), q, ans);
        return answer;
    }
    
    /**
        start: 수열 범위에서 시작 숫자
        n: 수열 범위에서 마지막 숫자(문제에서 입력받음)
        count: 현재 체크하는 배열의 숫자
        numbers: 현재 배열
        q: q[i]는 i번째 시도, q[i][j]는 i번째 시도에서 j번째 숫자
        ans: ans[i]는 i번째 시도에서 비밀 코드와 일치한 숫자
    **/
    private void dfs(int start, int n, int count, ArrayList<Integer> numbers, int[][] q, int[] ans){
        // 5개의 수가 되면 답 체크하고 종료하기
        if(count == 5){
            checkAnswer(numbers, q, ans);
            return;
        }
        
        for(int i = start; i <= n; i++){
            numbers.add(i);
            dfs(i + 1, n, count + 1, numbers, q, ans);
            numbers.remove(numbers.size() - 1);
        }
    }
    
    private void checkAnswer(ArrayList<Integer> numbers, int[][] q, int[] ans){
        HashSet<Integer> set = new HashSet<>(numbers);
        
        for(int i = 0; i < q.length; i++){
            int[] code = q[i];
            int matching = 0;
            
            for(int number: code){
                if(set.contains(number)) matching++;
            }
            
            if(matching != ans[i]) return;
        }
        
        answer++;
    }
}