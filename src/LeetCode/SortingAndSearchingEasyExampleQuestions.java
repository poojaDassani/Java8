package LeetCode;

import java.util.Arrays;

public class SortingAndSearchingEasyExampleQuestions {
    static int bad = 3;
    public static void main(String[] args) {
        int n = 3, m = 3;
        int[] nums1 = new int[] {4,5,6,0,0,0}, nums2 = new int[] {1,2,3};
//        int badVersion = firstBadVersion(n);
//        if(badVersion == bad)
//            System.out.println("found correctly");
//        else
//            System.out.println("Not found correct first bad version");

        merge(nums1,m,nums2,n);

    }

    public static int firstBadVersion(int n) {
        return divideAndSearch(1,n);

    }

    private static int divideAndSearch(int start, int end) {
        if (start > end) {
            return -1;
        }
        int midPoint = start + (end - start) / 2;
        if (isBadVersion(midPoint)) {
            int leftResult = divideAndSearch(start, midPoint - 1);
            return (leftResult != -1) ? leftResult : midPoint;
        } else {
            return divideAndSearch(midPoint + 1, end);
        }
    }


    static Boolean isBadVersion(int version){
        return version == bad;
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length; i >= 0; i++) {

        }
    }
}
