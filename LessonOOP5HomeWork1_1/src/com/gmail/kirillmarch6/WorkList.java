package com.gmail.kirillmarch6;

import java.util.ArrayList;
import java.util.List;

public class WorkList {

	public void WorkWithList() {
		
		List<Object> myList = new ArrayList<>();		
		for (int i = 0; i < 10; i++) {
			myList.add(i + "-й элемент");
		}		
		myList.remove(myList.size() - myList.size());
		myList.remove(myList.size() - myList.size());
		myList.remove(myList.size()-1);	
		System.out.println(myList.toString());				
	}
}
