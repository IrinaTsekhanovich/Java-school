package com.db.classwork.java8;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

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


	public static List<String> getEmployeesNamesSortedBySalary(List<Employee> employees) {
		return employees.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
				.map(Employee::getName)
				.collect(Collectors.toList());
//		return employees.stream().sorted((e1,e2)-> e2.getSalary()- e1.getSalary()).map(Employee::getName)
//				.collect(Collectors.toList());
	}

	public static Map<String, Employee> getEmployeesMap(List<Employee> employees) {
		return employees.stream().collect(Collectors.toMap(Employee::getName, Function.identity(),
				(e1, e2) -> e1.getSalary()> e2.getSalary()?e1:e2));
	}

	public static Seniority getSeniority(Employee employee) {
		int salary = employee.getSalary();
		return Arrays.stream(Seniority.values())
				.filter(s -> s.getMaxSalary()>=salary && s.getMinSalary()<=salary)
				.findAny()
				.get();
	}

	public static Map<Seniority,Long> groupBySeniority(List<Employee> employees){
		return employees.stream().collect(Collectors.groupingBy(Main::getSeniority,Collectors.counting()));
	}

	@SneakyThrows
	public static void main(String[] args) {
		Path path = Paths.get("data/song.txt");

		long count = Files.lines(path).flatMap(s -> Arrays.stream(s.trim().split(" "))).count();
		System.out.println(count);

		Employee ira = new Employee("Ira", 9);
		Employee vasya = new Employee("Vasya", 15);
		Employee kir = new Employee("Kir", 13);
		Employee ira1 = new Employee("Ira", 25);

		List<Employee> employees = List.of(ira, vasya, kir, ira1);
		System.out.println(getEmployeesNamesSortedBySalary(employees));
		System.out.println(getEmployeesMap(employees));
		System.out.println(groupBySeniority(employees));
	}
}
