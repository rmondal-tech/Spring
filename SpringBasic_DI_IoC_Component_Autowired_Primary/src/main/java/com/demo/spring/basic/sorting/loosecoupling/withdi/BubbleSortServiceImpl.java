package com.demo.spring.basic.sorting.loosecoupling.withdi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortServiceImpl implements ISortServiceWithDI{

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
		System.out.println("result from buttbol sort with DI set up");
		return new int[] {1,3,5,7,10};
	}

}
