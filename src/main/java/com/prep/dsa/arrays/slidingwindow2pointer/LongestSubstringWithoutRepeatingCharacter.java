package com.prep.dsa.arrays.slidingwindow2pointer;

import java.util.Arrays;

/*
3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
*/
public class LongestSubstringWithoutRepeatingCharacter {//l=4
    
    public static void main(String[] args) {//c=0,a=5,d=2,b=3,z=4,
        String[] testcases = {"abcabcbb", "bbbbb", "pwwkew", "cadbzabcd"};
        for(String test: testcases){    //                        l
            System.out.println("Answer for this "+ test +" : "+ solve(test));
        }
    }
    /*
    *  BruteForce approach -
    *       find all substring i=0 and j=i
    *           and with the help of hash find longest substring.
    *       O(n*n)
    * */
    private static int solve(String s) {
        int l=0,r=0,n=s.length(),maxLen=0;
        int hash[] = new int[265];
        Arrays.fill(hash, -1);
        while(r<n){
            char rCh = s.charAt(r);
            if(hash[rCh]!=-1 && hash[rCh]>=l){
                l = hash[rCh]+1;
                l++;
            }
            hash[rCh] = r;
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
/*
‘Longest Substring Without Repeating Characters’ ke optimal approach ka note ye raha:

### **Intuition (Soch):**
Brute force mein hum har substring check karte the, jisme time bahut lagta tha.
 Optimal solution ke liye hum **Sliding Window aur Two Pointer** ka use karte hain.
 Hum ek aisi 'window' banate hain jisme sirf unique characters hon.
  Jaise hi koi character repeat hota hai, hum apni window ki starting (`Left` pointer) ko
  us purane character ke agle index par shift kar dete hain.

### **Approach (Kaam kaise karta hai):**
1. **Data Structure:** 256 size ka ek `hash array` (ya Map) le lo, jisme har character ka last dekha gaya index store hoga. Shuruat mein sabko `-1` set kar do.
2. **Pointers:** Do pointers lo: `Left` aur `Right` (dono 0 par).
3. **Sliding Window Logic:**
   - `Right` pointer ko string mein aage badhao.
   - Agar `s[Right]` character pehle aa chuka hai aur uska purana index hamari current window (`Left` se `Right`) ke beech mein hai, to `Left` ko us purane index ke ek step aage (`hash[s[Right]] + 1`) shift kar do.
   - Har step par, window ki length (`Right - Left + 1`) calculate karo aur `Max length` ko update karo.
   - Last mein, `hash[s[Right]]` mein current `Right` index store kar do.

### **Complexity:**
- **Time Complexity:** $O(N)$ - Kyunki `Right` pointer puri string par sirf ek baar traverse karta hai.
- **Space Complexity:** $O(256) \approx O(1)$ - Kyunki hash array ka size fixed hai.
 */
}
