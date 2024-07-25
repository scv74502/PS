import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int rpt = Integer.parseInt(br.readLine());
        String ipt;
        HashMap<String, Integer> hm = null;
        int answer = 0;

        for (int i = 0; i < rpt; i++) {
            ipt = br.readLine().strip();
            if(ipt.equals("ENTER")){
                hm = new HashMap<>();
            } else{
                if(hm.containsKey(ipt)){
                    continue;
                } else{
                    hm.put(ipt, 1);
                    answer++;
                }
            }
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
    }
}
