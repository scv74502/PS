class Solution {
    static boolean[] visited;
    static int MAX_TURN = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(begin)){
                visited[i] = true;
                break;
            }
        }
        bt(begin, target, words, 0);
        return MAX_TURN == Integer.MAX_VALUE ? 0 : MAX_TURN;
    }
    
    public void bt(String current, String target, String[] words, int depth) {
        if(current.equals(target) || depth == words.length){
            if(depth < words.length) MAX_TURN = Math.min(MAX_TURN, depth);
            return;
        }        
        
        for(int i = 0; i < words.length; i++){
            String next = words[i];
            if(!visited[i] && isPossible(current, next)){
                visited[i] = true;
                bt(next, target, words, depth + 1);
                visited[i] = false;
            } 
        }
    }    
    
    public boolean isPossible(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
                if(diff > 1) return false;
            }            
        }
        return true;
    }
}