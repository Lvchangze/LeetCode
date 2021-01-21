package Array;

public class P38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        String str = countAndSay(n - 1);
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                res.append(count).append(str.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        return res.toString();
    }
}
