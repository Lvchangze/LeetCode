package Tree;

import java.util.ArrayList;
import java.util.List;

public class P230 {
    List<Integer> vals = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return vals.get(k - 1);
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        vals.add(node.val);
        dfs(node.right);
    }
}
