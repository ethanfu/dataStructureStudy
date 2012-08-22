package org.ethanfu.study;

public class MaxSubSum {

	/**
	 * 基本算最优算法，原理就是循环依次相加，只要相加结果大约max那么赋值给max，否则只有在相加之后结果小于0的时候清空thisSum
	 * @param a
	 * @return
	 */
	public static int maxSubSum(int[] a){
		
		int maxSum = 0,thisSum=0;
		
		for(int i=0; i<a.length; i++){
			thisSum += a[i];
			if(thisSum>maxSum){
				maxSum = thisSum;
			}else if(thisSum<0){
				thisSum = 0;
			}
		}
		return maxSum;
	}
}
