package BackTrack;

import java.util.*;

public class P17 {
    Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    String digits;
    List<String> result;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrack(0, new StringBuffer());
        return result;
    }

    public void backtrack(int index, StringBuffer combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {//递归回溯
            combination.append(letters.charAt(i));
            backtrack(index + 1, combination);
            combination.deleteCharAt(index);
        }
    }
}
