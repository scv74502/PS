import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if(isGroupWord(word)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean isGroupWord(String word){
        Set<Character> set = new HashSet<>();
        char prev = ' ';
        for(char ch:word.toCharArray()){
            if(set.contains(ch) && ch != prev){
                return false;
            } else{
                set.add(ch);
            }

            prev = ch;
        }
        return true;
    }
}
