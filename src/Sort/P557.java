package Sort;

import java.util.*;

public class P557 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0)
            return s;
        String result = "";
        for(int i = 0 ; i<strings.length-1;i++){
            result+=reverseOneWord(strings[i])+" ";
        }
        result += reverseOneWord(strings[strings.length-1]);
        return result;
    }

    public String reverseOneWord(String s) {
        char[] chars = s.toCharArray();
        String result = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            result+=chars[i]+"";
        }
        return result;
    }
}
