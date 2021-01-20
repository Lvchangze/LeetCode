package Greedy;

public class P376 {
    //我们维护一个变量 prevdiff ，它的作用是指示当前数字的序列是上升还是下降的。
    // 如果prevdiff>0 ，那么表示目前是上升序列，我们需要找一个下降的元素。因此，我们更新已找到的序列长度diff （nums[i]−nums[i−1]）为负数。
    // 如果prevdiff<0 ，那么表示目前是下降序列，我们就更新 diff （nums[i]−nums[i−1]）为正数。
    //当整个数组都被遍历后，我们得到了最终的结果，它就是最长摆动子序列的长度。
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = (prevdiff != 0 ? 2 : 1);
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }
}
