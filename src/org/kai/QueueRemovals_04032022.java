package org.kai;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


//
/*
 * Start 4/3 8:27pm 8:59pm 22mins
 * You are given a list of n integers arr, which representes elements in a queue in order from front to back.
 * You are also given integer x, and must perform x interations of the following 3-step process.
 *  - Pop x elements from the front of the queue (or, if it contains fewer than x elements, pop all of them)
 *  - Of the elements that were popped, find the one with the largest value ( if there are multiple such elements, take the one
 *  - which had been popped the earliest) and remove it.
 *  - for each one of the remaining elements that were popped ( in the order they were popped, decrement its value by 1 if it's positive
 *  (otherwise if its value is 0, then it is left unchanged) and then add it back to the queue.
 * Compute a list of x intgers output, the ither of which is the 1-based index in the original
 * array of the element which had been removed in step 2 during the ith iteration
 * Input x 1 to 316
 *  n is x to x*x
 * Each value arr[i] is in range 1,x
*/
public class QueueRemovals_04032022 {

    // Examples

    public static void main (String[] args) {
        QueueRemovals_04032022 me = new QueueRemovals_04032022();

        int[] testcase1a = {1,2,2,3,4,5};
        int test1x = 5; // 5,6,4,1,2

        int[] testcase2a = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int test2x = 4; // 2,5,10,13


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(Arrays.toString(me.findPositions(testcase1a, test1x))); // 3
        System.out.println(Arrays.toString(me.findPositions(testcase2a, test2x))); // 3



        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Create Node of value and index.
     * Create Queue<Node>
     * look x times
     */
    boolean debug = true;
    class node {
        int val;
        int idx;
        node (int v, int i) {
            val = v;
            idx = i;
        }

        @Override
        public String toString() {
            return "node{" +
                    "val=" + val +
                    ", idx=" + idx +
                    '}';
        }
    }
    int[] rv;
    Queue<node> q;
    int[] findPositions(int[] arr, int x) {
        // Write your code here
        rv = new int[x];
        q = new ArrayDeque<>();
        // init Queue
        for (int i = 0; i<arr.length; i++) {
            q.add(new node(arr[i],i+1));
        }
        for (int i = 0; i<x; i++) {
            helper(i, x);
            if (debug)
                System.out.println(" queue: " + q);
        }

        return rv;
    }

    void helper (int idx, int x) {
        // pop x elements from the front of the queue
        Queue<node> q2 = new ArrayDeque<>();
        int maxVal = -1, maxIdx=-1;
        // process q into q2, look for the maxVal
        for (int i = 0; i<x && !q.isEmpty(); i++) {  // pop x elements from q, or until q is empty
            node curr = q.poll();
            if (curr.val > maxVal) {
                maxIdx = curr.idx;
                maxVal = curr.val; // found new max
            }
            q2.add(curr);
        }
        if (debug)
            System.out.println("  q2: " + q2 + " maxidx: " + maxIdx);
        while(!q2.isEmpty()) {
            node curr = q2.poll();
            if (curr.idx == maxIdx) {
                if (debug)
                    System.out.println("  dropping: " + curr);
                rv[idx] = curr.idx;
                continue; // skip the maxIdx
            }
            curr.val = curr.val == 0 ? 0 : curr.val-1;
            q.add(curr);
        }


    }





}