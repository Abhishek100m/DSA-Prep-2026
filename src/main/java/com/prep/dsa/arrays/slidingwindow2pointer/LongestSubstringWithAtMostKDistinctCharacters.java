package com.prep.dsa.arrays.slidingwindow2pointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Longest Substring With At Most K Distinct Characters

Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.


Example 1

Input : s = "aababbcaacc" , k = 2

Output : 6

Explanation : The longest substring with at most two distinct characters is "aababb".

The length of the string 6.

Example 2

Input : s = "abcddefg" , k = 3

Output : 4

Explanation : The longest substring with at most three distinct characters is "bcdd".

The length of the string 4.

Now your turn!

Input : s = "abccab" , k = 4

Constraints

1 <= s.length <= 105
1 <= k <= 26




* */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String[] testcases = {"aababbcaacc","abcddefg", "abccab"};
        int[] k_s = {2,3,4};
        for(int i=0;i<k_s.length;i++){
            // return brute(s, k);
            System.out.println("Output of testcase "+testcases[i]+" "+k_s[i]+" is : "+ optimal(testcases[i], k_s[i]) );
        }

    }
    private static int brute(String s, int k){
        int n = s.length(), maxLen = 0;
        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(s.charAt(j));
                if(set.size()>k){
                    break;
                }
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    public static int optimal(String s, int k) {
        // Edge case
        if (k == 0 || s.length() == 0) return 0;

        // Frequency map to track characters
        Map<Character, Integer> freq = new HashMap<>();

        // Initialize sliding window pointers
        int left = 0;
        int maxLen = 0;

        // Loop through string
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window if more than k distinct chars
            if (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            // Update maxLen
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
/*
*  Intusion same as Fruits into basket question, only with 2 basket replaced with k
* */



