import java.io.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static String aStr, bStr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");
        aStr = ipts[0];
        bStr = ipts[1];

        for (int i = 0; i < bStr.length() - aStr.length() + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < aStr.length(); j++) {
                if(aStr.charAt(j) != bStr.charAt(j + i)) cnt++;
            }
            answer = Math.min(cnt, answer);
        }

        System.out.println(answer);
    }
}
