import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cranes = new int[N];
        String[] ipts = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(ipts[i]);
        }

        Arrays.sort(cranes);
        for (int i = 0; i < cranes.length / 2; i++) {
            int temp = cranes[i];
            cranes[i] = cranes[cranes.length - 1 - i];
            cranes[cranes.length - 1 - i] = temp;
        }


        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> boxes = new ArrayList<>();
        ipts = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(ipts[i]));
        }

        boxes.sort(Collections.reverseOrder());

        if(cranes[0] < boxes.get(0)){
            System.out.println(-1);
            return;
        }

        int turn = 0;
        while(!boxes.isEmpty()){
            turn++;
            int craneIdx = 0;
            int boxIdx = 0;

            while(craneIdx < N && boxIdx < boxes.size()){
                if(cranes[craneIdx] >= boxes.get(boxIdx)){
                    craneIdx++;
                    boxes.remove(boxIdx);
                } else{
                    boxIdx++;
                }
            }
        }

        System.out.println(turn);
    }
}
