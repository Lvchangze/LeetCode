package NewDataStructure;

import java.util.Stack;

class BSTIterator {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {//初始化的时候先把root的所有左边的节点入栈
        push(root);
    }

    public void push(TreeNode root) {//左边全部入栈
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {//next，取出栈顶元素p(当前返回值)。把p的右子树的左节点全部入栈
        TreeNode node = stack.pop();
        if (node.right != null) {
            push(node.right);
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {//hasNext只要栈不空就是还有下一个元素
        return !stack.isEmpty();
    }
}

