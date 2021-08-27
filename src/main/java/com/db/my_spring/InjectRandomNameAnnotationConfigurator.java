package com.db.my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author IrinaTsekhanovich
 * @since 27.08.2021
 */
public class InjectRandomNameAnnotationConfigurator implements ObjectConfigurator{
	@Override
	@SneakyThrows
	public void configure(Object t) {
		Class<?> type = t.getClass();
		for (Field field : type.getDeclaredFields()) {
			InjectRandomName annotation = field.getAnnotation(InjectRandomName.class);
			if(annotation!=null){
				field.setAccessible(true);
				field.set(t, RandomUtil.randomName());
			}
		}

	}
}
