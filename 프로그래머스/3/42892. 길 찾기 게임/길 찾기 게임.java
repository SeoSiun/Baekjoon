import java.util.*;

class Solution {
    class Node {
        public final int n;
        public int x;
        public int y;
        public Node left;
        public Node right;
        
        public Node(int n, int x, int y) {
            this.n = n;
            this.x = x;
            this.y = y;
            left = null;
            right = null;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(nodes, (n1, n2) -> n2.y - n1.y);
        Node root = constructTree(nodes);
        
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        pre(preList, root);
        post(postList, root);
        
        int[][] answer = new int[2][nodes.length];
        for (int i = 0; i < nodes.length; i++) answer[0][i] = preList.get(i);
        for (int i = 0; i < nodes.length; i++) answer[1][i] = postList.get(i);
        return answer;
    }
    
    private Node constructTree(Node[] nodes) {
        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }
        return root;
    }
    
    private void insert(Node root, Node node) {
        if (root.x > node.x) {
            if (root.left == null) {
                root.left = node;
            }
            else insert(root.left, node);
        }
        else {
            if (root.right == null) {
                root.right = node;
            }
            else insert(root.right, node); 
        }
    }
    
    private void pre(List<Integer> answer, Node node) {
        if (node == null) return;
        answer.add(node.n);
        pre(answer, node.left);
        pre(answer, node.right);
    }
    
    private void post(List<Integer> answer, Node node) {
        if (node == null) return;
        post(answer, node.left);
        post(answer, node.right);
        answer.add(node.n);
    }
}