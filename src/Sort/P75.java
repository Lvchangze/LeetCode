package Sort;

public class P75 {
    public void sortColors(int[] nums) {
        int length = nums.length;
        boolean needNextPass = true;
        for (int k = 1; k < length && needNextPass; k++) {
            //array may be sorted and next pass is not needed
            needNextPass = false;
            for (int i = 0; i < length - k; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    needNextPass = true;
                }
            }
        }
    }

    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
