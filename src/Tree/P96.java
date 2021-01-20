package Tree;

public class P96 {
    //动态规划
    //假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
    //当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
    //同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
    //所以可得dp(n) = dp(0) * dp(n-1) + dp(1) * dp(n-2) + ... + dp(n-1) * dp(0)
    public int numTrees(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    //卡塔兰数
    //C(n+1) = [2(2n+1)/(n+2)]Cn
    public int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
