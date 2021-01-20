package BackTrack;

import java.util.*;

public class P77 {

    List<List<Integer>> res;
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        this.n = n;
        this.k = k;
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(1, path);
        return res;
    }

    private void dfs(int begin, Deque<Integer> path) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(i + 1, path);
            // 回溯
            path.removeLast();
        }
    }
}
