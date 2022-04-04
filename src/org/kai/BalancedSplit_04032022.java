package org.kai;


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//
/*
 * Start 4/3/2022 9:49pm. 10:03pm. 14mins
 * Given an array of integers (which may include repeated integers), determine if there's a way to split the array into
 * 2 subsequences A and B such that the sum of the integers in both arrays i the same, and all of the integers in A are
 * strictly smaller than all of the integers in B.
 * Note: strickly smaller denotes that every integers in A must be less than, and not equal to, every integer in B.
 * Input integers in arrays are 0 to 1billion.
 *
*/
public class BalancedSplit_04032022 {

    // Examples

    public static void main (String[] args) {
        BalancedSplit_04032022 me = new BalancedSplit_04032022();

        int[] testcase1a = {1,5,7,1}; // true 1,1,5, 7
        int[] testcase2a = {12, 7, 6, 7, 6}; // false
        int[] testcase3a = {2, 1, 2, 5}; // true; 1,2,2 and 5
        int[] testcase4a = {3,6,3,4,4}; // false

        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.balancedSplitExists(testcase1a)); // 3
        System.out.println(me.balancedSplitExists(testcase2a)); // 3
        System.out.println(me.balancedSplitExists(testcase3a)); // 3
        System.out.println(me.balancedSplitExists(testcase4a)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * sum up the numbers.
     * put the numbers into a treeMap of values and occurences.
     * move the higher numbers into a second, and if we see balance return true;
     * if sum of the larger numbers > sum of remaining numbers, false
     */
    boolean debug = true;
    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        long total = Arrays.stream(arr).sum(), sumLarge = 0;

        //put array into TreeMap
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i: arr) {
            tm.put(i, tm.getOrDefault(i, 0)+1);
        }


        while (sumLarge*2 < total) {
            if (debug)
                System.out.println("TreeMap: " + tm);
            Map.Entry<Integer, Integer> en = tm.pollLastEntry();
            sumLarge += en.getKey() * en.getValue();
        }
        if (debug)
            System.out.println("total: " + total + " sumLarge " + sumLarge);
        return sumLarge*2 == total; // return true if balanced
    }





}