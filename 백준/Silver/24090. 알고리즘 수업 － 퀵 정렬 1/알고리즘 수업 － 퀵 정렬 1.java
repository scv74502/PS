import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int swapCnt = 0;
    static int swapNum1, swapNum2, K;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[N];

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        quickSort(0, N - 1);
        if(swapCnt < K){
            System.out.println(-1);
        } else{
            System.out.println(swapNum1 + " " + swapNum2);
        }
    }

    static void quickSort(int left, int right) {
        if(left < right){
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }

    static int partition(int pivot, int right) {
        int x = array[right];
        int i = pivot - 1;

        for (int j = pivot; j < right; j++) {
            if(array[j] <= x){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                swapCnt++;

                if(swapCnt == K){
                    swapNum1 = array[i];
                    swapNum2 = array[j];
                }
            }
        }

        if(i + 1 != right){
            int temp = array[i + 1];
            array[i + 1] = array[right];
            array[right] = temp;
            swapCnt++;

            if(swapCnt == K){
                swapNum1 = array[i + 1];
                swapNum2 = array[right];
            }
        }

        return i + 1;
    }


}