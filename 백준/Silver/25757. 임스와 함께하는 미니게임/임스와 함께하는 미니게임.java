import java.io.*;
import java.util.*;

public class Main {
    static HashSet<String> playedMember = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;
        int answer = 0;

        ipts = br.readLine().split(" ");
        int requestTimes = Integer.parseInt(ipts[0]);
        int requiredMembers;

        // 게임별 인원 수 정하기
        if(ipts[1].equals("Y")){
            requiredMembers = 2;
        } else if(ipts[1].equals("F")){
            requiredMembers = 3;
        } else{
            requiredMembers = 4;
        }

        // 현재 게임에 참가한 사람 수
        int currentMembers = 1;

        for(int r = 0; r < requestTimes; r++){
            ipt = br.readLine().strip();

            // 게임 했던 멤버 목록에 멤버가 없으면 게임에 끼워줌
            if(!playedMember.contains(ipt)){
                playedMember.add(ipt);
                currentMembers++;
                // 현재 게임 멤버들 수가 게임에 필요한 멤버들이 되면
                if(currentMembers == requiredMembers){
                    answer++;
                    currentMembers = 1;
                }
            }
        }
        System.out.println(answer);
    }
}