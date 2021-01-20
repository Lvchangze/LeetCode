package Array;

import java.util.*;

public class P35 {
    public int searchInsert(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            if (list.contains(target))
                return i;
        }
        list.add(target);
        Collections.sort(list);
        return list.indexOf(target);
    }
}
