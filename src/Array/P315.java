package Array;

import java.util.*;

public class P315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        int[] res = new int[length];
        for (int i = length -1 ; i >= 0;  i--) {
            int count = 0;
            for (int j = i+1 ; j < length;  j++ ) {
                if(nums[j] < nums[i]){
                    count++;
                }
                if(nums[i] == nums[j]){
                    count += res[j];
                    break;
                }
            }
            res[i] = count;
        }
        for (int i = 0 ; i< length;i++){
            result.add(res[i]);
        }
        return result;
    }
}
