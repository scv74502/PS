import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> numbers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N <= 10){
            System.out.println(N);
        } else if(N > 1022){
            System.out.println(-1);
        } else{
            for (int i = 0; i < 10; i++) {
                bt(i, 1);
            }
            Collections.sort(numbers);
            System.out.println(numbers.get(N));
        }
    }

    public static void bt(long num, int idx){
        if(idx > 10){
            return;
        }

        numbers.add(num);

        for (int i = 0; i < num % 10; i++) {
            bt((num * 10) + i, idx + 1);
        }
    }
}
