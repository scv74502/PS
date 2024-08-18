import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        // 수열 규칙성 위해 1 추가하여 패딩함
        int[] numbers = new int[N+1];
        int[] dp = new int[N+1];
        ipts = br.readLine().split(" ");

        for(int i = 1; i <= N; i++){
            numbers[i] = Integer.parseInt(ipts[i-1]);
        }

        numbers[0] = Integer.MAX_VALUE;

//        1. i는 1부터 N까지로 설정, j는 0부터 i-1까지로 설정
//        2. nubmers[i]일때, j 범위의 numbers[j]와 dp[j]를 탐색
//        3. numbers[j]가 numbers[i]보다 작은 수라면, dp[j]중 최대값 + 1을 dp[i]에 저장
//        4. dp 배열에서 가장 큰 값을 정답으로 함
        for(int i = 1; i <= N; i++){
            for(int j = 0; j < i; j++){
                if(numbers[i] < numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
