import java.util.*;


class Solution {
    // 위, 아래, 오른쪽, 왼쪽
    public static int[] mx = {0, 0, 1, -1};
    public static int[] my = {1, -1, 0, 0};
    
    public static int move(char order){
        switch(order){
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'R':
                return 2;
            case 'L':
                return 3;
        }
        return -1;
    }
    
    public int solution(String dirs) {
// 초기 시작위치는 좌표평면으로 (0, 0)이고 맨 왼쪽-맨 아래를 (0,0)으로 하면 (5,5)가 됨
        int cur_x = 5;
        int cur_y = 5;
        int nx, ny;

        int answer = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // 방문여부는 "curX-curY-nextX-nextY"와, "nextX-nextY-curX-curY"로 문자열 만들어 집합에 저장
        Set<String> visited = new HashSet<>();

        for(char ch:dirs.toCharArray()){
            // 움직임
            nx = cur_x + mx[move(ch)];
            ny = cur_y + my[move(ch)];


            //System.out.println("nx : "+nx+", ny: "+ny);            

            // 범위 체크함
            if(nx < 0 || 11 <= nx || ny < 0 || 11 <= ny){
                continue;
            }

            sb1.append(cur_x);
            sb1.append(cur_y);
            sb1.append(nx);
            sb1.append(ny);

            sb2.append(nx);
            sb2.append(ny);
            sb2.append(cur_x);
            sb2.append(cur_y);

            // 위치 옮김 반영
            cur_x = nx;
            cur_y = ny;

            // 방문체크
            if(!visited.contains(sb1.toString())){
                //System.out.println("visited check -> cur_x : "+cur_x+", cur_y: "+cur_y);
                answer += 1;
                visited.add(sb1.toString());
                visited.add(sb2.toString());
            }
            sb1.setLength(0);
            sb2.setLength(0);
        }


        return answer;
    }
}