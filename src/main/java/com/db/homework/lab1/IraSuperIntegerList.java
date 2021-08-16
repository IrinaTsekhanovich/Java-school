package com.db.homework.lab1;

/**
 * @author IrinaTsekhanovich
 * @since 16.08.2021
 */
public class IraSuperIntegerList implements SuperIntegerList {
	private int[] array;

	public IraSuperIntegerList() {
		array = new int[0];
	}

	public void add(int number) {
		int arrayLength = array.length;
		int[] newArray = new int[arrayLength + 1];
		System.arraycopy(array, 0, newArray, 0, arrayLength);
		newArray[arrayLength] = number;
		array = newArray;
	}

	public void removeByIndex(int index) {
		int arrayLength = array.length;
		if (index >= 0 && index < arrayLength) {
			int[] newArray = new int[arrayLength - 1];
			System.arraycopy(array, 0, newArray, 0, index);
			if (arrayLength - 1 - index + 1 >= 0) {
				System.arraycopy(array, index + 1, newArray, index, arrayLength - index - 1);
			}
			array = newArray;
		}
	}

	public void removeByValue(int value) {
		int arrayLength = array.length;
		int[] newArray = new int[arrayLength];
		int newLength = 0;
		for (int intValue : array) {
			if (intValue != value) {
				newArray[newLength] = intValue;
				newLength++;
			}
		}
		array = new int[newLength];
		if (newLength >= 0) {
			System.arraycopy(newArray, 0, array, 0, newLength);
		}
	}

	public int get(int index) {
		return index >= 0 && index < array.length ? array[index] : index;
	}

	public void printAll() {
		for (int intValue : array) {
			System.out.println(intValue);
		}
	}
}
