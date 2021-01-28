package Array;

import java.util.*;

public class P724 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;    // 中心索引左半和
        int rightSum = 0;   // 中心索引右半和
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum + nums[i];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }
}
