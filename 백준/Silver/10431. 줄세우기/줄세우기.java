import java.io.*;

public class Main {
    public static int[] line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;
        int answer = 0;
        int cnt;
        int[] lines;
        int rpt = Integer.parseInt(br.readLine());

        for(int r = 1; r <= rpt; r++){
            answer = 0;
            ipts = br.readLine().split(" ");
            lines = new int[ipts.length - 1];
            for(int i = 1; i < ipts.length; i++){
                lines[i-1] = Integer.parseInt(ipts[i]);
            }

            for(int i = 1; i < lines.length; i++){
                cnt = 0;
                for(int j = 0; j < i; j++){
                    if(lines[j] > lines[i]){
                        cnt++;
                    }
                }
                answer += cnt;
            }

            sb.append(r).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
