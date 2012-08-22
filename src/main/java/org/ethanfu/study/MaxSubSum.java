package org.ethanfu.study;

public class MaxSubSum {

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
