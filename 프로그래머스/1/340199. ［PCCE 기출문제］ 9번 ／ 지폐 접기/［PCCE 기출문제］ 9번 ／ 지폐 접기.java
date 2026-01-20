import java.util.*;

class Solution {
    private int answer;
    public int solution(int[] wallet, int[] bill) {
        answer = checkFoldTimes(wallet, bill);
        return answer;
    }
    
    public int checkFoldTimes(int[] wallet, int[] bill) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {bill[0], bill[1], 0});
        
        while(!queue.isEmpty()){
            int[] curBillStatus = queue.poll();
            if(isFit(wallet, curBillStatus)) {
                return curBillStatus[2];
            }
            
            if(curBillStatus[0] > curBillStatus[1] && curBillStatus[0] / 2 > 0) {
                queue.add(new int[] {curBillStatus[0] / 2, curBillStatus[1], curBillStatus[2] + 1});
            }
            else if(curBillStatus[1] / 2 > 0) {
                queue.add(new int[] {curBillStatus[0], curBillStatus[1] / 2, curBillStatus[2] + 1});
            }
        }
        
        return -1;
    }
    
    public boolean isFit(int[] wallet, int[] bill){
        if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) return true;
        else if (wallet[0] >= bill[1] && wallet[1] >= bill[0]) return true;
        else return false;
    }
}