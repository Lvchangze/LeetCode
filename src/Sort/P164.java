package Sort;

import java.util.ArrayList;
import java.util.List;

public class P164 {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        int n = nums.length;
        int max = nums[0];
        //找出最大的数字
        for (int i = 1; i < n; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int m = max;
        int exp = 1;
        //一位一位的进行
        while (max > 0) {
            //将之前的元素清空
            for (int i = 0; i < 10; i++) {
                lists.set(i, new ArrayList<>());
            }
            //将数字放入对应的位置
            for (int i = 0; i < n; i++) {
                lists.get(nums[i] / exp % 10).add(nums[i]);
            }

            //将数字依次拿出来
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    nums[index] = lists.get(i).get(j);
                    index++;
                }

            }
            max /= 10;
            exp *= 10;
        }

        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > maxGap) {
                maxGap = nums[i + 1] - nums[i];
            }
        }
        return maxGap;
    }
}
