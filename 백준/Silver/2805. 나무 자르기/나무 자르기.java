import java.io.*;

public class Main {
    static int N;
    static long M;
    static long[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);

        ipts  = br.readLine().split(" ");
        trees = new long[N];

        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(ipts[i]);
        }

        long ans = bisect();
        System.out.println(ans - 1);
    }

    public static long bisect(){
        long l = 0;
        long r = 2000000001;
        long mid = 0;

        while(l < r){
            mid = (l+r) / 2;
            if(getTreeHeight(mid) < M){
                r = mid ;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static long getTreeHeight(long height){
        long ans = 0;
        for(long tree:trees){
            if(height < tree){
                ans += (tree - height);
            }
        }
        return ans;
    }
}
