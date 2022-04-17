package org.kai;


import java.util.Arrays;

//
/*
 * Start 4/16/2022 8:10pm 8:58pm. 48mins
 * You are given 2 strings s and t. You can select and substring of string s and rearrange the letters of the selected substring.
 * Determine the min length of substring s such that string t is a substring of the selected substring
 * s and t are non-empty that contain less than 1mm characters each
 * if not possible return -1
*/
public class MinimumLengthSubstring_04162022 {

    // Examples

    public static void main (String[] args) {
        MinimumLengthSubstring_04162022 me = new MinimumLengthSubstring_04162022();

        String testcase1s = "dcbefebce";
        String testcase1t = "fd";  // 5

        String testcase2s = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String testcase2t = "cbccfafebccdccebdd";  // -1

        String testcase3s = "dcbefebdce";
        String testcase3t = "fd";  // 4

        String testcase4s = "dcbeebdcef";
        String testcase4t = "fd";  // 4

        String testcase5s = "dcbeebcef";
        String testcase5t = "fd";  // 9


        long startTime = System.currentTimeMillis();

        // Strategy 1
        System.out.println(me.minLengthSubstring(testcase1s, testcase1t)); // 5
        System.out.println(me.minLengthSubstring(testcase2s, testcase2t)); // -1
        System.out.println(me.minLengthSubstring(testcase3s, testcase3t)); // 4
        System.out.println(me.minLengthSubstring(testcase4s, testcase4t)); // 4
        System.out.println(me.minLengthSubstring(testcase5s, testcase5t)); // 9



        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * convert t into array of letter counts.
     * walk s left and right.  whenever array has no positives, check maxLEngth
     */
    boolean debug = true;
    int[] lettersOfT;
    boolean[] hasLettersOfT;
    int minLengthSubstring(String s, String t) {
        // Write your code here

        int left =0, right=0;
        int maxLength =Integer.MAX_VALUE;
        lettersOfT = new int[26];
        hasLettersOfT = new boolean[26];

        for (char c: t.toCharArray()) {
            lettersOfT[c - 'a']++;
            hasLettersOfT[c - 'a'] = true;
        }

        while (right < s.length()) {
            char r = s.charAt(right);
            lettersOfT[r-'a']--;
            while (hasNoPositives(lettersOfT)) {
                maxLength = Math.min(maxLength, (right-left)+1);
                if (debug)
                    System.out.println(" left: " + left + " right: " + right + " maxLength: " + maxLength + " lettersOfT: " + Arrays.toString(lettersOfT));
                char l = s.charAt(left++);
                if (hasLettersOfT[l-'a'])
                    lettersOfT[l-'a']++;
            }
            right++;
        }

        return maxLength == Integer.MAX_VALUE ? -1 : maxLength;
    }

    boolean hasNoPositives(int[] ia ) {
        for (int i: ia)
            if (i>0)
                return false;
        return true;
    }




}