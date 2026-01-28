import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String ENTER_MESSAGE = "님이 들어왔습니다.";
        String LEAVE_MESSAGE = "님이 나갔습니다.";
        
        HashMap<String, String> uidNicknameMap = new HashMap<>();
        List<String[]> finalMessage = new ArrayList<>();
        
        for(String rec: record){
            String[] ipt = rec.split(" ");
            String command = ipt[0];
            String uid = ipt[1];
            if(command.equals("Enter")){
                String nickname = ipt[2];                
                uidNicknameMap.put(uid, nickname);
                finalMessage.add(new String[] {"Enter", uid});
            } else if(command.equals("Change")){
                String nickname = ipt[2];                
                uidNicknameMap.put(uid, nickname);
            } else {
                finalMessage.add(new String[] {"Leave", uid});
            }
        }
        
        
        String[] answer = new String[finalMessage.size()];
        
        for(int i = 0; i < answer.length; i++){
            String uid = finalMessage.get(i)[1];
            if(finalMessage.get(i)[0].equals("Enter")){
                answer[i] = uidNicknameMap.get(uid) + ENTER_MESSAGE;
            } else {
                answer[i] = uidNicknameMap.get(uid) + LEAVE_MESSAGE;
            }
            
        }
        return answer;
    }
}