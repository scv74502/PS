import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] solutions = new long[N];
        ipts = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            solutions[i] = Long.parseLong(ipts[i]);
        }

        Arrays.sort(solutions);
        long maxSum = Long.MAX_VALUE;

        long[] answer = new long[] {100000000, 100000000, 100000000};

        // 첫번째 용액 범위는 첫번째~뒤에서 2번째
        for (int i = 0; i < N-2; i++) {
            // 두번재, 세번째 탐색 범위는 첫번째 다음 용액부터 맨 마지막 용액
            int left = i+1;
            int right = N - 1;

            // 탐색 범위 내에서 이분 탐색, 둘이 같아지면 용액 3개를 고를 수 없다
            while(left < right){
                long currentSum = solutions[i] + solutions[left] + solutions[right];

                // 용액 총합이 0에 가깝도록 설정
                if(Math.abs(currentSum) < Math.abs(maxSum)){
                    maxSum = currentSum;
                    answer = new long[]{solutions[i], solutions[left], solutions[right]};
                }

                // 0에 더 가까워지도록 right, left 범위 조정하기
                if(currentSum > 0){
                    right -= 1;
                } else if(currentSum < 0){
                    left += 1;
                } else{
                   break;
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            sb.append(answer[j]);
            if (j < 2) sb.append(" ");
            else sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
