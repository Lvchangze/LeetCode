package DynamicProgram;

import java.util.Scanner;

class P70 {//70

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int[] a = new int[n];
        a[0] = 1;
        if (n>=2) {
            a[1] = 2;
            for (int i = 2; i <= n - 1; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
        }
        return a[n-1];
    }
}