package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DynamicProgrammingEasyExampleQuestions {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        int n = 4;
        System.out.println(climbStairs(n));

        int[] nums = {8,-19,5,-4,20};
        System.out.println(maxSubArray(nums));

        int[] houses = {1,2,0,2,9,1,2,11};
        System.out.println(rob(houses));
    }

//    public static int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < prices.length; i++) {
//            if(hashSet.add(prices[i])) {
//                for (int j = i + 1; j < prices.length; j++) {
//                    maxProfit = Math.max(prices[j] - prices[i], maxProfit);
//                }
//            }
//        }
//        return maxProfit;
//    }

    public static int maxProfit(int[] prices) {
        int mostProfit = 0;
        int length = prices.length;
        int lowest = prices[0];
        for (int x = 1; x < length; x++) {
            if (prices[x] < lowest) {
                lowest = prices[x];
            } else if (prices[x] - lowest > mostProfit) {
                mostProfit = prices[x] - lowest;
            }
        }

        return mostProfit;
    }


    public static int climbStairs(int n) {
        if(n == 1)
            return 1;
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            steps[i] = steps[i-2] + steps[i-1];
        }

        return steps[n-1];
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(num,sum+num);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static int rob(int[] nums) {

        int prevMax = 0;
        int currMax = 0;

        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + num, currMax);
            prevMax = temp;
        }

        return currMax;
    }
}
