package com.db.my_spring;

import com.db.my_spring.annotations.InjectByType;
import com.db.my_spring.annotations.InjectRandomInt;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author IrinaTsekhanovich
 * @since 25.08.2021
 */
public class RobotFactory {

	private final ObjectFactory objectFactory;

	public RobotFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	@SneakyThrows
	public <T> T createRobot(Class<T> type) {

		T robot = type.getDeclaredConstructor().newInstance();

		Field[] fields = type.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(InjectByType.class)) {
				field.setAccessible(true);
				field.set(robot, objectFactory.createObject(field.getType()));
				field.setAccessible(false);
			}
		}

		return robot;
	}
}
