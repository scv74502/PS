import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        int rows = park.length;
        int cols = park[0].length;
        
        for (int k = mats.length - 1; k >= 0; k--) {
            int size = mats[k];
            
            for (int i = 0; i <= rows - size; i++) {
                for (int j = 0; j <= cols - size; j++) {
                    
                    if (canPlaceMat(park, i, j, size)) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean canPlaceMat(String[][] park, int r, int c, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!park[r + i][c + j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}