import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        int A = Integer.parseInt(ipts[0]);
        int B = Integer.parseInt(ipts[1]);

        Deque<long[]> queue = new LinkedList<>();
        // 현재수, 연산횟수
        queue.add(new long[]{A, 1});
        int answer = Integer.MAX_VALUE;
        int depth;
        long num, multiply, addRightOne;

        while(!queue.isEmpty()) {
            num = queue.peek()[0];
            depth = (int) queue.peek()[1];
            queue.pollFirst();

            if(num == B){
                answer = depth;
                break;
            }

            multiply = num * 2;
            addRightOne = num * 10 + 1;

            if(multiply <= B){
                queue.addLast(new long[]{multiply, depth + 1});
            }

            if(addRightOne <= B){
                queue.addLast(new long[]{addRightOne, depth + 1});
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
}
