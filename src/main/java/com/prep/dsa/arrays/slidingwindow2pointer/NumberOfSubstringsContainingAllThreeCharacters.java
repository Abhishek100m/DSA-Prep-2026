package com.prep.dsa.arrays.slidingwindow2pointer;

import java.util.Arrays;

/*
1358. Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1


Constraints:

3 <= s.length <= 5 x 104
s only consists of 'a', 'b' or 'c' characters.
*
* */
public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println("Answer is :" +numberOfSubstrings(s));
    }
    public static int numberOfSubstrings(String s) {
        int l=0, r=0, n=s.length(), cnt= 0;
        int[] hash = new int[3];
        Arrays.fill(hash, -1);
        while(r<n){
            char ch = s.charAt(r);
            hash[ch-'a'] = r;
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1){
                cnt += 1+Math.min(hash[0], Math.min(hash[1], hash[2]));
            }
            r++;
        }
        return cnt;
    }
}
