package com.prep.dsa.arrays.slidingwindow2pointer;

import java.util.HashMap;
import java.util.Map;

/*
424. Longest Repeating Character Replacement

You are given a string s and an integer k.
 You can choose any character of the string and change it to any other uppercase English character.
 You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing
 the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:
1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length



* */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String[] testcases = {"ABAB", "AABABBA", "ABASSYDDYSSB"};
        int[] k_s = {2, 1, 5};
        for(int i=0;i<testcases.length;i++){
            System.out.println("For test case "+ testcases[i]
                    +" and k - "+k_s[i]+" and answer is : "+ optimal(testcases[i], k_s[i]));
        }
    }
    private static int brute(String s, int k){
        int maxLen = 0, n= s.length(), maxFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                char ch =s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                maxFrequency = Math.max(maxFrequency, map.get(ch));
                int freq =  j-i+1-maxFrequency;
                if(freq<= k){
                    maxLen = Math.max(maxLen, j-i+1);
                }else break;
            }
            map.clear();
            maxFrequency = 0;
        }
        return maxLen;
    }
    /* main Idea is:
       we need to replace minimum char to make string with all same char
   for that:- we need to find maxFrequency character because so for minimum replacement
               should be other then maxFreq character,
               so we should count all char freq expect maxFreq character,
               that value should be under or equal to k then we can be able to make
               string with all same character.
               and if we remove maxFreq from length of our substring then we'll get
               distinct character count be required to make string with allSameCharacter.
   */
    private static int optimal(String s, int k){
        int l=0, n=s.length(), maxFrequency = 0, maxLen = 0;
        int[] hash = new int[256];
        for(int r=0; r<n; r++){
            char ch =s.charAt(r);
            hash[ch]++;
            maxFrequency = Math.max(maxFrequency, hash[ch]);
            if((r-l+1 - maxFrequency) > k){
                hash[s.charAt(l)]--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}

