import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                } else if(getNumberSum(o1) != getNumberSum(o2)){
                    return getNumberSum(o1) - getNumberSum(o2);
                } else{
                    return o1.compareTo(o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str:words){
            sb.append(str);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static int getNumberSum(String str){
        int result = 0;
        for (char ch:str.toCharArray()){
            if('0' <= ch && ch <= '9'){
                result += (int)(ch -'0');
            }
        }
        return result;
    }
}
