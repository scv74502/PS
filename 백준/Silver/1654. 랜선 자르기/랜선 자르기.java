import java.io.*;

public class Main{
    static int K, N;
    static long[] wires;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        ipts = br.readLine().split(" ");
        K = Integer.parseInt(ipts[0]);
        N = Integer.parseInt(ipts[1]);
        wires = new long[K];

        long maxCable = 0;

        for (int i = 0; i < K; i++) {
            wires[i] = Long.parseLong(br.readLine());
            maxCable = Math.max(maxCable, wires[i]);
        }

        long answer = bisect(0, maxCable+1);
        System.out.println(answer - 1);
    }

    static long bisect(long left, long right){
        long mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if(getWiresAmount(mid) < N){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static long getWiresAmount(long wireLen){
        long ans = 0;
        for(long wire:wires){
            ans += wire / wireLen;
        }
        return ans;
    }
}
