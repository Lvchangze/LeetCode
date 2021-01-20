package Number;

import java.util.*;

public class P16 {
    //排序+双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentMin = Integer.MAX_VALUE;
        int result = 0;
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    while (second < third && nums[third] == nums[--third]) ;
                } else {
                    while (second < third && nums[second] == nums[++second]) ;
                }
                if (Math.abs(target - sum) < currentMin) {
                    currentMin = Math.abs(target - sum);
                    result = sum;
                }
            }
        }
        return result;
    }
}
