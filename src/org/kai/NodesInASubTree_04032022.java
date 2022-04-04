package org.kai;


import java.util.*;

//
/*
 * Start 4/4/3022 4:40pm. 5:09. 29mins.
 * You are given a tree that contains N nodes, each containing an integer U which corresponds to a lowercase character c in the string s using 1-based indexing.
 * You are requried to answer Q queryies of type [u,c], where u is an integer and c is a lower case letter.  The query result is the number of nodes in a
 * subtree of node u containing c.
 * Input
 * A pointer to root node.
 * An array list containing Q queries of type u,c
 * and a string.
 * - N and Q are 1 to 1mm
 * - u is a unique integer between 1 and N.
 * - s is the length of N, containing only lowercase letters
 * c is lower case letter contained in string s.
*/
public class NodesInASubTree_04032022 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int u;
        char c;
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    public static void main (String[] args) {
        NodesInASubTree_04032022 me = new NodesInASubTree_04032022();

        int[] testcase1a = {2,5,1,2,5};


        long startTime = System.currentTimeMillis();

        // Strategy 1
        //Testcase 1
        int n_1 = 3, q_1 = 1;
        String s_1 = "aba";
        Node root_1 = new Node(1);
        root_1.children.add(new Node(2));
        root_1.children.add(new Node(3));
        ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));

        int[] output_1 = me.countOfNodes(root_1, queries_1, s_1);
        int[] expected_1 = {2};
        System.out.println(Arrays.toString(output_1));

        // Testcase 2
        int n_2 = 7, q_2 = 3;
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        int[] output_2 = me.countOfNodes(root_2, queries_2, s_2);
        int[] expected_2 = {4, 1, 2};
        System.out.println(Arrays.toString(output_2));

        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * Build a HashMap<Integer,Node> to find the subNode.
     * Then just DFS pre-order traverse
     */
    Map<Integer, Node> m;
    int[] rv;
    boolean debug = true;
    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        // Init
        m = new HashMap<>();
        rv = new int[queries.size()];
        // build Map
        buildMap(root);
        if (debug)
            System.out.println("Map: " + m);

        // process queries
        for (int i=0; i<queries.size(); i++) {
            Query q = queries.get(i);
            rv[i] = processQuery(m.get(q.u),  s, q.c);
        }
        return rv;
    }

    // Recursive DFS
    void buildMap(Node root) {
        m.put(root.val, root);
        if (root.children != null) // since N>=1, then children checker will prevent root==null
            for (Node child: root.children)
                buildMap(child);
    }

    // Recursive DFS to find instances of character c from root
    int processQuery(Node root, String s, char c) {

        int rv=0;

        if (root.children != null) // since N>=1, then children checker will prevent root==null
            for (Node child: root.children)
                rv += processQuery(child, s, c);

        if (s.charAt(root.val-1) == c)  // root.val is 1-indexed. s.charAt is 0 indexed.
            rv++;

        if (debug)
            System.out.println("s.charAt: " + s.charAt(root.val-1) + " c " + c + " rv: " + rv);
        return rv;
    }



}