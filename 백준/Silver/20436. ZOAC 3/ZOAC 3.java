import java.io.*;
import java.util.HashMap;

public class Main {
    static char[][] keyboard = new char[3][10];
    static HashMap<Character, int[]> location;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        keyboard[0] = new char[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        keyboard[1] = new char[] {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ' '};
        keyboard[2] = new char[] {'z', 'x', 'c', 'v', 'b', 'n', 'm', ' ', ' ', ' '};

        location = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 10; j++) {
                if(keyboard[i][j] != ' ') {
                    location.put(keyboard[i][j], new int[] {i, j});
                }
            }
        }

        // 양손 검지 손가락
        ipts = br.readLine().split(" ");
        char left = ipts[0].charAt(0);
        char right = ipts[1].charAt(0);
        int answer = 0;

        String target = br.readLine();
        for(char ch:target.toCharArray()) {
            // 왼쪽 손과 오른쪽 손은 움직이는 범위가 나누어져 있으며 겹치지 않는다
            // qwerty 기준 t까지는 왼손이, 그 우측은 오른손이 담당
            if(location.get(ch)[0] < 2){
                if(location.get(ch)[1] < 5){
                    answer += getDistance(left, ch);
                    left = ch;
                } else{
                    answer += getDistance(right, ch);
                    right = ch;
                }
            } else{
                if(location.get(ch)[1] < 4){
                    answer += getDistance(left, ch);
                    left = ch;
                } else{
                    answer += getDistance(right, ch);
                    right = ch;
                }
            }

            // 누르는 시간 1 반영
            answer++;
        }

        System.out.println(answer);
    }

    public static int getDistance(char curKey, char tgtKey) {
        int[] curLoc = location.get(curKey);
        int[] tgtLoc = location.get(tgtKey);

        return Math.abs(curLoc[0] - tgtLoc[0]) + Math.abs(curLoc[1] - tgtLoc[1]);
    }
}
