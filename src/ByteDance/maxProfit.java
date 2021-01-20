package ByteDance;

public class maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length<=1)
            return 0;
        if (prices.length == 2){
            if (prices[0]>=prices[1])
                return 0;
            else
                return prices[1]-prices[0];
        }
        int[] allMax = new int[prices.length];
        for (int i = 0; i < prices.length-1; i++) {
            int currentMax = Integer.MIN_VALUE;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]-prices[i]>currentMax){
                    currentMax = prices[j]-prices[i];
                }
            }
            allMax[i] = currentMax;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (allMax[i]>max){
                max = allMax[i];
            }
        }
        return Math.max(max, 0);
    }
}
