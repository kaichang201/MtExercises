package org.kai;


import java.util.*;

//
/*
 * Start 4/4/2022 9:56pm. 10:44pm. 48mins
 * Given two strings s and t of length N, find the max number of possible matching pairs in string s and t after
 * swapping exactly 2 characters with s.
 *
 * A swap is switching s[i] and s[j], where s[i] and s[j] denotes the chracters at i and j.  The matching pairs of the two strings are
 * defined as the nubmer of indices for which s[i] and t[i] are equal.
 * Input. s and t are strings of length N.  N is 2 to 1mm.
 *
 *
*/
public class MAtchingPairs_04042022 {

    // Examples

    public static void main (String[] args) {
        MAtchingPairs_04042022 me = new MAtchingPairs_04042022();

        String testcase1s = "abcd";
        String testcase1t = "adcb";  //4

        String testcase2s = "mno";
        String testcase2t = "mno"; // 1

        String testcase3s = "ono";
        String testcase3t = "ono"; // 3

        String testcase4s = "ono";
        String testcase4t = "ona"; // 1

        String testcase5s = "onoo";
        String testcase5t = "onao"; // 3

        String testcase6s = "onol";
        String testcase6t = "onal"; // 2

        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.matchingPairs(testcase1s, testcase1t)); // 4
        System.out.println(me.matchingPairs(testcase2s, testcase2t)); // 1
        System.out.println(me.matchingPairs(testcase3s, testcase3t)); // 3
        System.out.println(me.matchingPairs(testcase4s, testcase4t)); // 1
        System.out.println(me.matchingPairs(testcase5s, testcase5t)); // 3
        System.out.println(me.matchingPairs(testcase6s, testcase6t)); // 2


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * count the number of matches and number of mismatches.
     * if number of mismatches is 0 or 1
     *   - if the matches have a duplicate letter, then return the number of matches.
     *   - if the matches don't have a duplicate letter, then return the number of matches -2
     * if the number of mismatches is more than 1
     *   - look for cross-pairs.  if found, return matches+2. if not found, return matches
     *
     */
    boolean debug = true;
    int matchingPairs(String s, String t) {
        // Write your code here
        int misMatchCount=0, matchCount=0;
        List<Integer> misMatches = new ArrayList<>();
        int[] matches = new int[26];  // detect if matches have a duplicate letter

        for (int i=0; i<s.length(); i++) {
            int sChar = s.charAt(i)-'a', tChar = t.charAt(i)-'a';
            if (sChar == tChar) { // match
                matches[sChar]++;
                matchCount++;
            } else {  //mismatch
                misMatchCount++;
                misMatches.add(i);
            }
        }

        // if number of mismatches is 0 or 1
        if (misMatchCount <2) {
            if (debug)
                System.out.println(" misCount: " + misMatchCount+ " matchCount " +  matchCount + " matches: " + Arrays.toString(matches));
            for (int i=0; i<26; i++) {
                if (matches[i] > 1)
                    return matchCount;
            }
            return matchCount-( misMatchCount == 0 ? 2 : 1);  // if mismath is 1, then reduce matchcount by 1 by switching the mismatch. otherwise decrease by 2
        }

        // do N^2

        for (int i = 0; i< misMatches.size(); i++) {  // for this mismatch
            for (int j = i+1; j< misMatches.size(); j++ ) { // all subsequent mismatch
                int iIdx = misMatches.get(i), jIdx = misMatches.get(j);
                if (s.charAt(iIdx) == t.charAt(jIdx) && s.charAt(jIdx) == t.charAt(iIdx))  // found cross pair
                    return matchCount+2;
            }
        }
        return matchCount;


    }




}