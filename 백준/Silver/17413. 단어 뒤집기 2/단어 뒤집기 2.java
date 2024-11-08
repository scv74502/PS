import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt = br.readLine();;
        StringBuffer sb = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        boolean isTag = false;

        for(char ch: ipt.toCharArray()) {
            if(ch == '<') {
                if(temp.length() > 0){
                    sb.append(temp.reverse().toString());
                    temp.setLength(0);
                }
                sb.append(ch);
                isTag = true;
            }

            else if(ch == '>') {
                sb.append(ch);
                isTag = false;
            }

            else {
                if(isTag) sb.append(ch);
                else{
                    if(ch == ' ') {
                        sb.append(temp.reverse().toString());
                        sb.append(' ');
                        temp.setLength(0);
                    } else{
                        temp.append(ch);
                    }
                }
            }
        }

        if(temp.length() > 0) sb.append(temp.reverse().toString());

        bw.write(sb.toString());
        bw.flush();
    }
}
