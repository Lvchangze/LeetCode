package Tree;

public class P116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null || root.left == null)
            return root;

        root.left.next = root.right;

        if(root.next != null)
            root.right.next = root.next.left;//很重要

        connect(root.left);
        connect(root.right);

        return root;
    }
}
