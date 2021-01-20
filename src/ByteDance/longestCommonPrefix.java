package ByteDance;

import java.util.HashSet;
import java.util.Set;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        for (String s : strs) {
            if (s.length() == 0)
                return "";
        }
        //找到最短的字符串
        String shortestString = strs[0];
        for (String s : strs) {
            if (s.length() <= shortestString.length())
                shortestString = s;
        }
        //开始找公共前缀
        String common = "";
        for (int i = 0; i < shortestString.length(); i++) {
            String test = shortestString.substring(0, i + 1);
            for (String str : strs) {
                if (!str.startsWith(test)) {
                    return common;
                }
            }
            common = test;
        }
        return common;
    }
}
