package com.demo.spring.basic.sorting.loosecoupling.withdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



//import com.demo.spring.basic.sorting.tightcoupling.service.BubbleSortServiceImpl;
//import com.demo.spring.basic.sorting.tightcoupling.service.QuickSortServiceImpl;

@Component
public class SortAlgorithmWithExOfLooseCouplingWithDi {
@Autowired
ISortServiceWithDI iSortServiceWithDI;
//A{
//	B //calss A is dependent on class B
//}




	public int[] sort(int[] numbersToSort) {
		
		// TODO Auto-generated method stub
		int[] sortResult;
		
/*		
		//Tight Coupling
		BubbleSortServiceImpl bubbleSortServiceImpl=new BubbleSortServiceImpl();
		sortResult= bubbleSortServiceImpl.bubbleSort(numbersToSort);
		
		//Tight Coupling
		QuickSortServiceImpl quickSortServiceImpl=new QuickSortServiceImpl();
		sortResult= quickSortServiceImpl.quickSort(numbersToSort);
		
*/
	//	iSortService=new BubbleSortServiceImpl();
		
		sortResult=iSortServiceWithDI.sortSort(numbersToSort);
	
		
		return sortResult;
		
	}

}
