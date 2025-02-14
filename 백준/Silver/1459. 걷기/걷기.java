import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long X, Y;
        int W, S;

        String[] ipts = br.readLine().split(" ");
        X = Long.parseLong(ipts[0]);
        Y = Long.parseLong(ipts[1]);
        W = Integer.parseInt(ipts[2]);
        S = Integer.parseInt(ipts[3]);

        long answer = 0;

        long case1 = (X + Y) * W;
        long case2 = 0;

        if((X + Y) % 2 == 0){
            case2 = (Math.max(X, Y)) * S;
        } else{
            case2 = (Math.max(X, Y) - 1) * S + W;
        }

        long case3 = Math.min(X, Y) * S + Math.abs(X - Y) * W;

        System.out.println(Math.min(case1, Math.min(case2, case3)));

        bw.close();
        br.close();
    }
}
