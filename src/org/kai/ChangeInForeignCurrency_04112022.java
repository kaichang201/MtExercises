package org.kai;


import java.util.*;

//
/*
 * Start 4/11/2022 12;07am 12:20am. 13mins
 * You likely know that different currencies have coins and bills of different denomincations.
 * In some currencies, it's actually impossible to receive change for a given amount of money.
 * For example, Canada has given up on the 1 cent penny. If you are owed 94 cents, the shopkeep
 * will supply you with 95 cents instead.
 * Given a list of available denoms, determie if it's possible to receive the exact change for an
 * amount of money targetMoney. Both the denoms and target amoudn will be given in generic units of that
 * currency.
 * Input
 * denomis 1 to 100
 * demonis[i] 1 to 10,000
 * target money 1 to 1000
 *
*/
public class ChangeInForeignCurrency_04112022 {

    // Examples

    public static void main (String[] args) {
        ChangeInForeignCurrency_04112022 me = new ChangeInForeignCurrency_04112022();

        int[] testcase1a = {5, 10, 25, 100, 200};
        int testcase1k = 94; // false

        int[] testcase2a = {4, 17, 29};
        int testcase2k = 75; // true


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.canGetExactChange(testcase1k, testcase1a)); // 3
        System.out.println(me.canGetExactChange(testcase2k, testcase2a)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * feels a little like fibbo. Calculate up.
     * Keep a visited
     *
     */
    boolean debug = true;
    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> dq = new ArrayDeque<>();

        for (int i: denominations) { // add all denomination
            dq.add(i);
            visited.add(i);
        }
        while (!dq.isEmpty()) {
            int val = dq.poll();
            if (debug)
                System.out.println("dq " + dq + " val " + val );
            if (val == targetMoney)
                return true;  // success condition
            for (int i: denominations) {
                int newVal = i+val;
                if (newVal <= targetMoney && !visited.contains(newVal)) { // less than and not visited
                    visited.add(newVal);
                    dq.add(newVal);
                }
            }


        }
        return false; // never hit the target

    }




}