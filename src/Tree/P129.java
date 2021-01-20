package Tree;

public class P129 {

    public int sumNumbers(TreeNode root) {
        return helper(root,0);

    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {//到达了叶节点就返回
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);//一个节点有两个子节点
    }

}
