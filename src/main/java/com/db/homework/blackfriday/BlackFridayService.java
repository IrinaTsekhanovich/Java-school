package com.db.homework.blackfriday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author IrinaTsekhanovich
 * @since 24.08.2021
 */
public class BlackFridayService {

	public static void main(String[] args) {
		printBlackFridayPerYearSorted(2015, 2021);
	}

	public static void printBlackFridayPerYearSorted(int startYear, int endYear) {

		LocalDate start =  LocalDate.of(startYear, Month.JANUARY, 1);
		Stream<LocalDate> dates = start.datesUntil(LocalDate.of(endYear, Month.DECEMBER, 31));

		Map<Integer, Long> blackFridayMap = dates.filter(d -> d.getDayOfMonth() == 13)
				.filter(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY)
				.collect(Collectors.groupingBy(LocalDate::getYear, Collectors.counting()));

		List<Entry<Integer, Long>> resultList = blackFridayMap.entrySet().stream()
				.sorted((e1,e2) -> (int) (e2.getValue()-e1.getValue())).collect(Collectors.toList());

		System.out.println(resultList);
	}
}
