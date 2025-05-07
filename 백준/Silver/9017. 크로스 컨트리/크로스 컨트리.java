import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, int[]> runnerRecord = new HashMap<>();
            HashMap<Integer, Integer> runnerIdx = new HashMap<>();
            HashMap<Integer, Integer> runnerCount = new HashMap<>();

            int[] ranks = new int[N+1];

            for (int j = 1; j <= N; j++) {
                int nextNum = Integer.parseInt(st.nextToken());
                ranks[j] = nextNum;
                if(!runnerCount.containsKey(ranks[j])){
                    runnerCount.put(ranks[j], 1);
                } else{
                    runnerCount.put(ranks[j], runnerCount.get(ranks[j]) + 1);
                }
            }

            int rank = 1;

            for (int j = 1; j <= N; j++) {
                int team = ranks[j];

                if(runnerCount.get(team) < 6) continue;

                if(!runnerRecord.containsKey(team)){
                    runnerRecord.put(team, new int[] {0, rank, 0, 0, 0, 0, 0});
                    runnerIdx.put(team, 1);
                } else{
                    runnerRecord.get(team)[runnerIdx.get(team) + 1] = rank;
                    runnerIdx.put(team, runnerIdx.get(team) + 1);
                }
                rank++;
            }

            int lowestScore = Integer.MAX_VALUE;
            int answer = -1;
            int fifthScroe = -1;

            for (int key:runnerRecord.keySet()){
                if(runnerRecord.get(key)[6] == 0) continue;
                int scoreSum = 0;

                for (int j = 1; j <= 4; j++) {
                    scoreSum += runnerRecord.get(key)[j];
                }

                if(scoreSum < lowestScore){
                    lowestScore = scoreSum;
                    answer = key;
                    fifthScroe = runnerRecord.get(key)[5];
                } else if(scoreSum == lowestScore){
                    if(fifthScroe > runnerRecord.get(key)[5]){
                        answer = key;
                        fifthScroe = runnerRecord.get(key)[5];
                    }
                }
            }

            System.out.println(answer);
        }
    }
}

