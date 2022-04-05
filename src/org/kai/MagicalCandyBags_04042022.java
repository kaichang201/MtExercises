package org.kai;


import java.util.Collections;
import java.util.PriorityQueue;

//
/*
 * Start 4/4/2022 9:31pm. 9:38pm. 7mins
 * You have N bags of candy.  The ith bag contains arr[i] pieces of candy, and each of the bags is magical!.
 * It takes you 1 min to eat all of the candies in a bag, irrespecitve of how many pieces of candies are inside.
 * as soon as you finish, the bag refills.
 * If there were x pieces of candy in the bag at the beginning of the min, then after you've finished you'll find that
 * floor(x/2)pieces are now inside.
 * You have k mins to eat as much candy as possible.  How many pieces of candy can you eat?
 * Constraints
 * n, k  1 to 10,000,
 * arr[i] 1 to 1billion.
*/
public class MagicalCandyBags_04042022 {

    // Examples

    public static void main (String[] args) {
        MagicalCandyBags_04042022 me = new MagicalCandyBags_04042022();

        int[] testcase1a = {2,1,7,4,2};
        int test1k = 3; // 14. eat 7, 4, 3.

        int[] testcase2a = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        int test2k = 3; // 14. eat 7, 4, 3.

        long startTime = System.currentTimeMillis();

        // Strategy 1
        System.out.println(me.maxCandies(testcase1a, test1k)); // 3
        System.out.println(me.maxCandies(testcase2a, test2k)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * use priority queue
     */
    boolean debug = true;
    int maxCandies(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int rv = 0;

        for (int i: arr)
            pq.add(i);

        for (int i =0; i<k; i++) {
            int val = pq.poll();

            rv+=val;
            pq.add(val/2);
            if (debug)
                System.out.println( "val: " + val + " rv: "+ rv);
        }

        return rv;

    }



}