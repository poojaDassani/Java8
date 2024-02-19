package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringEasyExampleQuestions {
    public static void main(String[] args) {
        char[] chars = new char[]{'h','e','l','l','o'};
        int no = 1534236469;
        String s = "anagram", t = "nagaram";
        // Reverse String
        //reverseString(chars);

        // Reverse Int
        //System.out.println(reverse(no));

        //First Unique Character in a String
        //System.out.println(firstUniqChar(s));

        //Valid Anagram
        System.out.println(isAnagram(s,t));
    }
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length -1;
        while (start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        System.out.println(s);
    }

    public static int reverse(int x) {
        long no = 0;
        while(x != 0){
            no *= 10;
            no  += x%10;
            x = x/10;
        }
        return no > Integer.MIN_VALUE && no < Integer.MAX_VALUE ? (int) no : 0;
    }

    public static int firstUniqChar(String s) {
        int index = -1;
        HashMap<Character,Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i),charCount.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i = 0; i < s.length(); i++) {

        }
        for (Map.Entry<Character,Integer> entry : charCount.entrySet()){
            if(entry.getValue() == 1) {
                int i = s.indexOf(entry.getKey());
                if (index == -1)
                        index = i;
                    index = Math.min(index, i);
            }
        }
        return index;
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int diff = 0;
        for (int i = 0, j= 0; i < s.length(); i++, j++) {
            diff += s.charAt(i) - t.charAt(i);
        }
        return diff == 0;
    }
}
