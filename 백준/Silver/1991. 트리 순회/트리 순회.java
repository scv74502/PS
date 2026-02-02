import java.io.*;

public class Main {
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for(int i = 0; i < N; i++){
            tree[i] = new Node((char)('A' + i));
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char parent = line.charAt(0);
            char left = line.charAt(2);
            char right = line.charAt(4);

            if(left != '.'){
                tree[parent - 'A'].left = tree[left-'A'];
            }

            if(right != '.'){
                tree[parent - 'A'].right = tree[right-'A'];
            }
        }

        StringBuilder sb = new StringBuilder();

        preOrder(tree[0], sb);
        sb.append("\n");

        inOrder(tree[0], sb);
        sb.append("\n");

        postOrder(tree[0], sb);
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    static void preOrder(Node node, StringBuilder sb){
        if(node == null) return;
        sb.append(node.value);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    static void inOrder(Node node, StringBuilder sb){
        if(node == null) return;
        inOrder(node.left, sb);
        sb.append(node.value);
        inOrder(node.right, sb);
    }

    static void postOrder(Node node, StringBuilder sb){
        if(node == null) return;
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.value);
    }
}



