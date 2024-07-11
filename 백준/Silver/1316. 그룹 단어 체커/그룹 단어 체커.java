import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int rpt = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean flag;

         for(int r = 0; r < rpt; r++) {
             flag = true;
             String word = br.readLine();
             int left = 0;
             int right = 0;
             Set<Character> store = new HashSet<>();
             while(right < word.length()) {
                 char ch = word.charAt(left);
                 if(store.contains(ch)) {
                     flag = false;
                     break;
                 }
                 store.add(ch);
                 while(right < word.length() && word.charAt(right) == ch) {
                     right += 1;
                 }
                 left = right;
             }
             if(flag) {
                 answer += 1;
             }
         }
         sb.append(answer);
         bw.write(sb.toString());
         bw.flush();
    }
}