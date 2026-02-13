import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> uniqueMons = new HashSet<>();
        for(int num: nums){
            uniqueMons.add(num);
        }
            
        return Math.min(uniqueMons.size(), nums.length / 2);
    }
}