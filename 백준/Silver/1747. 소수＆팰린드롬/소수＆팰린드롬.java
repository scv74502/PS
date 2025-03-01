import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int MAX = 2_000_001;
        boolean[] isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < MAX; i++) {
            if(isPrime[i]){
                for (int j = 2 * i; j < MAX; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = N; i < MAX; i++) {
            if(isPrime[i] && isPalindrome(i)){
                System.out.println(i);
                return;
            }
        }
    }

    public static boolean isPalindrome(int num){
        ArrayList<Integer> numbers = new ArrayList<>();
        while(num > 0){
            numbers.add(num % 10);
            num = num / 10;
        }

        for (int i = 0; i < numbers.size() / 2; i++) {
            if(numbers.get(i) != numbers.get(numbers.size() - 1 - i)) return false;
        }
        return true;
    }
}
