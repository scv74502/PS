import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        int a = Integer.parseInt(ipts[0]);
        int b = Integer.parseInt(ipts[1]);

        boolean[] isPrime = new boolean[b + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= b; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= b; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = a; i <= b; i++) {
            if (isPrime[i] && isPalindrome(i)) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }

        bw.write("-1");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
