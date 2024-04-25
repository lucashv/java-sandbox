package com.lhvsofteng.java.sandbox;

import java.util.*;

// For a graph like:
//            A
//          /   \
//        B        C
//      /   \    /
//     D     E  F
//   /   \
// G      H
// It prints ABCDEFGH
public class HorizontalNodePrinter {
    public static void main(String[] args) {
        System.out.println("Hello!");
        //Node a = initNodes();
        //printNodes(a);

        int[] ints = someThing(new String[] { "the", "dog", "got", "the", "bone" });

        for (int i : ints) {
            System.out.println("-> " + i);
        }

        int x = (4 >> 1);
        System.out.println(" ----> " + x);
    }

    private static int[] someThing(String[] words) {
        Map<String, Integer> w = new TreeMap<>();
        for (String s : words) {
            if (!w.containsKey(s)) {
                w.put(s, 1);
            } else {
                w.put(s, w.get(s) + 1);
            }
        }

        List<Integer> idx = new ArrayList<>();
        for (Map.Entry<String, Integer> e : w.entrySet()) {
            idx.add(e.getValue());
        }

        int[] x = new int[idx.size()];
        for (int i = 0; i < idx.size(); i++) {
            x[i] = idx.get(i);
        }

        return x;
    }

    private static void printNodes(final Node node) {
        System.out.print(node.value);

        List<Node> children = new ArrayList<>();
        children.addAll(node.left);
        children.addAll(node.right);

        while (!children.isEmpty()) {
            Node[] nodes = children.toArray(new Node[] {});
            children.clear();
            for (Node n : nodes) {
                System.out.print(n.value);
                if (n.left != null)
                    children.addAll(n.left);
                if (n.right != null)
                    children.addAll(n.right);
            }
        }
    }

    private static void printNodes2(final Node node) {
        System.out.print(node.value);
        if (node.left != null && !node.left.isEmpty()) {
            for (Node n : node.left) {
                System.out.print(n.value);
            }
        }
        if (node.right != null && !node.right.isEmpty()) {
            for (Node n : node.right) {
                System.out.print(n.value);
            }
        }
    }

    private static Node initNodes() {
        Node f = new Node("F");
        Node c = new Node("C");
        c.left = new ArrayList<>();
        c.left.add(f);

        Node g = new Node("G");
        Node h = new Node("H");
        Node d = new Node("D");
        d.left = new ArrayList<>();
        d.right = new ArrayList<>();
        d.left.add(g);
        d.right.add(h);

        Node e = new Node("E");

        Node b = new Node("B");
        b.left = new ArrayList<>();
        b.right = new ArrayList<>();
        b.left.add(d);
        b.right.add(e);

        Node a = new Node("A");
        a.left = new ArrayList<>();
        a.right = new ArrayList<>();
        a.left.add(b);
        a.right.add(c);

        return a;
    }

    private static class Node {
        private String value;
        private List<Node> left;
        private List<Node> right;
        private boolean printed;
        public Node(String value) {
            this.value = value;
        }
    }
}
