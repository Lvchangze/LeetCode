package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

public class P139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int max_length=0;//wordDict里最长的字符串的长度
        for(String temp:wordDict){
            max_length = Math.max(temp.length(), max_length);
        }

        //memo[i]表示字符串从第0位到第i-1位是否可以被成功地拆分
        boolean[] memo = new boolean[n + 1];//默认全为false
        memo[0] = true;

        for (int i = 1; i <= n; i++) {//写memo
            for (int j = i - 1; j >= 0 && max_length >= i - j; j--) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    public static void main(String [] args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        String s = "aaaaaaa";
        System.out.println(wordBreak(s,wordDict));
    }
}
