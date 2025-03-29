package com.lhvsofteng.java.sandbox;

// This problem was asked by Google.
// Given the head of a singly linked list, reverse it in-place.
public class InverseSinglyLinkedList {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    Node head = new Node(list, 1);
    head.next = new Node(list, 2);
    head.next.next = new Node(list, 3);
    head.next.next.next = new Node(list, 4);
    head.next.next.next.next = new Node(list, 5);
    list.head = head;
    list.tail = head.next.next.next.next;

    list.printHeadAndTail();
    list.printList();
    list.inverseList();
    list.printList();
    list.printHeadAndTail();
  }

  public static class LinkedList {
    Node head;
    Node tail;

    public void printHeadAndTail() {
      System.out.println("Head: " + this.head.value + "; Tail: " + this.tail.value);
    }

    public void inverseList() {
      Node head = this.head;
      this.doInverseList(head);
    }

    private Node doInverseList(Node node) {
      if (node.next == null) {
        node.owner.head = node;
        return node;
      }

      Node newNode = doInverseList(node.next);
      newNode.next = node;

      if (newNode.value == node.next.value) {
        node.owner.tail = node;
        node.next = null;
      }

      return node;
    }

    public void printList() {
      Node n = this.head;
      while (n != null) {
        System.out.print(n.value + " ");
        n = n.next;
      }
      System.out.println();
    }
  }

  public static class Node {
    LinkedList owner;
    int value;
    Node next;

    public Node(LinkedList owner, int value) {
      this.owner = owner;
      this.value = value;
    }
  }
}
