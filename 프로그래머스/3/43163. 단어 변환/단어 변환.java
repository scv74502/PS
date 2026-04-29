class Solution {
    private int minDepth = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {        
        minDepth = Integer.MAX_VALUE;
        boolean[] visited = new boolean[words.length];        
        bt(begin, target, words, visited, 0);        
        return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
    }
    
    private void bt(String current, String target, String[] words, boolean[] visited, int depth) {
        // 가지치기, 현재 깊이가 이미 최솟값보다 크면 중단
        if (depth >= minDepth) return;
        
        if (current.equals(target)) {
            minDepth = depth;
            return;
        }        
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isPossible(current, words[i])) {
                visited[i] = true;
                bt(words[i], target, words, visited, depth + 1);
                visited[i] = false;
            } 
        }
    }    
    
    private boolean isPossible(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}