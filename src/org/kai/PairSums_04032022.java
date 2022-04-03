package org.kai;


import java.util.*;

//
/*
 * Start 4/3/2022 9:42am. 10:15am. 18+15 = 33mins
 * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum up to k.
 * If an interger appears in the list multiple times, each copy is considered to be different;.  that is two pairs are considered
 * different if 1 pair includes at least 1 array index which the other doesn't even if the values are different.
*/
public class PairSums_04032022 {

    // Examples

    public static void main (String[] args) {
        PairSums_04032022 me = new PairSums_04032022();

        int[] testcase1a = {1,2,3,4,3};
        int testcase1k = 6; // 2. 2+4 and 3+3

        int[] testcase2a = {1,5,3,3,3};
        int testcase2k = 6; // 4. 1,5, 3,3 3,3, 3,3

        int[] testcase3a = {3,3,3,3,3};
        int testcase3k = 6; // n*(n-1)/2 = 10


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.numberOfWays(testcase1a,testcase1k)); // 3
        System.out.println(me.numberOfWays(testcase2a,testcase2k)); // 3
        System.out.println(me.numberOfWays(testcase3a,testcase3k)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Count the frequency of each number
     * if k is even look for frequency of k/2. permutation is x^(count-2)
     * if pair's dont' equal, n*m.
     */
    int numberOfWays(int[] arr, int k) {
        Map<Integer, Integer> count = new TreeMap<>();
        int rv=0;

        // count the number of iterations
        for (int i: arr)
            count.put(i, count.getOrDefault(i,0)+1);

        if (k%2 == 0 && count.containsKey(k/2) && count.get(k/2) >=0) { // if k is even, and we have more than 2 of them.
            int countHalf = count.get(k/2);
            rv+= (countHalf * (countHalf-1)) / 2; // number of unique pairs in a set
        }


        for (Integer i: count.keySet()) { // only iterate through first half
            if (i >= k/2)
                break;
            if (count.containsKey(k-i))
                rv += count.get(i) * count.get(k-i);
        }
        return rv;

    }



}