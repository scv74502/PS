import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipts = br.readLine();

        long sum = 0;
        boolean isZeroExists = false;
        ArrayList<Character> numbers = new ArrayList<>();

        for (int i = 0; i < ipts.length(); i++) {
            if(ipts.charAt(i) == '0') isZeroExists = true;
            sum += ipts.charAt(i) - '0';
            numbers.add(ipts.charAt(i));
        }

        if(!isZeroExists || sum % 3 != 0){
            System.out.println(-1);
            return;
        }

        numbers.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2 - o1;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Character number : numbers) {
            sb.append(number);
        }

        System.out.println(sb.toString());
    }
}
