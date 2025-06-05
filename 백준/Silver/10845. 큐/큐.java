import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] ipts = br.readLine().split(" ");

            if(ipts[0].equals("push")){
                int num = Integer.parseInt(ipts[1]);
                queue.offer(num);
            } else if(ipts[0].equals("pop")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(queue.pollFirst());
                }
            } else if(ipts[0].equals("size")){
                System.out.println(queue.size());
            } else if(ipts[0].equals("empty")){
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if(ipts[0].equals("front")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peekFirst());
                }
            } else if(ipts[0].equals("back")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peekLast());
                }
            } else { continue;}
        }

    }
}
