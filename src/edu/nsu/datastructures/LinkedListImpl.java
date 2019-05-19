package edu.nsu.datastructures;

import java.util.HashSet;
import java.util.Set;

public class LinkedListImpl {
    Node head;

    public LinkedListImpl() {
        this.head = null;
    }

    public class Node {
        int data;
        Node next;

        Node(){
            next = null;
        }
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public Node insertNode(int data) {
        Node temp = this.head;
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return newNode;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return newNode;
    }

    public void displayLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int findFromLast(int n) {
        Node pointer1 = this.head;
        Node pointer2 = this.head;

        while (n - 1 > 0) {
            pointer2 = pointer2.next;
            n--;
        }
        while (pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1.data;
    }

    public void removeDuplicates() {
        Set<Integer> dataSet = new HashSet<>();
        Node temp = this.head;
        dataSet.add(temp.data);
        while (temp.next != null) {
            if (dataSet.contains(temp.next.data)) {
                temp.next = temp.next.next;
            } else {
                dataSet.add(temp.data);
                temp = temp.next;
            }
        }
    }

    public boolean removeNode(Node myNode) {
        Node temp = myNode;
        Node linkedListNode = myNode.next;
        myNode.data = linkedListNode.data;
        myNode.next = linkedListNode.next;

        return true;
    }

    public boolean isCorrupt(){
        boolean ifCorrupt = false;
        Node slow = this.head;
        Node fast = this.head;
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ifCorrupt = true;
                break;
            }

        }
        return ifCorrupt;
    }
}