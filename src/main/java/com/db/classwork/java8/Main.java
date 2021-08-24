package com.db.classwork.java8;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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

	public static int salarySum(List<Employee> employees) {
		return employees.stream().mapToInt(Employee::getSalary).sum();
	}

	@SneakyThrows
	public static void main(String[] args) {
		Path path = Paths.get("data/song.txt");

		long count = Files.lines(path).flatMap(s -> Arrays.stream(s.trim().split(" "))).count();
		System.out.println(count);


	}
}
