package org.kai;


import java.util.Stack;

//
/*
 * Start 4/3 5:15pm 5:25pm. 10mins
 * A bracket is any of hte following. () {} or []
 * We consider 2 brackers to be matching if the first backet is open and second is close of the same type.
 * Furthermore, a seuqence of brackets is balanced if:
 *  - sequence is empty
 *  - Sequence is composetd of 2 or more non-empty, and all are balanced
 *  - first and last brackes of the sequence are matching, and portion of the sequence without the first and last is balanced.
 * You are given a string of brackets. Your task is to determine whether each sequence is balanced.
*/
public class BalanceBrackets_04032022 {

    // Examples

    public static void main (String[] args) {
        BalanceBrackets_04032022 me = new BalanceBrackets_04032022();

        String testcase1s = "{[()]}"; // true
        String testcase2s = "{}()"; // true
        String testcase3s = "{(})"; // false
        String testcase4s = ")"; // false
        String testcase5s = "{[(])}"; // false
        String testcase6s = "{{[[(())]]}}"; // true

        long startTime = System.currentTimeMillis();

        // Strategy 1
        System.out.println(me.isBalanced(testcase1s)); // 3
        System.out.println(me.isBalanced(testcase2s)); // 3
        System.out.println(me.isBalanced(testcase3s)); // 3
        System.out.println(me.isBalanced(testcase4s)); // 3
        System.out.println(me.isBalanced(testcase5s)); // 3
        System.out.println(me.isBalanced(testcase6s)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * use stack
     */
    boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();

        for (char c: s.toCharArray() ){
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (st.isEmpty()) { // closing bracket when stack is empty
                return false;
            } else {
                char top = st.pop();
                if ((c == ')' && top != '(')
                    || (c == '}' && top != '{')
                    || (c == ']' && top != '['))
                    return false; // mismatched brackets
            }

        }
        return st.isEmpty();  // only return true if stack is empty, and every open bracket has been closed
    }





}