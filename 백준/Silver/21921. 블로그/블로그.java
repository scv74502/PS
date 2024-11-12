import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int X = Integer.parseInt(ipts[1]);
        int[] counts = new int[N];

        ipts = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            counts[i] = Integer.parseInt(ipts[i]);
        }

        int curMax = Integer.MIN_VALUE;
        int maxCnt = 0;

        int temp = 0;
        for (int i = 0; i < X; i++) {
            temp += counts[i];
        }

        curMax = temp;
        maxCnt = 1;

        int left = 0;
        int right = X-1;

        if(X == N){
            if(temp == 0) System.out.println("SAD");
            else{
                System.out.println(temp);
                System.out.println(1);
            }
        } else{
            while(right < N-1){
                temp -= counts[left];
                left++;

                right++;
                temp += counts[right];

                if(temp > curMax){
                    curMax = temp;
                    maxCnt = 1;
                } else if (temp == curMax) {
                    maxCnt++;
                }
            }

            if(curMax == 0) System.out.println("SAD");
            else{
                System.out.println(curMax);
                System.out.println(maxCnt);
            }
        }


    }
}
