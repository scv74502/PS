import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        Stack<Character> buffer = new Stack<>();

        for (int tc = 0; tc < testCase; tc++) {
            String ipt = br.readLine();

            for (char ch:ipt.toCharArray()){
                if(ch == '<'){
                    if(stack.isEmpty()) continue;
                    buffer.add(stack.pop());
                } else if(ch == '>'){
                    if(buffer.isEmpty()) continue;
                    stack.add(buffer.pop());
                } else if(ch == '-'){
                    if(stack.isEmpty()) continue;
                    stack.pop();
                } else{
                    stack.add(ch);
                }
            }

            while(!buffer.isEmpty()){
                stack.add(buffer.pop());
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
            }

            System.out.println(sb.toString());

            stack.clear();
            buffer.clear();
        }
    }
}

