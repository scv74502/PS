import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());   // 다리 길이
        int L = Integer.parseInt(st.nextToken());   // 다리 최대 중량

        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> trucks = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        int currentWeight = 0;
        int spentTurn = 0;

        for (int i = 0; i < W; i++) {
            queue.add(0);
        }

        while (!trucks.isEmpty()){
            currentWeight -= queue.poll();

            if(currentWeight + trucks.peek() <= L){
                currentWeight += trucks.peek();
                queue.add(trucks.poll());
            } else{
                queue.add(0);
            }

            spentTurn++;
        }

        while(currentWeight != 0){
            currentWeight -= queue.poll();
            spentTurn++;
        }

        System.out.println(spentTurn);
    }
}
