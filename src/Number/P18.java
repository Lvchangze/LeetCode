package Number;

import java.util.*;

public class P18 {
    //排序+双指针
    List<List<Integer>> result;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        result = new ArrayList<>();
        if (nums.length < 4)
            return result;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                int third = second + 1;
                int forth = nums.length - 1;
                while (third < forth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[forth];
                    if (sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[first], nums[second], nums[third], nums[forth])));
                        while (third < forth && nums[forth] == nums[--forth]);
                        while (third < forth && nums[third] == nums[++third]);
                    } else if (sum > target) {
                        while (third < forth && nums[forth] == nums[--forth]);
                        //等价于
                        //while (third < forth && nums[forth] == nums[forth-1]){
                        //   forth--;
                        //}
                        //forth--;
                    } else {
                        while (third < forth && nums[third] == nums[++third]);
                        //等价于
                        //while (third < forth && nums[third] == nums[third+1]){
                        //   third++;
                        //}
                        //third++;
                    }
                }
            }
        }
        return result;
    }
}
