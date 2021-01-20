package BackTrack;

import java.util.*;

public class P46 {
    List<List<Integer>> res;
    int[] nums;
    int len;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        len = nums.length;
        res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        backTrack(0, path);
        return res;
    }


    private void backTrack(int depth, List<Integer> path) {
        //其实depth就是path的长度
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        //在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                backTrack(depth + 1, path);

                //「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
