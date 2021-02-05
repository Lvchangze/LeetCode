package SlidWindow_DoublePointer;

public class P1208 {
    //双指针法
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        // 双指针
        int start = 0;
        int end = 0;
        int sum = 0;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        while (end < len) {
            // 窗口扩张
            sum += Math.abs(sc[end] - tc[end]);
            if (sum > maxCost) {
                // 窗口右移
                sum -= Math.abs(sc[start] - tc[start]);
                start++;
            }
            end++;
        }
        return end - start;
    }
}
