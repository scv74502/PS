import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> stack = new ArrayDeque<>();

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int curNum = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[0] < curNum){
                int num = stack.peek()[0];
                int idx = stack.peek()[1];
                stack.poll();

                answer[idx] = curNum;
            }

            stack.push(new int[]{curNum,i});
        }

        while(!stack.isEmpty()){
            int num = stack.peek()[0];
            int idx = stack.peek()[1];
            stack.poll();

            answer[idx] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]);
            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
