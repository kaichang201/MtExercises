package org.kai;


//
/*
 * Start 4/16/2022 29. 54. 25mins
 * WE have N different apps with differnt user growth rates.  AT a given time t, meastured in days, the number of users
 * using an ap is g^t. (for simplicity we'll allow fractional users), where g is the growth rate for that app.
 * These apps will be launched at the same time and no user ver uses more than 1 of the apps.  We want to know how many
 * total users there are when you add together the number of users from each app.
 * After how many full days will we have 1 billion users total across the N apps?
 * growth rater 1.0 to 2.0
 * N 1 to 1000
*/
public class OneBillionUsers_04162022 {

    // Examples

    public static void main (String[] args) {
        OneBillionUsers_04162022 me = new OneBillionUsers_04162022();

        float[] testcase1a = {1.5f}; //52
        float[] testcase2a = {1.1f, 1.2f, 1.3f}; // 79
        float[] testcase3a = {1.01f, 1.02f}; //1047


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.getBillionUsersDay(testcase1a)); // 3
        System.out.println(me.getBillionUsersDay(testcase2a)); // 3
        System.out.println(me.getBillionUsersDay(testcase3a)); // 3



        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * We can search linearly from 1 to X.  O(n)
     * We can do binary search from 1 to MAX_INT.  knowing that since we need to return int, result is less than or equal to max_int
     * O(Log max_int) = 32
     */
    boolean debug = true;
    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        long left=1, right= Integer.MAX_VALUE; // left is 1, because on day x^0 = 1, which is less than 1 billion.
        final int billion = 1000000000;

        while (left <right) { // we look for mid-value day where mid-1 is less than 1 billion

            boolean exceeded = false;
            long mid = (right+left)/2;
            long total = 0, totalLess=0;
            for (float f: growthRates) {
                total += Math.pow(f, mid);
                totalLess += Math.pow(f, mid-1);
                if (totalLess > billion) {
                    exceeded = true;
                    break;
                }
            }

            if (debug)
                System.out.println(" left: " + left + " right: " + right + " exceeded " + exceeded + " total " + total + " totalLess" + totalLess);

            if (total >= billion && totalLess <billion)
                return (int) mid; // success condition
            if (exceeded)
                right = mid-1;
            else
                left = mid;
        }
        return 0; // should never get here

    }





}