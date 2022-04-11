package org.kai;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
/*
 * Start 4/10 10:50pm 11:30pm. 40min
 * You are given a list of n integers arr[0..n-1]. You must compute a list output[0..n-1] such that for each index i
 * putout [i] is equal to the median of the elements arr[0..i]
 * The median of a list of integer is defined as follows.  If the integers are sorted then
 * - If there are an odd number of integers, median is middle of hte sorted order
 *  - If there is an even number of integers, median is the average of the 2 middle integers
*/
public class MedianStream_04102022 {

    // Examples

    public static void main (String[] args) {
        MedianStream_04102022 me = new MedianStream_04102022();

        int[] testcase1a = {5,15,1,3}; // 5, 10, 5, 4
        int[] testcase2a = {1,2}; // {1,1}
        int[] testcase3a = {2, 4, 7, 1, 5, 3}; // {2, 3, 4, 3, 4, 3


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(Arrays.toString(me.findMedian(testcase1a))); // 3
        System.out.println(Arrays.toString(me.findMedian(testcase2a))); // 3
        System.out.println(Arrays.toString(me.findMedian(testcase3a))); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * use ArrayList
     * use binarysearch to insert each value
     */
    boolean debug= true;
    List<Integer> al;
    int[] findMedian(int[] arr) {
        al = new ArrayList<>();
        int[] rv = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            insertList(arr[i]);
            int alSize = al.size();
            if (alSize%2 == 0) { // even
                rv[i] = (al.get(alSize/2) + al.get((alSize-1)/2))/2;
                if (debug)
                    System.out.println(" even al: "+ al + " rv " + Arrays.toString(rv) + " alSize/2 " + (alSize/2) + " (alSize-1)/2 " + (alSize-1)/2);
            } else {
                rv[i] = al.get(alSize/2);
                if (debug)
                    System.out.println(" odd al: "+ al + " rv " + Arrays.toString(rv));
            }

        }
        return rv;
    }

    void insertList (int val) {
        int left = 0, right = al.size()-1;
        if (al.isEmpty() || val >= al.get(right)) { //append to tail
            al.add(val);
        } else if (val <= al.get(0)) { // prepend to front
            al.add(0,val);
        } else { // insert into middle
            while (left < right) { // look for mid <= i <=mid+1
                int mid = (right+left)/2;
                if ( al.get(mid) <= val && val <= al.get(mid+1)) {
                    if (debug)
                        System.out.println("  insert val: " + val + " left " + left + " right " + right + " mid " + mid);
                    al.add(mid+1, val); // success condition
                    break;
                } else if (val < al.get(mid)) { // shift left
                    right = mid;
                } else {
                    left = mid+1;
                }
            }

        }
    }



}