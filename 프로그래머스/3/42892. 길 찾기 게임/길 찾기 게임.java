import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] nodeArr = new int[nodeinfo.length][3];
        for(int i = 0; i < nodeinfo.length; i++) {
            nodeArr[i][0] = nodeinfo[i][0];
            nodeArr[i][1] = nodeinfo[i][1];
            nodeArr[i][2] = i + 1;
        }
        
        Arrays.sort(nodeArr, (a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });        
        
        Node root = buildTree(nodeArr);
        ArrayList<Integer> preOrderResult = new ArrayList<>();
        ArrayList<Integer> postOrderResult = new ArrayList<>();
        preOrder(root, preOrderResult);
        postOrder(root, postOrderResult);
        int[][] answer = new int[2][nodeinfo.length];
        
        for(int i = 0; i < preOrderResult.size(); i++){
            answer[0][i] = preOrderResult.get(i);
        }
        
        for(int i = 0; i < postOrderResult.size(); i++){
            answer[1][i] = postOrderResult.get(i);
        }
        
        return answer;
    }
    
    // 전위 순회 (Root -> Left -> Right)
    public void preOrder(Node current, List<Integer> list) {
        if (current == null) return;
        list.add(current.nodeNumber);
        preOrder(current.leftNode, list);
        preOrder(current.rightNode, list);
    }

    // 후위 순회 (Left -> Right -> Root)
    public void postOrder(Node current, List<Integer> list) {
        if (current == null) return;
        postOrder(current.leftNode, list);
        postOrder(current.rightNode, list);
        list.add(current.nodeNumber);
    }
    
    public Node buildTree(int[][] nodeArr) {
        Node root = new Node(nodeArr[0][0], nodeArr[0][1], nodeArr[0][2]);
        for(int i = 1; i < nodeArr.length; i++) {
            insertNode(root, nodeArr[i]);
        }
        return root;
    }
    
    public void insertNode(Node parent, int[] newNode) {
        if(newNode[0] < parent.x) {
            if(parent.leftNode == null) parent.leftNode = new Node(newNode[0], newNode[1], newNode[2]);
            else insertNode(parent.leftNode, newNode);
        } else {
            if(parent.rightNode == null) parent.rightNode = new Node(newNode[0], newNode[1], newNode[2]);
            else insertNode(parent.rightNode, newNode);
        }
    }
    
    class Node {
        int nodeNumber; 
        int x;
        int y;
        Node leftNode;
        Node rightNode;
        
        public Node(int x, int y, int nodeNumber) {
            this.nodeNumber = nodeNumber;
            this.x = x;
            this.y = y;
        }
    }
    
    class Tree {
        Node root;
    }
}
