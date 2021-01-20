package Array;

public class P33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            }
            if (nums[mid] >= nums[left]) {//mid在递增序列中
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else{//mid还在递减序列中
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }

    /**
     *         int n = nums.length;
     *         if (n == 0) {
     *             return -1;
     *         }
     *         if (n == 1) {
     *             return nums[0] == target ? 0 : -1;
     *         }
     *         int l = 0, r = n - 1;
     *         while (l <= r) {
     *             int mid = (l + r) / 2;
     *             if (nums[mid] == target) {
     *                 return mid;
     *             }
     *             if (nums[0] <= nums[mid]) {//mid还在递增序列中
     *                 if (nums[0] <= target && target < nums[mid]) {
     *                     r = mid - 1;
     *                 } else {
     *                     l = mid + 1;
     *                 }
     *             } else {//mid在递减序列中
     *                 if (nums[mid] < target && target <= nums[n - 1]) {
     *                     l = mid + 1;
     *                 } else {
     *                     r = mid - 1;
     *                 }
     *             }
     *         }
     *         return -1;
     */
}
