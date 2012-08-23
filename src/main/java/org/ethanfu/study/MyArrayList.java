package org.ethanfu.study;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author ethanfu
 *
 * @param <T>
 */
public class MyArrayList<T> implements Iterable<T>{
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private transient Object[] theItems;

	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}
	public MyArrayList(int initialCapacity) {
		if(initialCapacity<0) 
			throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
		this.theItems = new Object[initialCapacity];
		this.theSize = this.theItems.length;
	}
	
	public void clear(){
		for (int i = 0; i < theSize; i++){
			theItems[i] = null;
		}
		theSize = 0 ;
		
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index){
		return (T)theItems[index];
	}
	
	@SuppressWarnings("unchecked")
	public T set(int index,T newValue){
		if(index<0 && index > theSize)
			throw new ArrayIndexOutOfBoundsException();
		T oldValue = (T)theItems[index];
		theItems[index] = newValue;
		return oldValue;
	}
	
	public boolean add(T newValue){
		ensureCapacity(theSize+1);
		theItems[theSize++] = newValue;
		return true;
	}
	
	public void add(int index,T newValue){
		if(index <0 || index > theSize)
			throw new IndexOutOfBoundsException();
		ensureCapacity(theSize+1);
		System.arraycopy(theItems, index, theItems, index+1, theSize-index);
		theItems[index] = newValue;
		theSize ++;
	}
	
	public void remove(int index){
		System.arraycopy(theItems, index+1, theItems, index-1, theSize-index);
		theItems[theSize] = null;
	}
	
	public int size(){
		return theSize;
	}
	
	public void ensureCapacity(int newCapacity){
		if(newCapacity<theSize)
			return ;
		Object[] returnObj = theItems;
		theItems = new Object[DEFAULT_CAPACITY];
		
	}

	@Override
	public Iterator<T> iterator() {
		
		return new MyArrayListIterator<T>();
	}
	
	private class MyArrayListIterator<E> implements Iterator<E>{

		private int current = 0;
		@Override
		public boolean hasNext() {
			return current<theSize;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException();
			return (E) theItems[current++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
