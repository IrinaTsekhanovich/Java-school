package com.db.homework.lab1;

/**
 * @author IrinaTsekhanovich
 * @since 16.08.2021
 */
public interface SuperIntegerList {

	void add(int number);

	void removeByIndex(int index);

	void removeByValue(int value);

	int get(int index);

	void printAll();
}
