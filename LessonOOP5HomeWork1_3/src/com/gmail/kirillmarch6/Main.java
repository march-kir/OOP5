package com.gmail.kirillmarch6;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		File file = new File("text.txt");
		Statistic stat = new Statistic(file);
		//stat.loadStringFromFile(file);
		
		
		
		stat.getCountLetters();
		//System.out.println(text);
	}

}
