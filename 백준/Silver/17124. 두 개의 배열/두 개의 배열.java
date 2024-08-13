import java.io.*;
import java.util.*;

public class Main {
    public static int[] a, b, c;

    public static int bisect(int l, int r, int num){
        while(l+1 < r){
            int mid = (l + r) / 2;

            if(num == b[mid]){
                return b[mid];
            } else if(num > b[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        // 작은 쪽이 절대값 차이가 작거나 큰 쪽과 절대값 차가 같으면 값이 작은 쪽 반환
        if(Math.abs(num - b[l]) <= Math.abs(b[r] - num)){
            return b[l];
        } else{
            return b[r];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;
        ArrayList<Integer> answers = new ArrayList<>();
        long ans;
        int rpt, aLen, bLen;
        int result;
        rpt = Integer.parseInt(br.readLine());

        for(int rr = 0; rr < rpt; rr++){
            ipts = br.readLine().split(" ");
            aLen = Integer.parseInt(ipts[0]);
            bLen = Integer.parseInt(ipts[1]);
            ans = 0;

            a = new int[aLen];
            b = new int[bLen];

            ipts = br.readLine().split(" ");
            for(int i = 0; i < aLen; i++){
                a[i] = Integer.parseInt(ipts[i]);
            }

            ipts = br.readLine().split(" ");
            for(int i = 0; i < bLen; i++){
                b[i] = Integer.parseInt(ipts[i]);
            }

            Arrays.sort(b);
            for(int i = 0; i < aLen; i++) {
                result = bisect(0, bLen - 1, a[i]);
                ans += result;
            }

            sb.append(ans);
            sb.append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
