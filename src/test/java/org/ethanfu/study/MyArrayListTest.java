package org.ethanfu.study;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MyArrayListTest {

	@Test
	public void testSet() {
		MyArrayList<String> array = new MyArrayList<String>();
		array.set(0, "test");
//		ArrayList list ;
		assertEquals(array.get(0),"test");
		assertEquals(array.size(),10);
	}

}
