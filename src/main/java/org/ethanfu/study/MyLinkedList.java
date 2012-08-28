package org.ethanfu.study;

import java.util.Iterator;

/**
 * 主要用于理解链表实现，
 * 
 * @author ethanfu
 * 
 */
public class MyLinkedList<E> implements Iterable<E> {

	private Node<E> header;
	private int size;
	public MyLinkedList() {
		header.pre = header.next = header;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		
		return false;
	}
	
	public boolean add(E e){
		
		return true;
	}
	
	private static class Node<E> {
		public Node(E obj, Node<E> p, Node<E> n) {
			this.data = obj;
			this.pre = p;
			this.next = n;
		}

		public E data;
		public Node<E> pre;
		public Node<E> next;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

}
