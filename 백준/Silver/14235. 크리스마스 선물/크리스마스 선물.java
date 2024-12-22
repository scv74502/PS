import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int N = Integer.parseInt(br.readLine());
        int presentCnt;

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");

            // 아이들을 만나서 선물 전달한 경우
            if(ipts.length == 1){
                // 선물 보따리가 비었는지 아닌지에 따라 갈림
                if(pq.isEmpty()){
                    bw.write("-1\n");
                } else{
                    bw.write(pq.poll() + "\n");
                }
            } else if (ipts.length > 1) {
                presentCnt = Integer.parseInt(ipts[0]);

                for (int j = 1; j <= presentCnt; j++) {
                    pq.add(Integer.parseInt(ipts[j]));
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
