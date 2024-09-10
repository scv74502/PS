import java.io.*;
import java.util.Arrays;

public class Main {
    public static int K, N;
    // cable은 모두 int 범위 내의 수이다
    public static int[] cables;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");
        K = Integer.parseInt(ipts[0]);
        N = Integer.parseInt(ipts[1]);
        cables = new int[K];

        for(int i = 0; i < K; i++){
            cables[i] = Integer.parseInt(br.readLine());
        }
        // 여기까지 문제의 입력 파트
        // 이후로 케이블을 정렬하고 이분 탐색으로 탐색

        long answer = 1L;

        long maxCable = 0;
        for(int i = 0; i < K; i++){
            maxCable = Math.max(maxCable, cables[i]);
        }

        maxCable++;

        // 랜선을 못 민드는 가장
        answer = bisect(0, maxCable);
        System.out.println(answer - 1);
    }

    public static long bisect(long left, long right){
        long mid = 0;
        while(left < right){
            mid = (left + right) / 2;
            if(getWireAmount(mid) < N){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static long getWireAmount(long size){
        long answer = 0;
        for(int i = 0; i < K; i++){
            answer += cables[i] / size;
        }
        return answer;
    }
}
