package BackTrack;

import java.util.*;

public class P40 {
    List<List<Integer>> res;
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates.length == 0)
            return res;
        this.candidates = candidates;
        Deque<Integer> combine = new ArrayDeque<>();
        //排序，避免重复
        Arrays.sort(candidates);
        dfs(target, combine, 0);
        return res;
    }

    public void dfs(int target, Deque<Integer> combine, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            //避免重复
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combine.addLast(candidates[i]);
            dfs(target - candidates[i], combine, i + 1);
            combine.removeLast();
        }
    }
}
