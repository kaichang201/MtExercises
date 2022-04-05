package org.kai;


import java.util.HashMap;

//
/*
 * Start 4/4/2022 8:00pm. 8:06pm. 6mins
 * Given 2 arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
 * Input
 * All integers in aray are in range 0 to 1billion.
 *
*/
public class ReverseToMakeEqual_04042022 {

    // Examples

    public static void main (String[] args) {
        ReverseToMakeEqual_04042022 me = new ReverseToMakeEqual_04042022();

        int[] testcase1a = {1,2,3,4};
        int[] testcase1b = {1,4,3,2};

        int[] testcase2a = {1, 2, 3, 4};
        int[] testcase2b = {1, 4, 3, 3};


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.areTheyEqual(testcase1a, testcase1b)); // true
        System.out.println(me.areTheyEqual(testcase2a, testcase2b)); // false


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Seems like so long as the two arrays have the same numbers, there is always a way to make them equal.
     */
    boolean areTheyEqual(int[] array_a, int[] array_b) {
        HashMap<Integer, Integer> m = new HashMap<>();

        if (array_a.length != array_b.length)
            return false;

        // add a
        for (int i: array_a)
            m.put(i, m.getOrDefault(i,0)+1);

        // remove b
        for (int i: array_b) {
            if (!m.containsKey(i) || m.get(i) == 0)
                return false;
            m.put(i, m.get(i) - 1);
        }
        return true;

    }




}