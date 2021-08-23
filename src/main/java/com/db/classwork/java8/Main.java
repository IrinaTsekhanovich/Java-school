package com.db.classwork.java8;

import java.util.List;
import java.util.function.Consumer;

/**
 * TODO Class Description
 *
 * @author IrinaTsekhanovich
 * @since 23.08.2021
 */
public class Main {
	public static <T> void ForEachWithDelay(List<T> list, int delay, Consumer<T> consumer) {
		list.forEach(t -> {
					consumer.accept(t);
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		);
	}

	public static void main(String[] args) {
		ForEachWithDelay(List.of(1,2,3,4,5), 1000, System.out::println);
	}
}
