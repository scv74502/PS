import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final String STAN_FALSE = "Stan is dishonest";
        final String STAN_TRUE = "Stan may be honest";

        int lowerBound = 0;
        int upperBound = 11;
        int number = 0;

        while(true){
            String ipt = br.readLine();
            if(ipt.equals("0")) break;

            // 입력이 숫자 입력이면
            if (Character.isDigit(ipt.charAt(0))){
                number = Integer.parseInt(ipt);
            } else{ // 입력이 문자면
                if (ipt.equals("too high")){
                    upperBound = Math.min(upperBound, number);
                } else if (ipt.equals("too low")){
                    lowerBound = Math.max(lowerBound, number);
                } else if (ipt.equals("right on")){
                    if (number > lowerBound && upperBound > number){
                        sb.append(STAN_TRUE).append("\n");
                    }
                    else {
                        sb.append(STAN_FALSE).append("\n");
                    }
                    
                    // 게임 초기화
                    lowerBound = 0;
                    upperBound = 11;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
