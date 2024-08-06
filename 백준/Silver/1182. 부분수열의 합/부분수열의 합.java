import java.io.*;

public class Main {
    public static int[] numbers;
    public static int N, S, COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        ipts = br.readLine().strip().split(" ");
        N = Integer.parseInt(ipts[0]);
        S = Integer.parseInt(ipts[1]);

        numbers = new int[N];
        ipts = br.readLine().strip().split(" ");

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(ipts[i]);
        }

        COUNT = 0;
        backTrack(0, 0);

        // S가 0이면 아무 수도 더하지 않은 공집합도 COUNT에 포함되므로, 1을 빼준다
        System.out.println(S == 0 ? COUNT - 1 : COUNT);
    }

    public static void backTrack(int idx, int sum){
        // N개의 수를 모두 훑었으면(0개부터 시작하므로 N번째 호출이면 종료시켜야 범위 초과 안함)
        if(idx == N){
            // 수들의 총합이 목표와 일치하면 COUNT 1 증가
            if(sum == S){
                COUNT++;
            }
            // COUNT 증가여부와 상관없이, N개의 수 모두 따졌으면 재귀 종료하기
            return;
        }

        // 다음 idx를 체크하되 지금 idx를 더하는 경우와 안 더하는 경우 두가지 모두 탐색하기!
        backTrack(idx+1, sum+numbers[idx]);
        backTrack(idx+1, sum);
    }
}