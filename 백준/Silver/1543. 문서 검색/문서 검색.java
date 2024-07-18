import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String originString = br.readLine().strip();
        String chkString = br.readLine().strip();
        int l = 0;
        int r = 0;
        int answer = 0;
        while(l <= r && r <= originString.length()) {
            r = Math.min((l + chkString.length()), originString.length());
            String chk = originString.substring(l, r);
            if(chk.length() == chkString.length() && chkString.equals(chk) ) {
                answer += 1;
                l = r;
                r = l + chkString.length();
            } else{
              l++;
              r++;
            }

        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
    }
}
