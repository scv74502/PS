import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, curChannel;
    static int answer = Integer.MAX_VALUE;
    static boolean[] isBroken = new boolean[10];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        curChannel = 100;

        int brokenAmount = Integer.parseInt(br.readLine());
        if(brokenAmount > 0){
        StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenAmount; i++) {
                int cur = Integer.parseInt(st.nextToken());
                isBroken[cur] = true;
            }
        }

        answer = Math.abs(curChannel - N);

        for (int i = 0; i <= 1_000_000; i++) {
            if(isPossible(i)){
                int secCnt = Math.abs(N - i) + String.valueOf(i).length();
                answer = Math.min(answer, secCnt);
            }
        }
        System.out.println(answer);
    }

    static boolean isPossible(int num){
        String numbers = String.valueOf(num);
        for(char ch:numbers.toCharArray()){
            if(isBroken[ch - '0']) return false;
        }
        return true;
    }
}
