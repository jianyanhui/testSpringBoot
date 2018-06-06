package com.example.demo.kaoshi;

import java.util.Calendar;

public class SimpleTest {

	public static void setValue(int value) {
		value++;
	}
	public static void setValue(Calendar value) {
		value.set(Calendar.YEAR, 2009);
	}
	public static void main(String[] args) {
		int i = 10;
		SimpleTest.setValue(i);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2000);
		SimpleTest.setValue(cal);
		System.out.print(i + "-" + cal.get(Calendar.YEAR));
		System.out.println(Math.round(-7.5));
	}


}
