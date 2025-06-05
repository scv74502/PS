import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        HashSet<Integer> hs = new HashSet<>();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            hs.add(number);
            numbers[i] = number;
        }

        ArrayList<Integer> uniqueNumbers = new ArrayList<>(hs);

        Collections.sort(uniqueNumbers);

        HashMap<Integer, Integer> rankMap = new HashMap<>(uniqueNumbers.size());

        for (int i = 0; i < uniqueNumbers.size(); i++) {
            rankMap.put(uniqueNumbers.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for(int number: numbers){
            sb.append(rankMap.get(number));
            sb.append(" ");
        }

        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
