import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        Queue<Integer> numbers = new LinkedList<>();
        stringTokenizer =  new StringTokenizer(br.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int answer = 0;

        while(!numbers.isEmpty()){
            int cur = numbers.poll();
            int curIdx = dq.indexOf(cur);
            int halfIdx = dq.size() % 2 == 0 ? dq.size() / 2 - 1 : dq.size() / 2;

            if(curIdx <= halfIdx){
                answer += curIdx;
                for (int i = 0; i < curIdx; i++) {
                    dq.add(dq.poll());
                }
            } else{
                answer += dq.size() - curIdx;
                for (int i = 0; i < dq.size() - curIdx; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
            dq.poll();
        }
        System.out.println(answer);
    }
}
