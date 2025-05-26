import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] currentAssignment = {0, 0};   // 남은 시간, 점수
        Stack<int[]> assignments = new Stack<>();

        int score = 0, time = 0;
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(stringTokenizer.nextToken());
            if(type == 1) {
                score = Integer.parseInt(stringTokenizer.nextToken());
                time = Integer.parseInt(stringTokenizer.nextToken());

                if(currentAssignment != null){
                    assignments.push(currentAssignment.clone());
                }

                currentAssignment = new int[] {time, score};
            }

            if(currentAssignment != null){
                currentAssignment[0]--;

                if(currentAssignment[0] == 0){
                    answer += currentAssignment[1];

                    if(!assignments.isEmpty()){
                        currentAssignment = assignments.pop();
                    } else{
                        currentAssignment = null;
                    }
                }
            }
        }


        System.out.println(answer);
    }
}
