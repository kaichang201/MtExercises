package org.kai;


import java.util.*;

//
/*
 * Start 4/14/2022 7:32pm 7:50 18mins.
 * Given a list of N triangles with integer side length, determine how many different triangles there are.
 * Two triangles are considered to be the same if they can both be placed on the plan such that their vertices occupy
 * exactly the same 3 points.
 *
*/
public class CountingTriangles_04142022 {

    // Examples

    static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main (String[] args) {
        CountingTriangles_04142022 me = new CountingTriangles_04142022();

        ArrayList<Sides> testcase1a = new ArrayList<>();
        testcase1a.add(new Sides(2,2,3));
        testcase1a.add(new Sides(3,2,2));
        testcase1a.add(new Sides(2,5,6)); // 2


        ArrayList<Sides> testcase2a = new ArrayList<>();
        testcase2a.add(new Sides(8,4,6));
        testcase2a.add(new Sides(100,101,102));
        testcase2a.add(new Sides(84,93,173)); // 3

        ArrayList<Sides> testcase3a = new ArrayList<>();
        testcase3a.add(new Sides(5,8,9));
        testcase3a.add(new Sides(5,9,8));
        testcase3a.add(new Sides(9,5,8));
        testcase3a.add(new Sides(9,8,5));
        testcase3a.add(new Sides(8,9,5));
        testcase3a.add(new Sides(8,5,9)); // 1

        int[][] testcase4a = {
                {7,6,5},
                {5,7,6},
                {8,2,9},
                {2,3,4},
                {2,4,3}
        }; // 3

        int[][] testcase5a = {
                {3,4,5},
                {8,8,9},
                {7,7,7}
        }; // 3



        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.countDistinctTriangles(testcase1a)); // 3
        System.out.println(me.countDistinctTriangles(testcase2a)); // 1
        System.out.println(me.countDistinctTriangles(testcase3a)); // 1


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * use hashset
     */
    boolean debug = true;
    int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        Set<String> st = new HashSet<>();

        for (Sides sd: arr) {
            int[] ia = new int[] {sd.a, sd.b, sd.c};
            Arrays.sort(ia);
            StringBuilder sb = new StringBuilder().append(ia[0]).append(",").append(ia[1]).append(",").append(ia[2]);
            st.add(sb.toString());
        }
        if (debug)
            System.out.println(st);
        return st.size();

    }



}