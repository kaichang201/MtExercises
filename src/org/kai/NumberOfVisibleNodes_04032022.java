package org.kai;


//
/*
 * Start 4/3/2022 4:32pm. 4:39pm
 * There is a binary tree of N nodes.  You are viewing the tree fom its left side and can only
 * see the left-most nodes at each level. Return the number of visible nodes.
 * Note: You can see only the left-most nodes, but that doesn't mean they have to be left nodes.
 *
*/
public class NumberOfVisibleNodes_04032022 {

    // Examples

    static class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main (String[] args) {
        NumberOfVisibleNodes_04032022 me = new NumberOfVisibleNodes_04032022();

        Node root_1 = new Node(8);
        root_1.left = new Node(3);
        root_1.right = new Node(10);
        root_1.left.left = new Node(1);
        root_1.left.right = new Node(6);
        root_1.right.right = new Node(14);
        root_1.left.right.left = new Node(4);
        root_1.left.right.right = new Node(7);
        root_1.right.right.left = new Node(13);

        System.out.println(me.visibleNodes(root_1)); // 4;

        Node root_2 = new Node(10);
        root_2.left = new Node(8);
        root_2.right = new Node(15);
        root_2.left.left = new Node(4);
        root_2.left.left.right = new Node(5);
        root_2.left.left.right.right = new Node(6);
        root_2.right.left = new Node(14);
        root_2.right.right = new Node(16);

        System.out.println(me.visibleNodes(root_2)); // 5

        long startTime = System.currentTimeMillis();



        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * 2 strategies.
     * 1) DFS to find the max depth.
     * 2) BFS to find the left-most node.
     * Let's do DFS. In order traversal.
     */
    int val;
    int visibleNodes(Node root) {
        val=0; //init val
        dfs(root, 1);
        return val;
    }
    void dfs(Node root, int level ) {
        // end condition for recursion
        if (root == null)
            return;

        dfs(root.left, level+1);
        val = Math.max(val, level);
        dfs(root.right, level+1);

    }







}