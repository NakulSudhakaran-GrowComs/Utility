package com.agrilin.rough;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		list.add("Name 1.....");
		list.add("Value 1");
		list.add("Value 2");
		list.add("Value 3");
		list.add("Value 4");
		list.add("Value 5");
		list.add("Name 2......");
		list.add("Value 6");
		list.add("Value 7");
		list.add("Value 8");
		list.add("Value 9");
		list.add("Value 10");
		list.add("Name 3.......");
		list.add("Value 11");
		list.add("Value 12");
		list.add("Value 13");
		list.add("Value 14");
		list.add("Value 15");
		
		for(int i=0;i<list.size();) {
			System.out.println("Names are: "+list.get(i));
				for(int j=1;j<6;j++) {
				System.out.println(list.get(i+j));
				}
			i=i+6;
		}
		
		int i=5;
		String name="mani";
		String value=name+i+"Kumar";
		System.out.println(value);
		}
}
