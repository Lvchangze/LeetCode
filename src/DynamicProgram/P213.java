package DynamicProgram;

public class P213 {
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length ==0){
            return 0;
        } else
            if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (length == 3) {
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        } else {//length>=4

            int[] subNums1 = new int[length - 1];//前n-1个
            for (int i = 0; i < length - 1; i++) {
                subNums1[i] = nums[i];
            }
            int[] sum1 = new int[length - 1];
            sum1[0]=subNums1[0];
            sum1[1]=subNums1[1];
            sum1[2]=subNums1[2]+sum1[0];
            for (int i= 3;i<length-1;i++){
                sum1[i]=subNums1[i]+Math.max(sum1[i-2],sum1[i-3]);
            }

            int[] subNums2 = new int[length - 1];//后n-1个
            for (int i = 1; i < length; i++) {
                subNums2[i - 1] = nums[i];
            }
            int[] sum2 = new int[length - 1];
            sum2[0]=subNums2[0];
            sum2[1]=subNums2[1];
            sum2[2]=subNums2[2]+sum2[0];
            for (int i= 3;i<length-1;i++){
                sum2[i]=subNums2[i]+Math.max(sum2[i-2],sum2[i-3]);
            }
            return Math.max(Math.max(sum1[length-3],sum1[length-2]),Math.max(sum2[length-3],sum2[length-2]));
        }
    }

    public static void main(String [] args){
        int[] nums = {};
        System.out.println(rob(nums));
    }
}
