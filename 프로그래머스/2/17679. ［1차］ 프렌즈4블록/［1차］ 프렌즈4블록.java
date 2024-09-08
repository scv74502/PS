import java.util.*;

class Solution {
    List<List<Character>> b = new ArrayList<>();
    public int solution(int m, int n, String[] board) {
        for(int i = 0; i < n; i++){
            b.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = m-1; j >= 0; j--){
                b.get(i).add(board[j].charAt(i));
            }
        }
        
        int answer = 0;
        
        while(true){
            int cnt = 0;            
            for(int i = 0; i < n-1; i++){
                for(int j = b.get(i).size() - 1; j > 0; j--){
                    check(i, j);
                }
            }
            
            for(int i = 0; i < n; i++){
                for(int j = b.get(i).size() - 1; j >= 0; j--){
                    if(Character.isLowerCase(b.get(i).get(j))){
                        b.get(i).remove(j);
                        cnt++;
                    }
                }
            }
            
            if(cnt == 0){ break; }
            answer += cnt;
        }
        
        return answer;
    }
    
    public void check(int i, int j){
        // 해당 열의 길이가 2 미만, 다음 열의 크기가 j(세로 길이) 이하
        if(b.get(i).size() <= 1 || j >= b.get(i+1).size()){
            return;
        }
        
        char upperCh = Character.toUpperCase(b.get(i).get(j));
        char lowerCh = Character.toLowerCase(b.get(i).get(j));
        
        // 주변 4칸을 탐색함
        if((b.get(i).get(j-1) == upperCh || b.get(i).get(j-1) == lowerCh)
          && (b.get(i+1).get(j) == upperCh || b.get(i+1).get(j) == lowerCh)
          && (b.get(i+1).get(j-1) == upperCh || b.get(i+1).get(j-1) == lowerCh)){
            b.get(i).set(j, lowerCh);
            b.get(i+1).set(j, lowerCh);
            b.get(i).set(j-1, lowerCh);
            b.get(i+1).set(j-1, lowerCh);
        }
    }
}