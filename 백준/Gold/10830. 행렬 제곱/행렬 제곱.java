import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[][] originalArray = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 입력 단계에서 1000으로 나눈 나머지를 저장 (M=1인 경우 대비)
                originalArray[i][j] = Long.parseLong(st.nextToken()) % 1000;
            }
        }

        long[][] result = solve(originalArray, M);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
                if (j < N - 1) sb.append(" "); // 마지막 원소가 아닐 때만 공백 추가
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    // 분할 정복을 이용한 재귀
    public static long[][] solve(long[][] array, long exp) {
        if (exp == 1L) {
            return array;
        }

        long[][] half = solve(array, exp / 2);

        long[][] squared = getArrayMultiple(half, half);

        if (exp % 2 == 1) {
            return getArrayMultiple(squared, array);
        }

        return squared;
    }

    public static long[][] getArrayMultiple(long[][] array1, long[][] array2) {
        int N = array1.length;
        long[][] result = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0; 
                for (int k = 0; k < N; k++) {
                    sum += (array1[i][k] * array2[k][j]);
                    sum %= 1000; 
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}