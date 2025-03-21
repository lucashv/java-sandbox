package com.lhvsofteng.java.sandbox;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
  public static void main(String[] args) {
    var node3 = new ListNode(3);
    var node2 = new ListNode(2);
    var node0 = new ListNode(0);
    var nodem4 = new ListNode(-4);

    node3.next = node2;
    node2.next = node0;
    node0.next = nodem4;
    nodem4.next = node2;

    System.out.println(hasCycle(node3));
  }

  // Floyd's algorithm also known as Hare-Tortoise algorithm
  public static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (slow != null && fast != null) {
      slow = slow.next;
      fast = fast.next != null ? fast.next.next : fast.next;
      if (slow != null && slow.equals(fast)) return true;
    }

    return false;
  }

  public static boolean hasCycle2(ListNode head) {
    Set<ListNode> seen = new HashSet<>();
    while (head != null) {
      if (!seen.contains(head)) {
        seen.add(head);
        head = head.next;
      } else {
        return true;
      }
    }
    return false;
  }

  public static class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
      this.val = x;
      this.next = null;
    }
  }
}
