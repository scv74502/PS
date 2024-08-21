import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int cur = 0;
        long cutWood = 0;
        int[] woods = new int[N];
        int[] groths = new int[N];
        int[][] order = new int[N][3];
        ipts = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            woods[i] = Integer.parseInt(ipts[i]);
            order[i][2] = woods[i];
        }


        ipts = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            groths[i] = Integer.parseInt(ipts[i]);
            order[i][0] = groths[i];
            order[i][1] = i;
        }

        Arrays.sort(order, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                // 성장량이 같은 나무면
                if(o1[0] == o2[0]){
                    return o1[2] - o2[2];
                } else{
                    return o1[0] - o2[0];
                }
            }
        });

        //System.out.println(Arrays.deepToString(order));

        for(int i = 0; i < N; i++){
            cur = order[i][1];
            cutWood += woods[cur];
            for(int j = 0; j < N; j++){
                woods[j] += groths[j];
            }
            woods[cur] = 0;

            //System.out.println(Arrays.deepToString(order));
        }

        System.out.println(cutWood);
    }
}
