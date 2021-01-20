package Tree;

import java.util.*;

public class P257 {
    //DFS
    List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, "");
        return result;
    }
    public void dfs(TreeNode root, String currentPath) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            result.add(currentPath + root.val);
        } else {
            currentPath += root.val + "->";
            dfs(root.left, currentPath);
            dfs(root.right, currentPath);
        }
    }

    //BFS
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();//用队列来保存路径

        nodeQueue.offer(root);
        pathQueue.offer(root.val + "");

        while (!nodeQueue.isEmpty()) {
            //tmp和path是配对的
            TreeNode tmp = nodeQueue.poll();
            String path = pathQueue.poll();
            if (tmp.left == null && tmp.right == null) {//叶节点
                result.add(path);
                continue;
            }
            //不是叶子节点
            if (tmp.left != null) {
                nodeQueue.offer(tmp.left);
                pathQueue.offer(path + "->" + tmp.left.val);
            }
            if (tmp.right != null) {
                nodeQueue.offer(tmp.right);
                pathQueue.offer(path + "->" + tmp.right.val);
            }
        }
        return result;
    }
}
