package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayEasyExampleQuestions {
    public static void main(String[] args) {
        int[] num = new int[]{3,2,4};
        int[] num2 = new int[]{1,2,2,3};
        char[][] board = {
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','9','.','.','.','.','.','.','1'},
                {'8','.','.','.','.','.','.','.','.'},
                {'.','9','9','3','5','7','.','.','.'},
                {'.','.','.','.','.','.','.','4','.'},
                {'.','.','.','8','.','.','.','.','.'},
                {'.','1','.','.','.','.','4','.','9'},
                {'.','.','.','5','.','4','.','.','.'}
        };

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // remove duplicate
        //System.out.println(removeDuplicates(num));

        //Time to sell and buy stocks
        //System.out.println(maxProfit(num));

        //Rotate Array
        //rotate(num,2);

        //contains duplicate
        //System.out.println(containsDuplicate(num));

        //single number
        //System.out.println(singleNumber(num));

        //Intersection of two array
        //Arrays.stream(intersect(num,num2)).forEach(System.out::println);

        // Plus One
        //Arrays.stream(plusOne(num)).forEach(System.out::println);

        // Move Zeros
        //moveZeroes(num);

        // Two Sum
        //Arrays.stream(twoSum(num, 6)).forEach(System.out::println);

        // Valid Sudoku
        //System.out.println(isValidSudoku(board));

        //Rotate Image
        rotate(matrix);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void rotate(int[] nums, int k) {
//        one way
        int[] tempArray = new int[nums.length];
        int count = 0;
        int n = nums.length;
        k = k % n;
        for (int i = nums.length-k; i<= nums.length-1; i++){
            tempArray[count] = nums[i];
            count++;
        }
        for (int i = 0; i<  nums.length - k; i++){
            tempArray[count] = nums[i];
            count++;
        }
        Arrays.stream(tempArray).forEach(System.out::println);

//        second way
        reverse(nums, 0,n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k,n-1);
        Arrays.stream(nums).forEach(System.out::println);

    }

    // Helper function to reverse a portion of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        // one way
        //int[] num = Arrays.stream(nums).distinct().toArray();
        //return num.length != nums.length;

        // second way
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(integers));
        return nums.length != integerSet.toArray().length;
    }

    public static int singleNumber(int[] nums) {
        // first method
        int n = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j : nums) {
            hashMap.compute(j, (key, value) -> (value == null) ? 1 : value + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if(entry.getValue() == 1){
                n = entry.getKey();
            }
        }
        // return n;

        // second method
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // one way
        int[] biggerArray = (nums1.length > nums2.length) ? nums1 : nums2;
        int[] shorterArray = (nums1.length > nums2.length) ? nums2 : nums1;
        List<Integer> arrayList = Arrays.stream(shorterArray)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> result = new ArrayList<>();
        for (int k : biggerArray) {
            for (int j = 0; j < arrayList.size(); j++) {
                int n = arrayList.get(j);
                if (k == n) {
                    result.add(n);
                    arrayList.remove(j);
                    break;
                }
            }
        }
        //return result.stream().mapToInt(Integer::intValue).toArray();

        //second way
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : biggerArray) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> intersection = new ArrayList<>();
        for (int num : shorterArray) {
            if (count.containsKey(num) && count.get(num) > 0) {
                intersection.add(num);
                count.put(num, count.get(num) - 1);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void moveZeroes(int[] nums) {
        // brute force approach
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && i < nums.length -1){
                for (int j = i+1; j < nums.length ; j++) {
                    if(nums[j] > 0){
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
        // Optimized solution
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                left = i;
                break;
            }
        }
    if(left != -1 && left < nums.length-1) {
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int targetLeft = target - nums[i];
            if(hashMap.containsKey(targetLeft))
                return new int[]{hashMap.get(targetLeft),i};
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static boolean isValidSudoku(char[][] board) {
        // Validate rows
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }

        // Validate columns
        for (int j = 0; j < 9; j++) {
            if (!isValidColumn(board, j)) {
                return false;
            }
        }

        // Validate 3x3 sub-boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubBox(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int j = 0; j < 9; j++) {
            char digit = board[row][j];
            if (digit != '.' && seen[digit - '1']) {
                return false;
            }
            if (digit != '.') {
                seen[digit - '1'] = true;
            }
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char digit = board[i][col];
            if (digit != '.' && seen[digit - '1']) {
                return false;
            }
            if (digit != '.') {
                seen[digit - '1'] = true;
            }
        }
        return true;
    }

    private static boolean isValidSubBox(char[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                char digit = board[i][j];
                if (digit != '.' && seen[digit - '1']) {
                    return false;
                }
                if (digit != '.') {
                    seen[digit - '1'] = true;
                }
            }
        }
        return true;
    }

    // another method
//    public static boolean isValidSudoku(char[][] board) {
//        Set<Character>[] rows = new HashSet[9];
//        Set<Character>[] cols = new HashSet[9];
//        Set<Character>[] boxes = new HashSet[9];
//
//        for (int i = 0; i < 9; i++) {
//            rows[i] = new HashSet<>();
//            cols[i] = new HashSet<>();
//            boxes[i] = new HashSet<>();
//        }
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                char digit = board[i][j];
//                if (digit != '.') {
//                    if (!rows[i].add(digit) || !cols[j].add(digit) || !boxes[(i / 3) * 3 + j / 3].add(digit)) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
//    }

//    public static void rotate(int[][] matrix) {
//        int[][] reversed = new int[matrix.length][matrix.length];
//        for (int col = 0; col < matrix.length; col++) {
//            int index = matrix.length -1;
//            for (int i = 0; i < matrix.length; i++) {
//                reversed[col][i] = matrix[index][col];
//                index--;
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            System.arraycopy(reversed[i], 0, matrix[i], 0, matrix.length);
//
//        }
//        System.out.println(Arrays.deepToString(matrix));
//
//    }

    // another optimized method to rotate
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

}
