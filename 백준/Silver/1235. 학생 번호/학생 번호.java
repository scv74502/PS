import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        String[] numbers = new String[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
        }

        int maxLength = numbers[0].length();
        int answer = -1;
        HashSet<String> chkSet = new HashSet<>();

        for (int i = maxLength - 1; i >= 0; i--) {
            String curChk = numbers[0].substring(i, maxLength);
            chkSet.add(curChk);
            for (int j = 1; j < N; j++) {
                String nextChk = numbers[j].substring(i, maxLength);
                chkSet.add(nextChk);
            }
            if(chkSet.size() == N){
                answer = curChk.length();
                break;
            }
            chkSet.clear();
        }

        System.out.println(answer);
    }
}

