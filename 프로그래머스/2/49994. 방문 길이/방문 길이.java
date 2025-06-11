import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public int solution(String dirs) {
        int cr = 5;
        int cc = 5;
        int answer = 0;

        int nr, nc;
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(char ch:dirs.toCharArray()){
            int dir = getDirection(ch);
            nr = cr + dr[dir];
            nc = cc + dc[dir];

            if(nr < 0 || 10 < nr || nc < 0 ||10 < nc) continue;

            sb.append(cr);
            sb.append(cc);
            sb.append(nr);
            sb.append(nc);

            String path = sb.toString();
            sb.setLength(0);

            sb.append(nr);
            sb.append(nc);
            sb.append(cr);
            sb.append(cc);

            String reversedPath = sb.toString();
            sb.setLength(0);

            if(!visited.contains(path)){
                answer++;
                visited.add(path);
                visited.add(reversedPath);
            }

            cr = nr;
            cc = nc;
        }


        return answer;
    }

    public static int getDirection(char ch){
        switch(ch){
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
        }

        return -1;
    }
}