package com.okdaracourses.linkedlist;

public class ReverseLinkedList {
    public class Node {
        int val;
        Node next;
        Node(int x) { val = x; }
    }

    public Node reverseList(Node head) {
        if (head == null){
            return null;
        }
        Node prev = null;
        Node current = head;
        while(current.next != null){
            Node tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        current.next = prev;
        return current;
    }
}
