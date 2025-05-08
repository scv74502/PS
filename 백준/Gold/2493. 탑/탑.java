import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int newNum = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(newNum <= stack.peek()[0]){
                    sb.append(stack.peek()[1] + " ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append(0 + " ");
            }
            stack.push(new int[]{newNum, i});
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

