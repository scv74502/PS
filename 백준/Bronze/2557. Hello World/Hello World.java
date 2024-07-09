import java.io.*;


public class Main{
    public static void main(String args[]) throws IOException{
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("Hello World!");
        bw.flush();
    }
}
