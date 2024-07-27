import java.util.*;
// A -> 65, Z -> 90

class Solution {
    public List<String> toStringList(String original){
        List<String> str = new ArrayList<String>();
        boolean isAppend = true;
        for(int i = 0; i < original.length()-1; i++){
            //System.out.println(original.substring(i, i+2));
            isAppend = true;
            for(char ch:original.substring(i, i+2).toUpperCase().toCharArray()){
                if(ch < 65 || 90 < ch){
                    // System.out.println(ch);
                    isAppend = false;
                    break;
                }  
            }
            if(isAppend){
                //System.out.println("add : " + original.substring(i, i+2).toUpperCase());
                str.add(original.substring(i, i+2).toUpperCase());
            }
        }
        //return str.toArray(new String[str.size()]);
        return str;
    }
    
    public double findJs(List<String> sl1, List<String> sl2){
        double answer = 0;
        int inter = 0;  // interSection
        int union = 0;    // Union
        
        List<String> diffSet = new ArrayList<>(sl1);    // sl1과 sl2의 교집합이 없는 sl1
        for(String s: sl2){ diffSet.remove(s); }
        
        inter = sl1.size() - diffSet.size();
        union = sl2.size() + diffSet.size();
        return union == 0 ? 65536 : 65536 * inter / union;
    }
    
    public int solution(String str1, String str2) {

        List<String> strList_1 = toStringList(str1);
        List<String> strList_2 = toStringList(str2);
        
        System.out.println(strList_1);
        System.out.println(strList_2);
        
        
        return (int)findJs(strList_1, strList_2);

    }
}