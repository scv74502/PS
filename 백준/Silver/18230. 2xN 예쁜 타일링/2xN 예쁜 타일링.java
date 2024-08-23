import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N, A, B;
        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        A = Integer.parseInt(ipts[1]);
        B = Integer.parseInt(ipts[2]);

        // 2 X 1 타일
        Integer[] tileA = new Integer[A];

        // 2 X 2 타일
        Integer[] tileB = new Integer[B];

        ipts = br.readLine().split(" ");
        for(int i = 0; i < A; i++){
            tileA[i] = Integer.parseInt(ipts[i]);
        }

        ipts = br.readLine().split(" ");
        for(int i = 0; i < B; i++){
            tileB[i] = Integer.parseInt(ipts[i]);
        }

        Arrays.sort(tileA, Collections.reverseOrder());
        Arrays.sort(tileB, Collections.reverseOrder());

        int answer = 0;
        int capacity = N;
        int idxA = 0;
        int idxB = 0;

        while(capacity > 0){
            if(capacity >= 2 && idxB < B && (idxA >= A - 1 || tileB[idxB] >= (idxA < A ? tileA[idxA] + (idxA + 1 < A ? tileA[idxA + 1] : 0) : 0) ) ){
                answer += tileB[idxB];
                capacity -= 2;
                idxB++;
            } else if(idxA < A){
                answer += tileA[idxA];
                capacity -= 1;
                idxA++;
            } else{
                break;
            }
        }

        System.out.println(answer);
    }
}
