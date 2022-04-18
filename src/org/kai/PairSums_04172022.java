package org.kai;


import java.util.HashMap;
import java.util.Map;

//
/*
 * Start 4/17/2022 8:29pm 8:40pm. 11mins
  *Given list of n integers arr[0..n-1], determine the number of different pairs of elements within it which to sum to k
  * if an integer appears in the list multiple times, each copy is considered different.
  * n is 1 to 100,000
  * each value is 1 to 1 billion
  * k is in range of 1 to 1 billionf
 */
public class PairSums_04172022 {

    // Examples

    public static void main (String[] args) {
        PairSums_04172022 me = new PairSums_04172022();

        int[] testcase1a = {1,2,3,4,3}; // 2 2+4 and 3+3
        int test1k = 6;
        int[] testcase2a = {1,5,3,3,3}; // 4 1 + 5 and 3,3,3]
        int test2k = 6;

        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.numberOfWays(testcase1a, test1k)); // 3
        System.out.println(me.numberOfWays(testcase2a, test2k)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * for k/2, number of pairs is n * n-1 / 2
     * for 1 to k/2, number of pais is n *m
     * count the number of each number
     */
    boolean debug = true;
    int numberOfWays(int[] arr, int k){
        int totalCount = 0;

        Map<Integer, Integer> m = new HashMap<>();

        for (int i: arr)
            m.put(i, m.getOrDefault(i, 0)+1);
        if (debug)
            System.out.println(" m:" + m);
        // count k/2
        if (k%2 == 0 ) {  // even
            int countHalf = m.get(k/2);
            totalCount += (countHalf * (countHalf-1)) / 2;
            if (debug)
                System.out.println(" countHalf:" + countHalf + " totalCount:" + totalCount);
        }

        for (int i=1; i<k/2; i++)
            totalCount += m.getOrDefault(i,0) * m.getOrDefault(k-i,0);

        return totalCount;
    }
}