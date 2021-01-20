package Number;

import java.util.*;

public class P15 {
    //排序+双指针
    List<List<Integer>> result;

    public List<List<Integer>> threeSum(int[] nums, int target) {
        result = new ArrayList<>();
        if (nums.length < 4)
            return result;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[first], nums[second], nums[third])));
                    while (second < third && nums[second] == nums[++second]) ;
                    while (second < third && nums[third] == nums[--third]) ;
                }else if (sum > target){
                    while (second < third && nums[third] == nums[--third]) ;
                }else {
                    while (second < third && nums[second] == nums[++second]) ;
                }
            }
        }
        return result;
    }
}
