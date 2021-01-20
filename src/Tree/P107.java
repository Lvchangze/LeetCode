package Tree;

import java.util.*;

public class P107 {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> a = new ArrayList<>();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                a.add(tmp.val);
                if (tmp.left != null)
                    queue.offer(tmp.left);
                if (tmp.right != null)
                    queue.offer(tmp.right);
                size--;
            }
            result.add(a);
        }
        Collections.reverse(result);
        return result;
    }
}
