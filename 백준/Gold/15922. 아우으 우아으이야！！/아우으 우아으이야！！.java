import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long x, y, cx = 0, cy = 0;
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        cx = Long.parseLong(st.nextToken());
        cy = Long.parseLong(st.nextToken());

        if(N == 1){
            System.out.println(cy - cx);
            return;
        }

        boolean checked = false;

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());

            if(x > cy){
                answer += cy - cx;
                cy = y;
                cx = x;
                checked = true;
            } else if(y <=cy){
                continue;
            } else {
                cy = y;
                checked = false;
            }
        }


        answer += cy - cx;

        System.out.println(answer);
    }
}