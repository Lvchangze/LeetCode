package Array;

import java.util.*;

public class P4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Double> arrayList = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 <= nums1.length - 1 && p2 <= nums2.length - 1) {
            if (nums1[p1] <= nums2[p2]) {
                arrayList.add((double) nums1[p1]);
                p1++;
            } else {
                arrayList.add((double) nums2[p2]);
                p2++;
            }
        }
        if (p1 == nums1.length) {
            for (int i = p2; i < nums2.length; i++) {
                arrayList.add((double) nums2[i]);
            }
        } else {
            for (int i = p1; i < nums1.length; i++) {
                arrayList.add((double) nums1[i]);
            }
        }
        if (arrayList.size() % 2 == 0)
            return (arrayList.get(arrayList.size() / 2) + arrayList.get(arrayList.size() / 2 - 1)) / 2;
        else {
            return arrayList.get(arrayList.size() / 2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {2, 3, 4};
        findMedianSortedArrays(nums1, nums2);
    }
}