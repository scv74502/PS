import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();

        // i번째 수라는 뜻
        for (int i = 1; i <= N; i++) {
            int newNumber = Integer.parseInt(stringTokenizer.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek()[0] >= newNumber){    // 레이저 발사하여 닿는 범위라면
                    // 현 탑에서 레이저 쏘면 닿음, 해당 탑 정보 출력
                    sb.append(stack.peek()[1]);
                    sb.append(" ");
                    break;
                }
                stack.pop();
            }

            // 스택이 비었으면 현 탑보다 높아서 레이저 닿는 곳이 없으므로 0 출력
            if(stack.isEmpty()){
                sb.append("0");
                sb.append(" ");
            }

            stack.push(new int[] {newNumber, i});
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

