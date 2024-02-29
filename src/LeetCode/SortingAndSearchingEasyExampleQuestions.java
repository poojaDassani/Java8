package LeetCode;

public class SortingAndSearchingEasyExampleQuestions {
    static int bad = 3;
    public static void main(String[] args) {
        int n = 5;
        int badVersion = firstBadVersion(n);
        if(badVersion == bad)
            System.out.println("found correctly");
        else
            System.out.println("Not found correct first bad version");
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
}
