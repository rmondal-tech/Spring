package com.demo.spring.basic.sorting.loosecoupling.withoutdi;

public class BubbleSortServiceImpl implements ISortService{

/*
	public int[] bubbleSort(int[] numbersToSort) {
		// TODO Auto-generated method stub
// logic for bubbol sorting
		return new int[] {1,3,5,7,10,};
	}
*/
	
//For Loose Coupling	
	@Override
	public int[] sortSort(int[] numbersToSort) {
		// TODO Auto-generated method stub
		System.out.println("result from buttbol sort");
		return new int[] {1,3,5,7,10};
	}

}
