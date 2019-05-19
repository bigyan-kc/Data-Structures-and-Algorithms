package edu.nsu.datastructures;

import java.util.ArrayList;


public class HashMap {

	public class Key {
		String key;

		Key(String key){
			this.key = key;
		}

		@Override
		public int hashCode(){
			return (int) key.charAt(0);
		}

		@Override
		public boolean equals(Object o){
			Key myKey = (Key) o;
			return(myKey.key.equals(this.key));
		}
	}
	public class Node {

		Key k;
		int value;
		int hash;
		Node next;

		Node(Key k, int value){
			this.k = k;
			this.value = value;
			this.hash = k.hashCode();
			next = null;
		}
	}
	
	private int size = 0;
	private final int INITIAL_CAPACITY = 16;
	private ArrayList <Node> myHashMap;
	
	public HashMap(){
		myHashMap = new ArrayList<Node>();
		for(int  i = 0; i < INITIAL_CAPACITY; i++){
			myHashMap.add(null);
		}
	}

	/**
	 * Insert the node in HashMap
	 * @param key
	 * @param value
	 * @return the value of the inserted node
	 */
	public int put(String key, int value){
		Key k = new Key(key);
		Node newNode = new Node(k, value);
		int index = findIndex(newNode.hash);
		if(myHashMap.get(index) == null){
			myHashMap.set(index, newNode);
			++size;
			return newNode.value;
		}
		else{
			Node head = myHashMap.get(index);
			Node prev = head;
			while(head != null){
				prev = head;
				if(head.k.equals(k)){
					head.value = value;
					return newNode.value;
				}
				head = head.next;
			}
			prev.next = newNode;
			++size;
			return newNode.value;
		}
		
		
	}

	/**
	 * Returns the size of HashMap
	 * @return Size of HashMap
	 */
	public int size(){
		return size;
	}

	/**
	 * Get the value from the HashMap
	 * @param key of the HashMap
	 * @return Value associated with Key if exists else -1
	 */
	public int get(String key){
		Key k = new Key(key);
		int index = findIndex(k.hashCode());
		Node firstItem = myHashMap.get(index);
		while(firstItem != null){
			if(firstItem.k.equals(k)) return firstItem.value;
			else firstItem = firstItem.next;
		}
		return -1;
	}

	/**
	 * Removes the mapping for the specified key if present
	 * @param key whose mapping is to be removed
	 * @return the value associated with the Key
	 */
	public int remove(String key){
		Key k = new Key(key);
		int index = findIndex(k.hashCode());
		Node firstItem = myHashMap.get(index);

		if(firstItem == null) return -1;

		if(firstItem.k.equals(k)){
			myHashMap.set(index, firstItem.next);
			size--;
			return firstItem.value;
		}
			while(firstItem.next != null){
				if(firstItem.next.k.equals(k)){
					int removedValue = firstItem.next.value;
					firstItem.next = firstItem.next.next;
					size--;
					return removedValue;
				}
				firstItem = firstItem.next;
		}
		return -1;
	}

	public int findIndex(int hash){
		return hash % INITIAL_CAPACITY;
	}
}
