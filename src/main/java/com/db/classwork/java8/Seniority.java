package com.db.classwork.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO Class Description
 *
 * @author IrinaTsekhanovich
 * @since 24.08.2021
 */
@AllArgsConstructor
@Getter
public enum Seniority {
	JUN(0,10), MIDDLE(11,20), SENIOR(21,Integer.MAX_VALUE);
	private int minSalary;
	private int maxSalary;
}
