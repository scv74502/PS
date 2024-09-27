import java.io.*;
import java.util.*;

public class Main {
    static HashSet<Character> vowels = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String ipt = br.readLine();

        vowels.add('a');
        vowels.add('i');
        vowels.add('e');
        vowels.add('o');
        vowels.add('u');

        while(!ipt.equals("end")){
            if(checkWord(ipt)){
                sb.append("<").append(ipt).append("> is acceptable.\n");
            } else{
                sb.append("<").append(ipt).append("> is not acceptable.\n");
            }
            ipt = br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static boolean checkWord(String word){
        int seqVowel = 0;
        int seqConst = 0;
        int vowelCount = 0;

        if(vowels.contains(word.charAt(0))){
            seqVowel += 1;
            vowelCount += 1;
        } else{
            seqConst += 1;
        }

        for(int i = 1; i < word.length(); i++){
            if(vowels.contains(word.charAt(i))){
                seqVowel += 1;
                vowelCount += 1;
                seqConst = 0;
            } else{
                seqVowel = 0;
                seqConst += 1;
            }

            // 3번 규칙
            if(word.charAt(i) != 'e' && word.charAt(i) != 'o'){
                if(word.charAt(i) == word.charAt(i - 1)){
                    return false;
                }
            }

            if(seqVowel >= 3 || seqConst >= 3){
                return false;
            }
        }

        return vowelCount != 0;
    }
}
