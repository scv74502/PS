class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int newR = arr1.length;
        int newC = arr2[0].length;
        int[][] answer = new int[newR][newC];
        
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                for(int k = 0; k < arr2.length; k++){
                    // System.out.println("i : " + i + ", j : " + j + ", k : " + k);
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }                
            }
        }
        return answer;
    }
}

// 1 4     3 3     15 15
// 3 2     3 3     15 15               
// 4 1             15 15
// 3*2     2*2      3*2    

// arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0], arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]
// arr1[i][j] * arr2[i][j] + arr1[i][k] * arr2[k][j], arr1[i][j] * arr2[i][j] + arr1[i][k] * arr2[k][j]