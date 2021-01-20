package DynamicProgram;

public class P486 {
    /**
     * 动态规划解法
     */
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];//dp[i][j]表示：在nums数组的i到j下标区间内，当前玩家比另一玩家分数之差的最大值
        //初始化 dp数组的 已知结果
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        //计算 dp数组：
        //1、 由于 dp[i][j] 是在 dp[i + 1][j] 和 dp[i][j - 1] 的基础上 计算出来的
        //    因此，i从 最后一个元素开始，向前遍历，
        //    但是，i如果为最后一个元素，就不会有元素排在其后，j则越界，
        //    因此，i从倒数第二个元素开始
        //2、 为了保证区间的“合理性”(左边界 < 右边界)，
        //    因此，j从i+1开始，向后遍历
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                // 当前 dp[i][j]，分为两种情况：
                //    1、如果当前玩家取nums[i]，则比另一玩家多的值为：nums[i] - dp[i + 1][j]
                //    2、如果当前玩家取nums[j]，则比另一玩家多的值为：nums[j] - dp[i][j - 1]
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return (dp[0][length - 1] >= 0);
    }

    /**
     * 递归解法
     */
    public boolean PredictTheWinner2(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }
    public int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }
}
