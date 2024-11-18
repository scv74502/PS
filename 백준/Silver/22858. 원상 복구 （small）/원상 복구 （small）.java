import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] shuffledCards;
    static int[] tempCards;
    static int[] inverseOrders;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        ipts = br.readLine().split(" ");
        int N = Integer.parseInt(ipts[0]);
        int K = Integer.parseInt(ipts[1]);

        shuffledCards = new int[N+1];

        inverseOrders = new int[N+1];

        ipts = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            shuffledCards[i] = Integer.parseInt(ipts[i-1]);
        }


        ipts = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            int loc = Integer.parseInt(ipts[i-1]);
            inverseOrders[i] = loc;
        }

        for (int i = 0; i < K; i++) {
            tempCards = new int[N+1];
            for (int j = 1; j < N+1; j++) {
                tempCards[inverseOrders[j]] = shuffledCards[j];
            }
            shuffledCards = tempCards;
        }

        for (int i = 1; i <= N; i++) {
            bw.write(shuffledCards[i] + " ");
        }

        bw.flush();
    }
}
