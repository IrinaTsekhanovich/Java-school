package com.db.homework.lab1;

/**
 * @author IrinaTsekhanovich
 * @since 16.08.2021
 */
public class Start {
	public static void main(String[] args) {
		SuperIntegerList myList = new IraSuperIntegerList();
		myList.add(5);
		myList.printAll();
		for (int i = 3; i < 10; i++) {
			myList.add(i);
		}
		myList.get(2);
		myList.printAll();
		System.out.println("let's remove value 5");
		myList.removeByValue(5);
		myList.printAll();
		System.out.println("let's remove by index 3");
		myList.removeByIndex(3);
		myList.printAll();
		myList.removeByIndex(111);
		myList.removeByValue(111);
		myList.printAll();
	}
}
