import java.util.*;

class User{
    String uid;
    String nickName;
    
    public User(String uid, String nickName){
        this.uid = uid;
        this.nickName = nickName;
    }
}

class Solution {
    public String[] solution(String[] record) {
        String[] ipt;
        String category = ""; 
        String uid = "";
        String nickName = "";
        Map<String, String> hm = new HashMap<>();
        List<String[]> messages = new ArrayList<>();
        
        for(String rec:record){
            ipt = rec.split(" ");
            //System.out.println(Arrays.toString(ipt));
            
            if(!ipt[0].equals("Leave")){
                category = ipt[0];
                uid = ipt[1];
                nickName = ipt[2];
            } else {             
                category = ipt[0];
                uid = ipt[1];
            }
        
            
            if(category.equals("Enter")){                
                hm.put(uid, nickName);
                messages.add(new String[] {uid, "님이 들어왔습니다."});
            } else if(category.equals("Change")){
                hm.put(uid, nickName);
            } else if(category.equals("Leave")){
                messages.add(new String[] {uid, "님이 나갔습니다."});
            }
        }
        
        String[] answer = new String[messages.size()];
        //System.out.println(hm);
        
        for(int i = 0; i < messages.size(); i++){
            //System.out.println(Arrays.toString(messages.get(i)));
            ipt = messages.get(i);
            answer[i] = hm.get(ipt[0]) + ipt[1];
        }
        
        
        return answer;
    }
}