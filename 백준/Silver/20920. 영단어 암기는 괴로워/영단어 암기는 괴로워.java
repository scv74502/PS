import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> appearCnts = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() < M) continue;

            // 이전에 나온 적 없으면
            if(!appearCnts.containsKey(word)){
                appearCnts.put(word, 1);
                words.add(word);
            }
            else{
                appearCnts.put(word, appearCnts.get(word)+1);
            }
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(appearCnts.get(o1) != appearCnts.get(o2)){
                    return appearCnts.get(o2) - appearCnts.get(o1);
                } else if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                } else{
                    return o1.compareTo(o2);
                }
            }
        });

        for (String word : words) {
            bw.write(word);
            bw.newLine();
        }

        bw.flush();
    }
}