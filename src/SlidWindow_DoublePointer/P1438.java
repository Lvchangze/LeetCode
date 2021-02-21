package SlidWindow_DoublePointer;

public class P1438 {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int res = 0;
        //记录当前窗口的最大值和最小值
        int curMax = nums[0];
        int curMin = nums[0];
        while (right < nums.length) {
            curMax = Math.max(curMax, nums[right]);
            curMin = Math.min(curMin, nums[right]);
            //如果满足条件那么窗口右边界扩张
            if (curMax - curMin <= limit) {
                right++;
            } else {
                //当不满足条件时窗口左边界收缩
                res = Math.max(right - left, res);
                left = right;
                curMax = nums[left];
                curMin = nums[left];
                //重新找到当前窗口的最大最小值
                while (Math.abs(nums[right] - nums[--left]) <= limit) {
                    curMin = Math.min(nums[left], curMin);
                    curMax = Math.max(nums[left], curMax);
                }
                left++;
                right++;
            }
        }
        return Math.max(right - left, res);
    }
}
