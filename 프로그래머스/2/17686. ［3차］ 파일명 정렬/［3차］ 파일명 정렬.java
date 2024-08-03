import java.util.*;

class Solution {
    public String[] seperate(String file){
        file = file.toLowerCase();
        String head = file.split("[0-9]")[0];
        String number = file.substring(head.length());
        String[] result = {head, number};
        return result;
    }
    
    public String getNumber(String number){
        StringBuilder sb = new StringBuilder();
        for(char ch: number.toCharArray()){
            if(Character.isDigit(ch) && sb.length() <= 5){
                sb.append(ch);
            } else{
                return sb.toString();
            }
        }
        return sb.toString();
    }
    
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                // 파일명 분리
                String[] file1 = seperate(o1);
                String[] file2 = seperate(o2);
                
                int headResult = file1[0].compareTo(file2[0]);
                
                // head 비교가 같으면 숫자로 비교
                if(headResult == 0){
                    int num1 = Integer.parseInt(getNumber(file1[1]));
                    int num2 = Integer.parseInt(getNumber(file2[1]));
                    return num1 - num2;
                }
                
                return headResult;
            }
        });
        
        //String[] answer = {};
        return files;
    }
}