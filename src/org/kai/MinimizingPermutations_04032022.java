package org.kai;


import java.util.*;

//
/*
 * Start 4/3/2022 12:53pm. 1:27pm 34mins. BFS
 * In this probem, you are given an integer N, and a permution P, of the integers from 1 to N
 * denoted as (a1, a2, .. aN). YOu want to rearrange the elements of the permutation into increasing order,
 * repeatedly making the following operation:
 *  Select a sub-portion of the permutation (ai,.. aj) and reverse its order.
 * Your goal is to compute the min number of such operations required to return the permutation in increasing order
 * Input array is a permutation of all integers from 1 to N, N is between 1 and 8
 * Output Integer denoting the number of operations required to arrange the permutation in increasing order.
*/
public class MinimizingPermutations_04032022 {

    // Examples

    public static void main (String[] args) {
        MinimizingPermutations_04032022 me = new MinimizingPermutations_04032022();

        int[] testcase1a = {3,1,2}; // 2
        int[] testcase2a = {1, 2, 5, 4, 3}; // 1


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.minOperations(testcase1a)); // 3
        System.out.println(me.minOperations(testcase2a)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * if number is in its correct spot, labeled as a[i] = i+1, then we don't want to change it.
     * BFS to detect shortest parth.
     * It's like a rubix cube. Brute force
     */
    boolean debug = true;
    int minOperations(int[] arr) {
        int count = 0;
        int[] target = new int[arr.length];
        for (int i =0; i< arr.length; i++)  // init target
            target[i] = i+1;
        if (debug)
            System.out.println("target: " + Arrays.toString(target));
        Queue<int[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(arr)); // starting point
        q.add(arr);

        while (!q.isEmpty()) {
            if (debug)
                System.out.println("q: " + q + " visited: " + visited );
            int size = q.size();
            for (int i = 0; i<size; i++) {
                int[] curr = q.poll();
                if (Arrays.equals(curr, target))
                    return count; // success condition
                for (int j =0; j< curr.length; j++) {
                    for (int k = j + 1; k < curr.length; k++) { // N^2 nested loop // add every permutation not previously seen

                        int[] perm = reverse(curr, j, k);
                        String stringify = Arrays.toString(perm);
                        if (!visited.contains(stringify)) { // only queue it if it hasn't been seen before.
                            visited.add(stringify);
                            q.add(perm);
                        }
                    }
                }
            }
            count++;
        }
        return count;  // should never get here
    }

    // create a clone that reverses the aray at indices
    int[] reverse (int[] orig, int i, int j) {
        int[] rv  = orig.clone();
        while (i<j) {
            int x = rv[i];
            rv[i] = rv[j];
            rv[j] = x;
            i++;
            j--;
        }
        return rv;
    }

}