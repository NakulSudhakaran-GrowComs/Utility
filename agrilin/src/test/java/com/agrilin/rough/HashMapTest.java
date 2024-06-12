package com.agrilin.rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {

		//List<Map<String,String>> listMap=new ArrayList<Map<String,String>>();
		Map<String,String>hashMap1=new HashMap<String, String>();
		//Map<String,String>hashMap2=new HashMap<String, String>();
		String name="Name..";
		hashMap1.put("ABC", "123");
		hashMap1.put("DEF", "345");
		hashMap1.put("GHI", "567");
		hashMap1.put("ABC", "789");
		hashMap1.put("JKL", "123");
		
		 System.out.println("Customer Name: "+name);
		for (Map.Entry<String, String> set :
            hashMap1.entrySet()) {
           System.out.println("\t"+set.getKey() + ":"
                              + set.getValue());
		}
		setData(name,hashMap1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		hashMap2.put("jhjhk", "980u09");
//		hashMap2.put("vjjfhj", "08080");
//		hashMap2.put("ghjgjg", "0090j");
//		hashMap2.put("jljlkjl", "98989");
//		hashMap2.put("hgjgkj", "098098");
//		
//		listMap.add(hashMap1);
//		listMap.add(hashMap2);
//		
//		for(int i=0;i<listMap.size();i++) {
//			 for (Map.Entry<String, String> set :
//	             foodTable.entrySet()) {
//	 
//	            // Printing all elements of a Map
//	            System.out.println(set.getKey() + " = "
//	                               + set.getValue());
//		}
//		System.out.println(hashMap1);
//		System.out.println(listMap);
//		
	}

	private static void setData(String name, Map<String, String> hashMap1) {
	
		String userName=name;
		Map<String,String> map=new HashMap<String, String>(hashMap1);
		List<String> list=new ArrayList<String>();
		list.add(userName);
		//list.addAll(map);
	}

}
