package org.kai;


import java.util.Arrays;

//
/*
 * Start 4/4 9:00pm. 9:21pm. 21mins
 * Given a sequence of n integers arr, determine the lexicographically smallest sequence which may be obtained from it after
 * performing at most k element swaps, each involving a pair of consecutive elements in the sequence.
 *
 * Note: a list of x is leicographically smaller than a different equal-length list y if and only if, for the earliest index at which
 * the two lists differ, x's element at index is smaller than y's element at that index.
 *
 * n is in range 1 to 1000
 * each element is 1 to 1mm
 * k is range of 1 to 1000
*/
public class ElementSwapping_04042022 {

    // Examples

    public static void main (String[] args) {
        ElementSwapping_04042022 me = new ElementSwapping_04042022();

        int[] testcase1a = {5,3,1};
        int test1k = 2; // 1,5,3


        int[] testcase2a = {8, 9, 11, 2, 1};
        int test2k = 3; // [2, 8, 9, 11, 1]

        int[] testcase3a = {8, 9, 11, 2, 1};
        int test3k = 4; // [1, 8, 9, 11, 2]

        int[] testcase4a = {8, 9, 11, 2, 1};
        int test4k = 5; // [1, 8, 9, 2, 11]


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(Arrays.toString(me.findMinArray(testcase1a, test1k))); // 3
        System.out.println(Arrays.toString(me.findMinArray(testcase2a, test2k))); // 3

        System.out.println(Arrays.toString(me.findMinArray(testcase3a, test3k))); // 3

        System.out.println(Arrays.toString(me.findMinArray(testcase4a, test4k))); // 3

        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * greedy. find the smallest number in the first k+1 numbers.  move it to the first index.
     * repeat with next index. repeat until k=0 or index at end
     */
    boolean debug = true;
    int[] findMinArray(int[] arr, int k) {
        helper (arr, k, 0);
        return arr;
    }

    // recursion
    void helper (int[] arr, int k, int idx) {
        if (debug)
            System.out.println("  k: " + k + " idx: " + idx);
        if (idx==arr.length || k==0)  // complete when k =0 or index at 0
            return;
        int minVal = 2000, minIdx=-1;
        for (int i=idx; i<arr.length && i <=idx+k; i++) {
            if (arr[i] < minVal) { // new min
                minIdx=i;
                minVal = arr[i];
            }
        }
        if (debug)
            System.out.println(" minIdx: " + minIdx + " minVal: " + minVal);
        if (minIdx==idx) {
            helper(arr, k, idx+1); // smallest number at idx. move on
        } else {  // move the minIdx
            for (int i=minIdx; i>idx; i--)  // shift numbers right
                arr[i] = arr[i-1];
            arr[idx] = minVal;
            helper(arr, k-(minIdx-idx), idx+1); // smallest number at idx. move on
        }

    }



}