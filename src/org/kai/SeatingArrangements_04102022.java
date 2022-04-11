package org.kai;


import java.util.Arrays;

//
/*
 * Starting 4/10/2022 11:41pm 11:51pm. 10mins
 * There are n guests attending a dinner party, numbered 1 to n. the ith guest has a height of arr[i-1] inches.
 * The guests will sit down at a circular table which ahs n seats, numbered from 1 to n in clockwise order around the table.
 * As the host, you will choose how to arrange the guests.  Note there are n! possible permutations of seat assignments.
 * Once the gusts have sat down, the awkwardness between pair of guests sitting in adj seats is defined as the absolute diff
 * between their two heights. Note that, because the table is circular, seats 1 and n are considered to be adjacent to one
 * another, and are therefor n pairs of adj guests.
 * The overall awk of the seating arrangements is defined as the max awk of any pair of adj guests. Determine the min
 * possible overall awk of any seating arrangement
*/
public class SeatingArrangements_04102022 {

    // Examples

    public static void main (String[] args) {
        SeatingArrangements_04102022 me = new SeatingArrangements_04102022();

        int[] testcase1a = {5,10,6,8}; // 4
        int[] testcase2a = {1, 2, 5, 3, 7}; // 4


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.minOverallAwkwardness(testcase1a)); // 3
        System.out.println(me.minOverallAwkwardness(testcase2a)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * sort the list O(nlogn)
     * keep left, right and place people from outside in in ascending order O(N)
     * calculate max diff O(N)
     * memory O(n)
     */
    boolean debug = true;
    int minOverallAwkwardness(int[] arr) {
        Arrays.sort(arr);
        int left = 0, right = arr.length-1, maxDiff = -1;
        int[] seats = new int[arr.length];
        boolean isLeft = true;


        for (int i: arr) {
            if (isLeft)
                seats[left++] = i;
            else
                seats[right--] = i;
            isLeft = !isLeft;
        }
        if (debug)
            System.out.println("seats: " + Arrays.toString(seats));
        for (int i=1; i<arr.length; i++)
            maxDiff = Math.max(maxDiff, Math.abs(seats[i]-seats[i-1]));
        return maxDiff;
    }





}