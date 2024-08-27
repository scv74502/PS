import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<int[]> studentList;
    public static int[] students = new int [101];
    public static void sortStudentList(){
        studentList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(students[o1[0]] == students[o2[0]]){
                    return o1[1] - o2[1];
                }
                else{
                    return students[o1[0]] - students[o2[0]];
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int rec = Integer.parseInt(br.readLine());
        ipts = br.readLine().split(" ");

        int num;
        // 0 - 학생 번호, 1 - 게시된 시점
        studentList = new ArrayList<>();

        for(int i = 0; i < rec; i++){
            num = Integer.parseInt(ipts[i]);
            if(students[num] > 0){
                students[num] += 1;
            } else{
                if(studentList.size() >= N){
                    sortStudentList();
                    students[studentList.get(0)[0]] = 0;
                    studentList.remove(0);
                }
                students[num] += 1;
                studentList.add(new int[] {num, i});
            }
        }

        studentList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] student : studentList) {
            sb.append(student[0]);
            sb.append(" ");
        }

        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
