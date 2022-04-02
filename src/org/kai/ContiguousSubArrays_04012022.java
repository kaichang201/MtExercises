package org.kai;


import java.util.Arrays;
import java.util.Stack;

//
/*
 * Start  4/1/2022 7;22pm. Hints helped.  Answer helped more.  Took 40mins and some paper to learn how the stack is used.
 * You are given an array of N integers.  For each index i, you are required to determine the number of contiguous subarrays that fulfill the following
 * conditions:
 *  The value at index i must be the max element in the contiguous subarrays and
 *  These contiguous subarrays must be either start from or end on index i;
 * Input
 *  - Array arr is non-empty list of uniq integers ranging from 1to 1 billion. (int is 4billion)
 *  - Size of N is 1 to 1mm
 * Output - An array where each index i contains an integer denoting the number of max number of contiuosu subarrays of arr[i]
*/
public class ContiguousSubArrays_04012022 {

    // Examples

    public static void main (String[] args) {
        ContiguousSubArrays_04012022 me = new ContiguousSubArrays_04012022();

        int[] testcase1a = {3,4,1,6,2}; // 1, 3 (34, 41, 416), 1, 5, 1}



        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(Arrays.toString(me.countSubarrays(testcase1a))); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Use a Stack.  go both ways.
     *
     */
    boolean debug = true;
    int[] countSubarrays(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] lans = new int[arr.length], rans = new int[arr.length], ans = new int[arr.length];

        // Go left to right
        for (int i = 0; i<arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) { // the top of the stack is smaller than i-th number
                lans[i] += lans[st.pop()]; // add to the i-th answer
            }
            lans[i]++;
            st.push(i);
        }
        st.clear();
        // Go right to left
        for (int i = arr.length-1; i >=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) { // the  top of the stack is smaller than i-th number
                rans[i] += rans[st.pop()]; // add to the i-th answer
            }
            rans[i]++;
            st.push(i);
        }
        if (debug)
            System.out.println("lans: "+ Arrays.toString(lans) + " rans: " + Arrays.toString(rans));

        for (int i = 0; i<arr.length; i++)
            ans[i] = lans[i] + rans[i] -1;

        return ans;
    }






}