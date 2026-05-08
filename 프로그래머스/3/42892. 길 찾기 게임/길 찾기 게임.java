import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        // x, y, 노드번호 순으로 재배치 후 정렬
        int[][] nodes = new int[nodeinfo.length][3];
        for(int i = 0; i < nodeinfo.length; i++){
            nodes[i][0] = nodeinfo[i][0];
            nodes[i][1] = nodeinfo[i][1];
            nodes[i][2] = i + 1;
        }
        
        Arrays.sort(nodes, (a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        
        // 루트 노드 생성 및 노드 삽입
        Node root = new Node(nodes[0][0], nodes[0][1], nodes[0][2]);
        for(int i = 1; i < nodes.length; i++){
            insertNode(root, nodes[i][0], nodes[i][1], nodes[i][2]);
        }
        
        ArrayList<Integer> prefixResult = new ArrayList<>();
        ArrayList<Integer> postfixResult = new ArrayList<>();
        prefix(root, prefixResult);
        postfix(root, postfixResult);
        
        int[][] answer = new int[2][nodes.length];
        for(int i = 0; i < nodes.length; i++) {
            answer[0][i] = prefixResult.get(i);
        }
        for(int i = 0; i < nodes.length; i++) {
            answer[1][i] = postfixResult.get(i);
        }
        
        return answer;
    }
    
    public void prefix(Node root, ArrayList<Integer> resultList) {
        resultList.add(root.nodeNumber);
        if(root.leftNode != null) prefix(root.leftNode, resultList);
        if(root.rightNode != null) prefix(root.rightNode, resultList);
    }
    
    public void postfix(Node root, ArrayList<Integer> resultList) {        
        if(root.leftNode != null) postfix(root.leftNode, resultList);
        if(root.rightNode != null) postfix(root.rightNode, resultList);
        resultList.add(root.nodeNumber);
    }
    
    public void insertNode(Node node, int x, int y, int nodeNumber){
        if(node.x > x){ // 모든 노드는 서로 다른 x값을 가진다
            if(node.leftNode == null) {
                node.leftNode = new Node(x, y, nodeNumber);
            } else {
                insertNode(node.leftNode, x, y, nodeNumber);
            }
        }  else {
            if(node.rightNode == null) {
                node.rightNode = new Node(x, y, nodeNumber);
            } else {
                insertNode(node.rightNode, x, y, nodeNumber);
            }
        }
    }
    
    class Node{
        int x;
        int y;
        int nodeNumber;
        
        Node leftNode;
        Node rightNode;
        
        public Node(int x, int y, int nodeNumber) {
            this.x = x;
            this.y = y;
            this.nodeNumber = nodeNumber;
        }
    }
}