import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String ipt, fileName, extension;
        String[] ipts;
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split("\\.");
            extension = ipts[1];

            if(!hm.containsKey(extension)) {
                hm.put(extension, 1);
            } else{
                hm.put(extension, hm.get(extension) + 1);
            }
        }

        String[] sortedKeySet = hm.keySet().toArray(new String[0]);
        Arrays.sort(sortedKeySet);

        for(String s : sortedKeySet) {
            bw.write(s + " " + hm.get(s) + "\n");
        }

        bw.flush();
    }
}
