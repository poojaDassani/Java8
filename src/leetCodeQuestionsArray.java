import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class leetCodeQuestionsArray {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,1,2,3};
        int[] num2 = new int[]{1,2,2,3};

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

        //Intersection of two arrays
        Arrays.stream(intersect(num,num2)).forEach(System.out::println);
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
        int[] num = Arrays.stream(nums).distinct().toArray();
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
        for (int i = 0; i < nums.length; i++) {
            hashMap.compute(nums[i], (key, value) -> (value == null) ? 1 : value + 1);
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
        for (int i = 0; i < biggerArray.length; i++) {
            for (int j = 0; j < arrayList.size(); j++){
                int n = arrayList.get(j);
               if(biggerArray[i] == n){
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
}
