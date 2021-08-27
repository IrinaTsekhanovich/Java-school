package com.db.my_spring;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

/**
 * @author IrinaTsekhanovich
 * @since 26.08.2021
 */
public class RandomUtil {
	private static Random random = new Random();
	private static Faker faker = new Faker();


	public static <T> T getRandomElement(List<T> list) {
		int i = RandomUtil.between(0, list.size()-1);
		return list.get(i);
	}

	public static int between(int min, int max) {
		return min + random.nextInt(max - min + 1);
	}


	public static String randomName() {
		return faker.gameOfThrones().character();
	}
}