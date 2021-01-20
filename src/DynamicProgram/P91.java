package DynamicProgram;

public class P91 {
    public static int numDecodings(String s) {
        char[] nums = s.toCharArray();
        int length = s.length();
        if (length==0)return 0;
        int [] dp = new int[length+1];
        dp[length] = 1;
        for (int i=length-1;i>=0;i--){
            if (nums[i] == '0'){
                dp[i]=0;
            }else if (i==length-1){
                dp[i] = dp[i+1];
            }
            else if ((nums[i]-'0')*10 + (nums[i+1]-'0') <= 26 ){
                dp[i] = dp[i+1]+dp[i+2];
            }else{
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    public static void main(String [] args){
        System.out.println(numDecodings("226"));
    }
}
