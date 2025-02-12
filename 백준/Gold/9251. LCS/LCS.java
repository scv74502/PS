import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String strA = br.readLine();
        String strB = br.readLine();

        int lenA = strA.length();
        int lenB = strB.length();

        int[][] lcs = new int[lenA + 1][lenB + 1];
        int answer = 0;

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if(strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    // 문자열 A i번 글자와 문자열 B j번 글자가 같으면, lcs 길이는 lcs[i-1][j-1]보다 1 길다
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else{
                    // 문자열 A i번 글자와 문자열 B j번 글자가 다르면 lcs는 lcs[i-1][j], lcs[i][j-1]중 큰 값이다
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
                answer = Math.max(answer, lcs[i][j]);
            }
        }
        System.out.println(answer);
    }
}
