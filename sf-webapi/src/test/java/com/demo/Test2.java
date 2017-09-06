package com.demo;

import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException {
	 
		String str = "1  3   5    4";
		
		System.out.println(str.replaceAll("\\s+", " AND "));
		
		
	}

}
