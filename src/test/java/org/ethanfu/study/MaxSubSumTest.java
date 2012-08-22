package org.ethanfu.study;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSubSumTest {

	@Test
	public void testMaxSubSum() {
		int[] a = {1,5,-1,2,-5,20,-5,2,3,-7,3,1,3};
		
		assertEquals(MaxSubSum.maxSubSum(a), 22);
	}

}
