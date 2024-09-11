import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] cards, targets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        ipts = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(ipts[i]);
        }
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        ipts = br.readLine().split(" ");

        for(int i = 0; i < M; i++){
            targets[i] = Integer.parseInt(ipts[i]);
        }

        for(int tgt:targets){
            if(bisect(tgt)){
                sb.append(1 + " ");
            } else{
                sb.append(0 + " ");
            }
        }

        bw.write(sb.toString().trim());
        bw.write("\n");
        bw.flush();
    }

    public static boolean bisect(int targetNum){
        int left = 0;
        int right = N;

        while(left < right){
            int mid = (left + right) / 2;

            if(cards[mid] == targetNum){
                return true;
            }

            else if(cards[mid] > targetNum){
                right = mid;
            } else{
                left = mid+1;
            }
        }

        return false;
    }
}
