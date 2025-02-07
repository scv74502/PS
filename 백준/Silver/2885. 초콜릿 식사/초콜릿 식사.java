import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int K = Integer.parseInt(br.readLine());
        int splitTimes = 0;

        int minSize = 1;

        while(minSize < K){
            minSize = minSize << 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(minSize);

        int currentChoco = 0;

        while(currentChoco != K && !pq.isEmpty()){
            int curBar = pq.poll();
            if(currentChoco + curBar == K){
                currentChoco += curBar;
                continue;
            } else if(currentChoco + curBar > K){
                pq.add(curBar / 2);
                pq.add(curBar / 2);
                splitTimes++;
            } else{
                currentChoco += curBar;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(minSize).append(" ").append(splitTimes).append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
