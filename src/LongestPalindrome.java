import java.util.HashMap;

/**
 * Created by prasanthnair on 10/27/16.
 */
/*
https://leetcode.com/problems/longest-palindrome/

409. Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome extends ASolution {
    @Override
    void runSolution() {

    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        boolean isCount1Added = false;
        int palinCount = 0;
        for (char c : s.toCharArray()) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, 0);
            }
            int count = charMap.get(c);
            count++;
            charMap.put(c, count);
        }
        for (char c : charMap.keySet()) {
            if (charMap.get(c) == 1 && !isCount1Added) {
                palinCount++;
                isCount1Added = true;
            }
        }
        for (char c : charMap.keySet()) {
            if (charMap.get(c) > 1) {
                int charcount = charMap.get(c);
                if (charcount % 2 == 0) {
                    palinCount += charcount;
                } else {
                    if (!isCount1Added) {
                        palinCount += charcount;
                        isCount1Added = true;
                    } else {
                        palinCount += charcount - 1;
                    }
                }
            }
        }
        return palinCount;
    }
}
