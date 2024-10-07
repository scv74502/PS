import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

// 맥주 마시며 걸어가기
public class Main {
    static int convAmount;
    static boolean[] visited;
    static Point[] convs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Point home, festvial, cur;
        String[] ipts;

        int tc = Integer.parseInt(br.readLine());
        int cx, cy;

        for(int rpt = 0; rpt < tc; rpt++){
            convAmount = Integer.parseInt(br.readLine());
            convs = new Point[convAmount];
            visited = new boolean[convAmount];

            ipts = br.readLine().split(" ");
            cx = Integer.parseInt(ipts[0]);
            cy = Integer.parseInt(ipts[1]);
            home = new Point(cx, cy);

            for(int i = 0; i < convAmount; i++){
                ipts = br.readLine().split(" ");
                cx = Integer.parseInt(ipts[0]);
                cy = Integer.parseInt(ipts[1]);
                convs[i] = new Point(cx, cy);
            }

            ipts = br.readLine().split(" ");
            cx = Integer.parseInt(ipts[0]);
            cy = Integer.parseInt(ipts[1]);
            festvial = new Point(cx, cy);

            solution(home, festvial);
        }
    }

    // 점 객체
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // static으로 출력함수 따로 빼둠
    static void solution(Point home, Point festvial){
        Point cur;
        Deque<Point> dq;
        dq = new LinkedList<>();
        dq.add(home);

        while(!dq.isEmpty()){
            cur = dq.poll();

            // 현재 시점에서 축제장까지 거리가 도달 가능하다면
            if(getManDistance(cur, festvial) <= 1000){
                System.out.println("happy");
                return;
            }

            for(int c = 0; c < convAmount; c++){
                if(getManDistance(cur, convs[c]) <= 1000 &&  !visited[c]){
                    visited[c] = true;
                    dq.add(convs[c]);
                }
            }
        }

        System.out.println("sad");
        return;
    }

    // 맨하탄 거리 구하는 함수
    static int getManDistance(Point p1, Point p2){
        return Math.max(p1.x, p2.x) - Math.min(p1.x, p2.x) + Math.max(p1.y, p2.y) - Math.min(p1.y, p2.y);
    }
}
