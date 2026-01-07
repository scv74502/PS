import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        
        // w열이므로 w개의 stack 추가
        Stack<Integer>[] cols = new Stack[w];
        for(int i = 0; i < w; i++){
            cols[i] = new Stack<>();
        }
        
        int targetCol = 0;  // 원하는 상자가 있는 열 번호
        boolean isRight = true;   // 현재 상자 쌓는 방향이 왼쪽->오른쪽 방향인지
        
        for(int i = 0; i < n; i++){
            // 현재 행이 짝수 행이면 오른쪽, 홀수 행이면 왼쪽 방향
            int row = i / w;
            if (row % 2 == 1){
                isRight = true;
            } else {
                isRight = false;
            }
            
            
            
            if(isRight){
                cols[i % w].push(i + 1);
                // 현재 수가 찾는 수인 num이면 열 마킹
                if(i + 1 == num){
                    targetCol = i % w;
                }                
            } else {
                cols[w - 1 - i % w].push(i + 1);
                // 현재 수가 찾는 수인 num이면 열 마킹
                if(i + 1 == num){
                    targetCol = w - 1 - i % w;
                }                
            }
        }
        
        // System.out.println(cols[targetCol]);
        
        while (cols[targetCol].peek() != num){
            cols[targetCol].pop();
            answer++;
        }        
        
        return answer;
    }
}