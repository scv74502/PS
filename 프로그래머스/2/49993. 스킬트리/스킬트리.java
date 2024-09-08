import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        TreeSet<Character> tm = new TreeSet<>();
        for(char ch:skill.toCharArray()){
            tm.add(ch);
        }
        
        String cur;
        int strSize;
        
        for(String skill_tree:skill_trees){
            for(char ch: skill_tree.toCharArray()){
                if(tm.contains(ch)){
                    sb.append(ch);
                }
            }
            cur = sb.toString();
            strSize = cur.length();
            
            if(cur.equals(skill.substring(0, strSize))){
                answer++;
            }
            sb.setLength(0);
        }
        return answer;
    }
} 