import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int[][] lcs;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String strA = br.readLine();
        String strB = br.readLine();

        int lenA = strA.length();
        int lenB = strB.length();

        lcs = new int[lenA + 1][lenB + 1];
        String[][] curLcs = new String[lenA + 1][lenB + 1];

        for (int i = 0; i <= lenA; i++) {
            Arrays.fill(curLcs[i], "");
        }

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if(strA.charAt(i - 1) == strB.charAt(j - 1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        int lcsLen = 0;

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if(lcsLen < lcs[i][j]){
                    lcsLen = lcs[i][j];
                }
            }
        }

        getLcsString(strA.toCharArray(), lenA, lenB);
        System.out.println(lcsLen);
        if(lcsLen > 0){
            System.out.println(sb.toString());
        }
    }

    static void getLcsString(char[] str, int i, int j){
        Stack<Character> stack = new Stack<>();
        while(i > 0 && j > 0){
            if(lcs[i][j] == lcs[i-1][j]){
                i--;
            } else if (lcs[i][j] == lcs[i][j-1]){
                j--;
            } else{
                i--;
                stack.push(str[i]);
                j--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }
}
