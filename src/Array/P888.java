package Array;

import java.util.*;

public class P888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = Arrays.stream(A).sum();
        int bSum = Arrays.stream(B).sum();
        int[] result = new int[2];
        if (aSum > bSum) {//A总和比B大
            int gap = (aSum - bSum) / 2;
            for (int i = 0; i < A.length; i++) {
                result[0] = A[i];
                for (int j = 0; j < B.length; j++) {
                    if (B[j] == A[i] - gap){
                        result[1] = B[j];
                        return result;
                    }
                }
            }
        } else {
            int gap = (bSum - aSum) / 2;
            for (int j = 0; j < B.length; j++) {
                result[1] = B[j];
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == B[j] - gap){
                        result[0] = A[i];
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /**
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
     */
}
