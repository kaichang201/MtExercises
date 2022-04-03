package org.kai;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//
/*
 * Start 4/3/2022 11:21am. 11:35am. 14mins
 * You are given a list of n integers arr[0..n-1]. You must compute a list of output [0..n-1] such that, for each index i
 * between 0 and n-1 inclusive, output[i] is equal to the product of the 3 largest elements out of arr[0..i]
 * or equal to -1 if i<2, as arr includes fewer then 3 elements)
 * Note that the 3 largest elements used to form any product may have the same values
 * as 1 another, buy they must be different indices in arr
 * Input n is 1 to 100,000
 * Each value of arr[i] is 1 to 1000.
 *
*/
public class LargestTripleProducts_04032022 {

    // Examples

    public static void main (String[] args) {
        LargestTripleProducts_04032022 me = new LargestTripleProducts_04032022();

        int[] testcase1a = {1,2,3,4,5}; // [-1, -1, 6, 24, 60];
        int[] testcase2a = {2,1,2,1,2}; // -1, -1, 4, 4, 8]


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(Arrays.toString(me.findMaxProduct(testcase1a))); // 3
        System.out.println(Arrays.toString(me.findMaxProduct(testcase2a))); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Keep a priorityqueue of elements visited. if pq < 3, set -1.  multiple the top 3.
     */
    int[] findMaxProduct(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] rv = new int[arr.length];

        for (int i =0; i<arr.length; i++) {
            pq.add(arr[i]);

            if (pq.size() < 3) {
                rv[i] = -1;
            } else {
                int product =1;
                PriorityQueue<Integer> newPQ = new PriorityQueue<>(Collections.reverseOrder());
                for (int j =0; j<3 && !pq.isEmpty(); j++) {  // find product and add into new PQ
                    int val = pq.poll();
                    product *= val;
                    newPQ.add(val);
                }
                rv[i] = product;
                pq = newPQ;
            }
        }
        return rv;
    }







}