package com.db.design_patterns.never_use_switch;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

/**
 * TODO Class Description
 *
 * @author IrinaTsekhanovich
 * @since 20.08.2021
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
