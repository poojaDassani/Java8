package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringEasyExampleQuestions {
    public static void main(String[] args) {
        char[] chars = new char[]{'h','e','l','l','o'};
        int no = 1534236469;
        String s = "sadtosad", t = "sad";
        String palindrome  = "A man, a plan, a canal: Panama";
        String atoi = "18446744073709551617";
        String[] strs = new String[]{"car", "racecar", "flight"};
        // Reverse String
        //reverseString(chars);

        // Reverse Int
        //System.out.println(reverse(no));

        //First Unique Character in a String
        //System.out.println(firstUniqChar(s));

        //Valid Anagram
        //System.out.println(isAnagram(s,t));

        //Valid Palindrome
        //System.out.println(isPalindrome(palindrome));

        //String to Integer (atoi)
        //System.out.println(myAtoi(atoi));

        //Implement strStr()
        //System.out.println(strStr(s,t));

        //Longest Common Prefix
        System.out.println(longestCommonPrefix(strs));
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
      HashMap<Character,Integer> sHashMap = new HashMap<>();
      for(char c : s.toCharArray()){
          sHashMap.put(c, sHashMap.getOrDefault(c,0)+1);
        }

      for (char c : t.toCharArray()){
          if(sHashMap.containsKey(c) && sHashMap.get(c) > 0){
              sHashMap.put(c,sHashMap.getOrDefault(c,0)-1);
          }else
              return false;
      }

      //return true;

      // Second Way
        if (s.length() != t.length()) {
            return false;
        }
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        Arrays.sort(charArrayS);
        Arrays.sort(charArrayT);
        return Arrays.equals(charArrayS, charArrayT);
    }

    public static boolean isPalindrome(String s) {
        String regex = "[^a-z0-9]";
        String sentence = s.toLowerCase().replaceAll(regex,"");
        int left = 0;
        int right = sentence.length()-1;
        while(left<right){
            if(sentence.charAt(left)!=sentence.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int myAtoi(String s) {
        long result = 0;
        int sign = 1;
        s = s.trim().replaceAll("^\\s+", "");
        char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if ((c == '-' || c == '+') && i == 0) {
                sign = c == '-' ? -1 : 1;
                continue;
            }
            if (Character.isDigit(c)) {
                if (result != 0)
                    result *= 10;
                result += Character.getNumericValue(c);
                if((result < Integer.MIN_VALUE || result > Integer.MAX_VALUE))
                    break;
            } else
                break;
        }
        return (int) ((result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE) ? result * sign : (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE ));
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;
        if(haystack.contains(needle)){
            index = haystack.indexOf(needle);
        }
        return index;
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder common = new StringBuilder();
        int count = strs[0].length();
        boolean commonPresent = false;
        for (String s : strs){
            if(count > s.length()) {
                count = s.length();
            }
        }
        if(count == 0)
            return "";
        for (int i = 0; i < count; i++) {
            char alphabet = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                    if(strs[j].charAt(i) == alphabet){
                        commonPresent = true;
                    }else{
                        commonPresent = false;
                        break;
                    }
            }
            if(commonPresent)
                common.append(alphabet);
            else
                return common.toString();
        }

        return common.toString();
    }
}
