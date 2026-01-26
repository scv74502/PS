import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] upArr = new int[n];
        int[] downArr = new int[n];
        Stack<Integer> deletedRecord = new Stack<>();

        for(int i = 0; i < n; i++){
            upArr[i] = i - 1;
            downArr[i] = i + 1;
        }
        downArr[n - 1] = -1;

        for(String command : cmd){
            char c = command.charAt(0);

            if(c == 'U'){
                int x = Integer.parseInt(command.substring(2));
                while(x-- > 0){
                    k = upArr[k];
                }
            } else if(c == 'D'){
                int x = Integer.parseInt(command.substring(2));
                while(x-- > 0){
                    k = downArr[k];
                }
            } else if(c == 'C'){
                deletedRecord.push(k);
                
                if(upArr[k] != -1) downArr[upArr[k]] = downArr[k];
                if(downArr[k] != -1) upArr[downArr[k]] = upArr[k];

                if(downArr[k] != -1) k = downArr[k];
                else k = upArr[k];
            } else if(c == 'Z'){
                int node = deletedRecord.pop();
                
                if(upArr[node] != -1) downArr[upArr[node]] = node;
                if(downArr[node] != -1) upArr[downArr[node]] = node;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append("O");
        
        while(!deletedRecord.isEmpty()){
            sb.setCharAt(deletedRecord.pop(), 'X');
        }

        return sb.toString();
    }
}