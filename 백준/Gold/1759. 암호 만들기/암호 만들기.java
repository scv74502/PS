import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] letters;
    static boolean[] visited;
    static HashSet<Character> vowelSet;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        L = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        letters = new char[C];
        visited = new  boolean[C];
        stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            letters[i] = stringTokenizer.nextToken().charAt(0);
        }

        Arrays.sort(letters);

        vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i <= C - L; i++) {
            visited[i] = true;
            sb.append(letters[i]);
            bt(i, vowelSet.contains(letters[i]) ? 1 : 0, vowelSet.contains(letters[i]) ? 0 : 1, 1);
            sb.setLength(0);
        }
    }

    public static void bt(int letterIdx, int vowelCnt, int consonantCnt, int length){
        if(vowelCnt >= 1 && consonantCnt >= 2 && length == L){
            System.out.println(sb.toString());
            return;
        }

        for (int i = letterIdx + 1; i < C; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            sb.append(letters[i]);
            int vowel = vowelSet.contains(letters[i]) ? 1 : 0;
            int constant = vowelSet.contains(letters[i]) ? 0 : 1;
            bt(i, vowelCnt + vowel, consonantCnt + constant, length + 1);
            sb.delete(sb.length() - 1, sb.length());
            visited[i] = false;
        }
    }
}
