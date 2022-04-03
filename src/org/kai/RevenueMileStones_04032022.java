package org.kai;


import java.util.Arrays;

//
/*
 * Start 4/3/2022 12:00 12:38pm. 38mins
 * We keeptrack of the revenue Facebook makes every day, and we wnat to know on what days Facebook hits certain revenue milestones.
 * Given an array of revenue on each day, and an array of milestones Facebook wants to reach, return an array containing the days on which Facebook reach
 * every milestone.
 * Input
 * revenue is length-n array representing how much revenue FB makde on day 1 to N. milestones is the lengthK of total revenue miletones
 * Output, return a length-K array where K_i is the day on which FB first had mileston[i] total revenue.  If the mileston is never met, return -1.
*/
public class RevenueMileStones_04032022 {

    // Examples

    public static void main (String[] args) {
        RevenueMileStones_04032022 me = new RevenueMileStones_04032022();

        int[] testcase1a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] testcase1t = {100,200,500}; //4,6,10

        int[] testcase2a = {100, 200, 300, 400, 500};
        int[] testcase2t = {300, 800, 1000, 1400}; //2, 4, 4, 5

        int[] testcase3a = {700, 800, 600, 400, 600, 700};
        int[] testcase3t = {3100, 2200, 800, 2100, 1000}; //5,4,2,3,2  // targets is not guaranteed to increase

        int[] testcase4a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] testcase4t = {100,200,10000, 500, 5 }; //4,6,-1, 10, 1

        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(Arrays.toString(me.getMilestoneDays(testcase1a, testcase1t))); // 3
       System.out.println(Arrays.toString(me.getMilestoneDays(testcase2a, testcase2t))); // 3
       System.out.println(Arrays.toString(me.getMilestoneDays(testcase3a, testcase3t))); // 3
       System.out.println(Arrays.toString(me.getMilestoneDays(testcase4a, testcase4t))); // 3

        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Process revenues array into TreeMap<Integer,Integer> of sum and day where that sum is reached.
     * Then process milestone array looking for floorKey, which is the greatest key less than milestone.  in other words the greatest amount that is smaller than mileston.
     *
     * or process into array of increasing sums, and use Arrays.search to find the insertionPoint, in otherwords where left value is less than
     * Can revenue for a day be 0?  can revenue for a day be negative?  assume no to both.
     */
    boolean debug = true;
    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] sums = new int[revenues.length];

        sums[0] = revenues[0];
        for (int i =1; i< revenues.length; i++)
            sums[i]+= revenues[i] + sums[i-1];
        if (debug)
            System.out.println("sums: " + Arrays.toString(sums));

        int[] rv = new int[milestones.length];

        for ( int i = 0; i < milestones.length; i++) {
            int insertionPoint = Arrays.binarySearch(sums, milestones[i]);
            if (debug)
                System.out.println("i: " + i  + " milestone: " + milestones[i] + " insertionPoint: " + insertionPoint);
            if (insertionPoint < (sums.length) * -1)  // milestone never reached
                rv[i] = -1;
            else if (insertionPoint == -1 ) // milestone reached on day 1
                rv[i] = 1;
            else if (insertionPoint < -1)  // insertion point within array
                rv[i] = insertionPoint * -1;
            else // found exact match
                rv[i] = insertionPoint+1;

        }
        return rv;

    }





}