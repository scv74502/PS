import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        long answer = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while(!stack.isEmpty() && stack.peek() <= height ){
                stack.pop();
            }

            answer += stack.size();
            stack.push(height);
        }

        System.out.println(answer);
    }
}
