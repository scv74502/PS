import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static Deque<Register> deque;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int rpt = Integer.parseInt(br.readLine());

        int start, target;
        for (int i = 0; i < rpt; i++) {
            ipts = br.readLine().split(" ");
            start = Integer.parseInt(ipts[0]);
            target = Integer.parseInt(ipts[1]);

            deque = new ArrayDeque<>();
            bfs(start, target);
        }
    }

    public static void bfs(int start, int target){
        visited = new boolean[10001];
        deque.clear();
        deque.add(new Register(start, new StringBuilder()));
        int nextNumber, digit, left, tenSquare;
        StringBuilder nextCommand;


        while(!deque.isEmpty()){
            Register currentRegister = deque.pollFirst();
            if(currentRegister.number == target){
                System.out.println(currentRegister.stringBuilder.toString());
                return;
            }
            visited[currentRegister.number] = true;

            // D
            nextNumber = (currentRegister.number * 2) % 10000;
            if(!visited[nextNumber]) {
                nextCommand = new StringBuilder(currentRegister.stringBuilder).append("D");
                deque.add(new Register(nextNumber, nextCommand));
                visited[nextNumber] = true;
            }

            // S
            nextNumber = currentRegister.number == 0 ? 9999 : currentRegister.number - 1;
            if(!visited[nextNumber]) {
                nextCommand = new StringBuilder(currentRegister.stringBuilder).append("S");
                deque.add(new Register(nextNumber, nextCommand));
                visited[nextNumber] = true;
            }

            // L
            nextNumber = (currentRegister.number % 1000) * 10 + currentRegister.number / 1000;
            if(!visited[nextNumber]) {
                nextCommand = new StringBuilder(currentRegister.stringBuilder).append("L");
                deque.add(new Register(nextNumber, nextCommand));
                visited[nextNumber] = true;
            }

            // R
            nextNumber = (currentRegister.number % 10) * 1000 + currentRegister.number / 10;

            if(!visited[nextNumber]) {
                nextCommand = new StringBuilder(currentRegister.stringBuilder).append("R");
                deque.add(new Register(nextNumber, nextCommand));
                visited[nextNumber] = true;
            }
        }
    }
}

class Register{
    int number;
    StringBuilder stringBuilder;

    public Register(int number, StringBuilder stringBuilder) {
        this.number = number;
        this.stringBuilder = stringBuilder;
    }
}
