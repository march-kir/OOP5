package com.gmail.kirillmarch6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Statistic {

	private String text = "";
	private Map<Character, Double> collectionLetters = new HashMap<>();

	public Statistic(File file) {
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				text += sc.nextLine();
				text += System.lineSeparator();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<Character, Double> getCollectionLetters() {
		return collectionLetters;
	}

	public void setCollectionLetters(Map<Character, Double> collectionLetters) {
		this.collectionLetters = collectionLetters;
	}

	public void getCountLetters() {

		for (int i = 0; i < text.length(); i++) {
			Character symbol = text.charAt(i);
			symbol = Character.toLowerCase(symbol);
			if (Character.isLetter(symbol)) {
				if (!collectionLetters.containsKey(symbol)) {
					collectionLetters.put(symbol, 1.0);
				} else {
					collectionLetters.put(symbol, collectionLetters.get(symbol) + 1);
				}
			}
		}
		int totalLetters = 0;

		Set<Map.Entry<Character, Double>> set = collectionLetters.entrySet();
		for (Map.Entry<Character, Double> entry : set) {
			totalLetters += entry.getValue();
		}
		for (Map.Entry<Character, Double> entry : set) {
			collectionLetters.put(entry.getKey(), entry.getValue() / totalLetters * 100);
		}
		sortMap();

	}

	public void sortMap() {
		List statList = new ArrayList<>(collectionLetters.entrySet());
		Collections.sort(statList, new Comparator<Map.Entry<Double, Double>>() {
			@Override
			public int compare(Map.Entry<Double, Double> a, Map.Entry<Double, Double> b) {
				if (a.getValue() > b.getValue()) {
					return -1;
				} else if (a.getValue() < b.getValue()) {
					return 1;
				} else
					return 0;
			}
		});

		for (Object object : statList) {
			System.out.println(object);
		}
	}

}
