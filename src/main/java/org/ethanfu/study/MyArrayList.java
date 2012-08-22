package org.ethanfu.study;

import java.util.Iterator;

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
	public T get(int idx){
		return (T)theItems[idx];
	}
	
	@SuppressWarnings("unchecked")
	public T set(int idx,T newValue){
		if(idx<0 && idx > theSize)
			throw new ArrayIndexOutOfBoundsException();
		T oldValue = (T)theItems[idx];
		theItems[idx] = newValue;
		return oldValue;
	}
	
	public boolean add(T newValue){
		ensureCapacity(theSize+1);
		theItems[theSize++] = newValue;
		return true;
	}
	
	public void add(int idx,T newValue){
		if(idx <0 || idx > theSize)
			throw new IndexOutOfBoundsException();
		ensureCapacity(theSize+1);
		System.arraycopy(theItems, idx, theItems, idx+1, theSize-idx);
		theItems[idx] = newValue;
		theSize ++;
	}
	
	public void remove(){
		
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
		
		return null;
	}

}
