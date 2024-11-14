import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        ipts = br.readLine().split(" ");
        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);

        int[] bitTrain = new int[N+1];

//        System.out.println(toBinaryString(bitTrain[0]));
        int orderParam;
        for (int i = 0; i < M; i++) {
            ipts = br.readLine().split(" ");
            int order = Integer.parseInt(ipts[0]);
            int trainNum = Integer.parseInt(ipts[1]);

            if (order == 1) {
                orderParam = Integer.parseInt(ipts[2]);
                // x번째 비트 1로 만들기(OR)
                bitTrain[trainNum] |= (1 << (orderParam - 1));
            } else if (order == 2) {
                orderParam = Integer.parseInt(ipts[2]);
                // x번째 비트 0으로 만들기(AND, NOT)
                bitTrain[trainNum] &= ~(1 << (orderParam-1));
            } else if (order == 3) {
                // 가장 왼쪽 비트 0으로 만들기(하차, AND, NOT, SHIFT)
                bitTrain[trainNum] &= ~(1 << 19);
                bitTrain[trainNum] <<= 1;
            } else {
                // 가장 오른쪽 비트 0으로 만들기(하차, AND, NOT)
                bitTrain[trainNum] &= ~1;
                bitTrain[trainNum] >>= 1;
            }
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            hs.add(bitTrain[i]);
        }

        System.out.println(hs.size());
    }
}
