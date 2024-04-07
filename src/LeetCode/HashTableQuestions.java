package LeetCode;

import java.util.*;

public class HashTableQuestions {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Arrays.stream(intersection(nums1,nums2)).forEach(System.out::println);

        int n = 19;
        System.out.println(isHappy(n));

        String s = "badc", t = "baba";
        System.out.println(isIsomorphic(s,t));

        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"}, list2 = {"KFC","Shogun","Burger King"};
        Arrays.stream(findRestaurant(list1,list2)).forEach(System.out::println);

        int k = 2;
        int[] nums3 = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums3,k));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i : nums1){
            map1.add(i);
        }

        for (int i : nums2){
            if(map1.contains(i))
                result.add(i);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isHappy(int n) {
        int iterations = n;
        HashSet<Long> result = new HashSet<>();
        for (int i = 1; i <= iterations; i++) {
            int remaining;
            int sum = 0;
            while(n>0){
                remaining = n%10;
                sum += remaining * remaining;
                n=n/10;
            }
            if(sum == 1){
                return true;
            }

            if(!result.contains((long)sum)){
                result.add((long)sum);
            }else {
                return false;
            }

            n = sum;
        }

        return false;
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;

        HashMap<Character,Character> characterHashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(!characterHashMap.containsKey(s.charAt(i))){
                if (characterHashMap.containsValue(t.charAt(i))){
                    char value = t.charAt(i);
                    char key =  characterHashMap.entrySet().stream().filter(v -> Objects.equals(v.getValue(), value)).map(Map.Entry::getKey).findFirst().get();
                    if(key != s.charAt(i))
                        return false;
                }
                characterHashMap.put(s.charAt(i), t.charAt(i));
            }else if(characterHashMap.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }
        }

        //second way
        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (!sToT.containsKey(sChar) && !tToS.containsKey(tChar)) {
                sToT.put(sChar, tChar);
                tToS.put(tChar, sChar);
            } else {
                if (sToT.getOrDefault(sChar, tChar) != tChar || tToS.getOrDefault(tChar, sChar) != sChar) {
                    return false;
                }
            }
        }

      return true;
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        HashMap<String,Integer> commonStrings = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i],i);
        }

        int minimumIndex = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if(hashMap.containsKey(s)){
                hashMap.put(s,hashMap.getOrDefault(s,0)+i);
                int value = hashMap.get(s);
                commonStrings.put(s,value);
                if(minimumIndex >= value){
                    minimumIndex = value;
                }
            }
        }

        Iterator<Map.Entry<String, Integer>> iterator = commonStrings.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() != minimumIndex) {
                iterator.remove();
            }
        }

        return commonStrings.keySet().stream().map(String::valueOf).toArray(String[]::new);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if(hashMap.containsKey(key)){
                int value = hashMap.get(key);
                if(i - value <= k)
                    return true;
                else
                    hashMap.put(key,i);
            }else{
                hashMap.put(key,i);
            }
        }
        return false;
    }

    class MinStack {

        Stack<Integer> stack;
        public MinStack() {
            this.stack = new Stack();
        }

        public void push(int val) {
            stack.push(val);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
          int min = Integer.MAX_VALUE;
          for (Integer values : stack) {
            if(min >= values)
                min = values;
          }
            return min;
        }
    }
}
