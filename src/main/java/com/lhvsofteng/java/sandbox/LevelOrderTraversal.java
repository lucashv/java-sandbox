package com.lhvsofteng.java.sandbox;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    private Node tree;

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();

        lot.startTree();

        System.out.println("Hello");
        System.out.println("This is tree: " + lot.tree);

        lot.printNode(lot.tree);

        System.out.println("--------------");

        int treeHeight = lot.getTreeHeight(lot.tree);
        System.out.println("Tree height: " + treeHeight);

        for (int i = 1; i <= treeHeight; i++)
            lot.traverseNode(lot.tree, i);

        System.out.println("\nThe other way: ");
        lot.otherWay(lot.tree);
    }

    private void otherWay(Node node) {
        System.out.print(node.data + " ");

        List<Node> children = new ArrayList<>();

        children.add(node.left);
        children.add(node.right);

        while (!children.isEmpty()) {
            Node[] nodes = children.toArray(new Node[] {});
            children.clear();
            for (int i = 0; i < nodes.length; i++) {
                System.out.print(nodes[i].data + " ");
                if (nodes[i].left != null)
                    children.add(nodes[i].left);
                if (nodes[i].right != null)
                    children.add(nodes[i].right);
            }
        }
    }

    private int getTreeHeight(Node node) {
        if (node == null)
            return 0;

        int lheight = getTreeHeight(node.left);
        int rheight = getTreeHeight(node.right);

        if (lheight > rheight)
            return lheight + 1;
        else
            return rheight + 1;
    }

    private void traverseNode(Node node, int level) {
        if (node == null)
            return;

        if (level == 1)
            System.out.print(node.data + " ");
        else if (level > 1) {
            traverseNode(node.left, level - 1);
            traverseNode(node.right, level - 1);
        }
    }

    private void printNode(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        if (node.left != null)
            printNode(node.left);
        if (node.right != null)
            printNode(node.right);
    }

    private void startTree() {
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        Node node2 = new Node(2);
        node2.left = node4;
        node2.right = node5;

        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node7.left = new Node(8);
        node7.left.right = new Node(9);

        Node node3 = new Node (3);
        node3.left = node6;
        node3.right = node7;

        tree = new Node(1);
        tree.left = node2;
        tree.right = node3;
    }

    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}