import java.util.*;


class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        boolean answer = true;
        for(String pn:phone_book){
            hm.put(pn, 1);
        }
        
        for(String pn:phone_book){
            //System.out.println("pn : " + pn);
            String temp = "";
            for(int p = 0; p < pn.length(); p++){
                //System.out.println("temp : " + temp);
                //System.out.println("ss : " + pn.substring(p, p+1));
                temp += pn.substring(p, p+1);
                if(hm.containsKey(temp) && !temp.equals(pn)){
                    //System.out.println("return temp : " + temp);
                    return false;
                }
            }
        }
        return answer;
    }
}