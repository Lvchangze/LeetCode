package BackTrack;

import java.util.*;

public class P22 {

    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n);
        return res;
    }
    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     */
    //深搜有回溯的意思在里面
    private void dfs(String curStr, int left, int right) {
        //在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        //左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(curStr + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1);
        }
    }

    //回溯
    List<String> ans;
    public List<String> generateParenthesis2(int n) {
        ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return ans;
    }
    /**
     * @param cur   当前递归得到的结果
     * @param left  左括号已使用几个
     * @param right 右括号已使用几个
     */
    public void backtrack(StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (left < max) {
            cur.append('(');
            backtrack(cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            backtrack(cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
