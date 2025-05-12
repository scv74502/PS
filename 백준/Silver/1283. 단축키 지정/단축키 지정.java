import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Character, String> shortCuts = new HashMap<>();
    static HashMap<String, Integer> shortCutPositions = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word;

            // 단어 단위로 자르고
            String[] splitedWord = word.split(" ");
            boolean isShortCutAdded = false;

            // 왼부터 봄
            for (int j = 0; j < splitedWord.length ; j++) {
                String curWord = splitedWord[j];
                int curIdxBase = 0;
                for (int k = 0; k < j; k++) {
                    curIdxBase += splitedWord[k].length() + 1;
                }

                // 첫 글자를 단축키로 지정 가능한지 찾아봄
                if(!shortCuts.containsKey(curWord.charAt(0))) {
                    shortCuts.put(curWord.charAt(0), word);
                    shortCuts.put((char)(curWord.charAt(0) ^ 32), "");
                    isShortCutAdded = true;

                    shortCutPositions.put(word, curIdxBase);
                }

                if(isShortCutAdded) break;
            }
            if(isShortCutAdded) continue;

            for (int j = 0; j < word.length(); j++) {
                char ch = word.toCharArray()[j];
                if(ch == ' ') continue;

                if(!shortCuts.containsKey(ch)) {
                    shortCuts.put(ch, word);
                    shortCuts.put((char) (ch ^ 32), "");

                    shortCutPositions.put(word, j);
                    isShortCutAdded = true;
                }

                if(isShortCutAdded) break;
            }
        }


        for(String word : words) {
            StringBuilder sb = new StringBuilder(word);
            if(shortCutPositions.containsKey(word)){
                int idx = shortCutPositions.get(word);
                sb.replace(idx, idx + 1, "[" + word.charAt(idx) + "]");
            }
            sb.append("\n");
            bw.write(sb.toString());
        }

        bw.flush();

    }
}
