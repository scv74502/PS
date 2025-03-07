import java.io.*;

public class Main {
    static StringBuilder sb;
    static boolean isPossible = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        bt(S, T);
        System.out.println(isPossible ? 1 : 0);
    }

    public static void bt(String origin, String target){
        if(origin.equals(target)){
            isPossible = true;
            return;
        }

        if(origin.length() >= target.length()) return;

        if (target.charAt(target.length() - 1) == 'A') {
            bt(origin, target.substring(0, target.length() - 1));
        }

        String temp = "";
        if (target.charAt(0) == 'B') {
            sb = new StringBuilder(target);
            temp = sb.reverse().substring(0, target.length() - 1);
            bt(origin, temp);
        }
    }
}

