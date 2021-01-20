package Tree;

import java.util.ArrayList;
import java.util.List;

public class P783 {
    List<Integer> vals = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < vals.size() - 1; ++i)
            ans = Math.min(ans, vals.get(i + 1) - vals.get(i));
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        vals.add(node.val);
        dfs(node.right);
    }
}
