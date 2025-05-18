import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] targetCube = new int[8];
        for (int i = 0; i < 8; i++) {
            targetCube[i] = Integer.parseInt(st.nextToken());
        }

        Queue<QueueElement> queue = new ArrayDeque<>();
        queue.add(new QueueElement('0', 0, new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
        HashSet<String> visited = new HashSet<>();
        visited.add(arrayToString(new int[] {1, 2, 3, 4, 5, 6, 7, 8}));

        while(!queue.isEmpty()){
            char curOrder = queue.peek().curOrder;
            int curMoved = queue.peek().moved;
            int[] curCube = queue.peek().curCube;
            queue.poll();

            if(isSameArray(curCube, targetCube)){
                answer = Math.min(curMoved, answer);
                break;
            }

            int[] nextCube = doA(Arrays.copyOf(curCube, curCube.length));
            String nextVisit = arrayToString(nextCube);

            if(curOrder != 'A' && !visited.contains(nextVisit)){
                visited.add(nextVisit);
                QueueElement nextQueueElement = new QueueElement('A', curMoved + 1, nextCube);
                queue.add(nextQueueElement);
            }

            nextCube = doB(Arrays.copyOf(curCube, curCube.length));
            nextVisit = arrayToString(nextCube);

            if(!visited.contains(nextVisit)){
                visited.add(nextVisit);
                QueueElement nextQueueElement = new QueueElement('B', curMoved + 1, nextCube);
                queue.add(nextQueueElement);
            }

            nextCube = doC(Arrays.copyOf(curCube, curCube.length));
            nextVisit = arrayToString(nextCube);

            if(!visited.contains(nextVisit)){
                visited.add(nextVisit);
                QueueElement nextQueueElement = new QueueElement('C', curMoved + 1, nextCube);
                queue.add(nextQueueElement);
            }

            nextCube = doD(Arrays.copyOf(curCube, curCube.length));
            nextVisit = arrayToString(nextCube);

            if(curOrder != 'D' && !visited.contains(nextVisit)){
                visited.add(nextVisit);
                QueueElement nextQueueElement = new QueueElement('D', curMoved + 1, nextCube);
                queue.add(nextQueueElement);
            }
        }

        System.out.println(answer);
    }

    static int[] doA(int[] cube){
        for (int i = 0; i < 4; i++) {
            int temp = cube[i];
            cube[i] = cube[7 - i];
            cube[7 - i] = temp;
        }

        return cube;
    }

    static int[] doB(int[] cube){
        int temp = cube[3];
        for (int i = 3; i > 0; i--) {
            cube[i] = cube[i-1];
        }
        cube[0] = temp;

        temp = cube[4];
        for (int i = 4; i < 7; i++) {
            cube[i] = cube[i + 1];
        }
        cube[7] = temp;

        return cube;
    }

    static int[] doC(int[] cube){
        int temp = cube[1];
        cube[1] = cube[2];
        cube[2] = cube[5];
        cube[5] = cube[6];
        cube[6] = temp;
        return cube;
    }

    static int[] doD(int[] cube){
        int temp = cube[0];
        cube[0] = cube[4];
        cube[4] = temp;
        return cube;
    }

    static boolean isSameArray(int[] o1, int[] o2){
        if(o1.length != o2.length) return false;
        for (int i = 0; i < o1.length; i++) {
            if(o1[i] != o2[i]) return false;
        }
        return true;
    }

    static class QueueElement {
        char curOrder;
        int moved;
        int[] curCube;

        public QueueElement(char curOrder, int moved, int[] curCube) {
            this.curOrder = curOrder;
            this.moved = moved;
            this.curCube = curCube;
        }
    }

    static String arrayToString(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int num:arr){
            sb.append(num);
        }
        return sb.toString();
    }
}