package edu.nsu;


import edu.nsu.LinkedListImpl;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.insertNode(12);
        linkedList.insertNode(24);
        linkedList.insertNode(44);
        linkedList.insertNode(-1);
        linkedList.displayLinkedList();

    }
}
