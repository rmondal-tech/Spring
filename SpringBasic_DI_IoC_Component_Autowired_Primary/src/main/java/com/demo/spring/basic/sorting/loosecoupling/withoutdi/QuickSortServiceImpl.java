package com.demo.spring.basic.sorting.loosecoupling.withoutdi;

public class QuickSortServiceImpl implements ISortService{

/*public int[] quickSort(int[] numbersToSort) {
		
	//logic for quick sort	
		return new int[] {1,3,5,7,10,};	
	}
*/
	
	
//For Loose Coupling	
	
	@Override
	public int[] sortSort(int[] numbersToSort) {
		// TODO Auto-generated method stub
		System.out.println("result from quick sort");
		return new int[] {1,3,5,7,10,};	
	}

}
