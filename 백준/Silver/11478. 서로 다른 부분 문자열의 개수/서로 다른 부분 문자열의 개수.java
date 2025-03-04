import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int len = str.length();
        
        HashSet<String> hs = new HashSet<>();

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                if(!hs.contains(str.substring(j, j + i))){
                    hs.add(str.substring(j, j + i));
                }
            }
        }

        System.out.println(hs.size());
    }
}