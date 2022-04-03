package org.kai;


import java.util.Collections;
import java.util.PriorityQueue;

//
/*
 * Start 4/3/2022 11;38am. 11:53. 15mins
 * Support we have a list of N numbers, and repeat the following operation until we're left with only a single number:
 *  - Chose any 2 numbers and replace them with their sum.
 *  - Moreover, we associate a penalty with each operation equal ot the value of the new number.
 *  - And call the penalty for the entire list as the sum of the penalties for each operation.
 * The goal in this problem is to find the highest possible penality for a given input.
 * Input
 * array of arr containing N intgers.
 * Constraints
 *  n 1 to 1,000,000
 *  A[i] is 1 to 10,000,000
 * The sum of values of N of all test cases will not exceed 1,000,000
*/
public class SlowSums_04032022 {

    // Examples

    public static void main (String[] args) {
        SlowSums_04032022 me = new SlowSums_04032022();

        int[] testcase1a = {1,2,3,4,5}; // 9, 12, 14, 15 = 50
        int[] testcase2a = {4,2,1,3}; //  26
        int[] testcase3a = {2,3,9,8,4}; //  88

        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.getTotalTime(testcase1a)); // 3
        System.out.println(me.getTotalTime(testcase2a)); // 3

        System.out.println(me.getTotalTime(testcase3a)); // 3

        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Since the signature of the method is int, then that means the highest penaly must fit in int
     * add the 2 highest numbers. That will bump up the penality by using the highest numbers repeatedly
     */
    boolean debug = true;
    int getTotalTime(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i: arr)
            pq.add(i);
        int penalty =0;
        int high = pq.poll(); // since arr.length > 0, pq.poll() cannot throw null

        while (!pq.isEmpty()) {
            high += pq.poll();
            penalty += high;
            if (debug)
                System.out.println("penalty " + penalty + " high " + high);

        }
        return penalty;

    }




}