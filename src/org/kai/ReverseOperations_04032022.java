package org.kai;


//
/*
 * Start 4/3/2022 9pm. pause 9:06. Resume 9:11. 9;48. total 43mins
 * You are given a singly linked list that contains N integers.
 * A subpart of the list is a contiguous set of even elements, bordered either by either end of the list
 * or an odd element.  For example, if the list is 1,2,8,9,12,16, the sub-parts of the list are 2,8 and 12,16
 * Then for each subpart, the order of the elements is reversed.  In this example, the result in the new list
 * 1,8,2,9,16,12
 * the goal of this question is: given a resulting list, determine the original order of the elements
 *
 * Constaints
 * n 1 to 1000, where n is size of hte list
 *  Li 1 to 1,000,000,000, where Li is the ith element of the list.
*/
public class ReverseOperations_04032022 {

    // Examples


    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    static Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }
    public static void main (String[] args) {
        ReverseOperations_04032022 me = new ReverseOperations_04032022();

        int[] testcase1a = {1, 2, 8, 9, 12, 16}; // 1,8,2,9,16,12
        Node t1 = createLinkedList(testcase1a);

        int[] testcase2a = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        Node t2 = createLinkedList(testcase2a); // 24, 18, 2, 3, 5, 7, 9, 12, 6

        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.reverse(t1)); // 3
       System.out.println(me.reverse(t2)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * if head is null, return null
     * if head.val is odd, head.next is reverse(head.next), return head.
     * if head.val is even
     *  - find the tail.
     *  - reverse from head to tail
     *  - tail.next = reverse (tail.next)
     *  return head.
     *
     */
    boolean debug = true;
    Node reverse(Node head) {
        if (head != null) {
            if (head.data%2 != 0) {
                if (debug)
                    System.out.println(" odd: " + head);
                head.next = reverse(head.next);
                if (debug)
                    System.out.println(" odd return: " + head);
            }
            else {  // head.val is even.
                if (debug)
                    System.out.println(" even: " + head);
                head = reverseHelper(head);
                if (debug)
                    System.out.println(" even return: " + head);
            }
        }
        return head;
    }

    Node reverseHelper(Node head) { // flip evens
        if (head.next == null || head.next.data %2 != 0)
            return head; // if only 1, no point flipping)

        Node tailNext = head.next;
        while (tailNext != null && tailNext.data %2 == 0)
            tailNext = tailNext.next; // keep walking while taiNext is null or odd
        if (debug)
            System.out.println(" tailNExt: " + tailNext);

        Node flipped = flipEven(head);

        if (debug)
            System.out.println(" flipped: " + flipped);
        return appendTail(flipped, reverse(tailNext));
    }

    Node flipEven(Node head) {
        if (head.next == null || head.next.data %2 != 0) { // next value is odd or null
            return head;
        }
        Node newHeadNode = flipEven(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }

    Node appendTail (Node head, Node tailNext) {
        if (debug)
            System.out.println(" appending head : " + head + " tail: " + tailNext);
        Node walker = head;
        while (walker.next != null)
            walker = walker.next;
        walker.next = tailNext;
        if (debug)
            System.out.println(" appended head : " + head );
        return head;

    }



}