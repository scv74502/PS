import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String arrStr = br.readLine();
            StringTokenizer st = new StringTokenizer(arrStr.substring(1, arrStr.length()-1), ",");

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                if(st.hasMoreTokens()) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }

            boolean isReversed = false;
            boolean isError = false;
            int start = 0;
            int end = n - 1;

            for(char cmd : p.toCharArray()) {
                if(cmd == 'R') {
                    isReversed = !isReversed;
                } else { // 'D'
                    if(start > end) {
                        isError = true;
                        break;
                    }

                    if(isReversed) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }

            if(isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if(start <= end) {
                    if(isReversed) {
                        for(int i = end; i >= start; i--) {
                            sb.append(arr[i]);
                            if(i > start) sb.append(",");
                        }
                    } else {
                        for(int i = start; i <= end; i++) {
                            sb.append(arr[i]);
                            if(i < end) sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            }
        }

        System.out.print(sb);
    }
}