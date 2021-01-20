package BackTrack;

import java.util.*;

public class P39 {
    List<List<Integer>> res;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(target, combine, 0);
        return res;
    }

    public void dfs(int target, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(target, combine, index + 1);
        // 选择当前数
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(target - candidates[index], combine, index);
            combine.remove(combine.size() - 1);//回溯
        }
    }
}
