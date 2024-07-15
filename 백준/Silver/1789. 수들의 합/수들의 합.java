import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        long count = 0;
        long num = 1;
        long cur = 0;
        for (int i = 1; ; i++) {
            if(cur > N) break;
            cur += i;
            count += 1;
        }
        System.out.println(count-1);
    }
}
