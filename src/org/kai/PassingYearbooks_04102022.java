package org.kai;


import java.util.*;

//
/*
 * Start 4/10/2022
 * There are n students, numbered from 1 to n, each with their own yearbook.  They would like to pass their yearbooks around
 * and get them signed by other students.
 * You're given a list of n integers arr[1..n] which is guaranted to be a mutation of 1..n.
 * In other words, it includes the integers from exactly 1 to n exactly once each, in some order.
 * Initially each student is holding their own yearbook.  The students then repeat the following 2 steps each minute:
 *  - Each student i will sign the yearbook that they are currently holding (which may either belong to themselves or another student),
 * and then they'll pass it to student  arr[i-1]. It's possible that arr[i-1] = i for any given i, in which case student i will pass their
 * yearbook back to themselves.  Once a student has received their own yearbook back, they will hold on to it and no longer partitipate in
 * the passing process.
 * It's guaranted that, for any possible valid input, each student will eventually receive their own year book back and never end upholdin
 * more than 1 yearbook at a tie.
 * You must computer a list of n integers output, whose element at i-1 is equal to the number of signatures that will be present in student
 * i's yearobok once they receive it back.
 * Input n 1 to 1mm.
 *
*/
public class PassingYearbooks_04102022 {

    // Examples

    public static void main (String[] args) {
        PassingYearbooks_04102022 me = new PassingYearbooks_04102022();

        int[] testcase1a = {2,1}; //2,2
        int[] testcase2a = {1,2}; //1,1
        int[] testcase3a = {4,3,2,5,1}; // 3,2,2,3,3


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(Arrays.toString(me.findSignatureCounts(testcase1a))); // 3
        System.out.println(Arrays.toString(me.findSignatureCounts(testcase2a))); // 3
        System.out.println(Arrays.toString(me.findSignatureCounts(testcase3a))); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Picked up solution from Leetcode.
     * Problem description pretty bad. Basically just look up array to decide who to pass it to next.
     */
    boolean debug = true;
    int[] findSignatureCounts(int[] arr) {
        // Write your code here
        int[] output = new int[arr.length];

        for(int student =1; student <= arr.length;student++){
            int bookOwner= student;
            int currentHolder = student;

            do{
                if (debug)
                    System.out.println("student: " + student + " currentHolder: "+ currentHolder );
                output[student-1] +=1;
                currentHolder = arr[currentHolder-1];
            }while(currentHolder != bookOwner);

        }
        return output;

    }






}