import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numbers = br.readLine();
        int base = 0;
        int ptr = 0;

        while(ptr < numbers.length()){
            base++;
            String target = String.valueOf(base);

            for(int i = 0; i < target.length(); i++){
                if(target.charAt(i) == numbers.charAt(ptr)){
                    ptr++;
                }

                if (ptr == numbers.length()) {
                    break;
                }
            }
        }

        System.out.println(base);
    }
}
