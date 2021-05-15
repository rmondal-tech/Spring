package com.demo.spring.basic.sorting.tightcoupling;

import com.demo.spring.basic.sorting.tightcoupling.service.BubbleSortServiceImpl;
import com.demo.spring.basic.sorting.tightcoupling.service.QuickSortServiceImpl;

public class SortAlgorithmWithExOfTightCoupling {

	public int[] sort(int[] numbersToSort) {
		
		// TODO Auto-generated method stub
		int[] sortResult;
		//Tight Coupling
		BubbleSortServiceImpl bubbleSortServiceImpl=new BubbleSortServiceImpl();
		sortResult= bubbleSortServiceImpl.bubbleSort(numbersToSort);
		
		//Tight Coupling
		QuickSortServiceImpl quickSortServiceImpl=new QuickSortServiceImpl();
		sortResult= quickSortServiceImpl.quickSort(numbersToSort);
		
		return sortResult;
		
	}

	

	
}
