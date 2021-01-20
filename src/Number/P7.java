package Number;

public class P7 {
    //检查溢出是关键
    //int最大为2147483647，最小为-2147483648
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE/ 10 && pop > 7)) //rev为正数时
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) //rev为负数时
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
