package com.db.my_spring;

/**
 * @author IrinaTsekhanovich
 * @since 25.08.2021
 */
public class Utils {

	public static int randomInRange(int min, int max) {
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
}
