package com.db.real_spring;

import com.db.my_spring.InjectRandomIntAnnotationObjectConfigurator;
import com.db.my_spring.InjectRandomNameAnnotationConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author IrinaTsekhanovich
 * @since 27.08.2021
 */
public class InjectRandomNameAnnotationBeanPostProcessor implements BeanPostProcessor {
	private InjectRandomNameAnnotationConfigurator configurator = new InjectRandomNameAnnotationConfigurator();
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		configurator.configure(bean);
		return bean;
	}
}
