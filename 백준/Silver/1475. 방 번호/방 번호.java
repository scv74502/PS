import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;

        ipt = br.readLine().strip();
        int answer = 0;
        int[] cnt = new int[10];

        for (int i = 0; i < ipt.length(); i++) {
            if(ipt.charAt(i) - '0' == 6){
                cnt[9]++;
            }else{
                cnt[ipt.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 9; i++) {
            answer = Math.max(answer, cnt[i]);
        }

        int nine = cnt[9] / 2;
        if(cnt[9] % 2 == 1){
            nine++;
        }

        answer = Math.max(answer, nine);
        System.out.println(answer);
    }
}