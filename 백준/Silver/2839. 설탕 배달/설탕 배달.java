import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int w=  Integer.parseInt(br.readLine());
		int answer = 0;
		
		if(w == 4 || w == 7) {
			sb.append(-1+"");
		}
		else if(w % 5 == 0) {
			sb.append((w / 5)+"");
		}
		else if(w % 5 == 1 || w % 5 == 3) {
			sb.append((w / 5 + 1)+"");
		}
		else if(w % 5 == 2 || w % 5 == 4) {
			sb.append((w / 5 + 2)+"");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}