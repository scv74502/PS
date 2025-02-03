class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer ;
        String[] ipts = video_len.split(":");
        int videoMinute = Integer.parseInt(ipts[0]);
        int videoSecond = Integer.parseInt(ipts[1]);
        videoSecond += videoMinute * 60;
        
        ipts = pos.split(":");
        int posSecond = Integer.parseInt(ipts[0]) * 60 + Integer.parseInt(ipts[1]);
        
        ipts = op_start.split(":");
        int opStartSecond = Integer.parseInt(ipts[0]) * 60 + Integer.parseInt(ipts[1]);
        
        ipts = op_end.split(":");
        int opEndSecond = Integer.parseInt(ipts[0]) * 60 + Integer.parseInt(ipts[1]);
        
        for(String command:commands){
            if(command.equals("next")){
                if(opStartSecond <= posSecond && posSecond < opEndSecond){
                    posSecond = opEndSecond;
                    posSecond += 10;
                } else if(videoSecond < posSecond + 10){
                    posSecond = videoSecond;
                } else{
                    posSecond += 10;
                }
            } else if(command.equals("prev")){
                if(posSecond - 10 < 0){
                    posSecond = 0;
                } else{
                    posSecond -= 10;
                }
            }
            
            if(opStartSecond <= posSecond && posSecond < opEndSecond){
                    posSecond = opEndSecond;
            }
             // System.out.println((posSecond / 60) + ":" + (posSecond % 60));
        }
        
        StringBuilder sb = new StringBuilder();
        if((posSecond / 60) < 10) sb.append("0").append(posSecond / 60);
        else sb.append(posSecond / 60);
        sb.append(":");
        if((posSecond % 60) < 10) sb.append("0").append((posSecond % 60));
        else sb.append((posSecond % 60));
        answer = sb.toString();
        
        return answer;
    }
};