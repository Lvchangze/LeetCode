package String;

public class P424 {
    private int[] map = new int[26]; //存储当前窗口中各个字母的出现次数

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        //保存滑动窗口内相同字母出现次数的历史最大值,
        // 通过判断窗口宽度(right-left+1)是否大于historyCharMax+K来决定窗口是否做滑动，否则窗口就扩张
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
