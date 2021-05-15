package com.demo.spring.basic.sorting.loosecoupling.withdi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Primary-bean should be given preference when multiple candidates are qualified to autowire
//Component- candidates for auto-detection when using annotation-based configuration and classpath scanning.
//Spring framework to manage dependencies on this class. 

@Component
public class QuickSortServiceImpl implements ISortServiceWithDI{


	
//For Loose Coupling	
	
	@Override
	public int[] sortSort(int[] numbersToSort) {
		// TODO Auto-generated method stub
		System.out.println("result from quick sort  with DI set up");
		return new int[] {1,3,5,7,10,};	
	}

}
