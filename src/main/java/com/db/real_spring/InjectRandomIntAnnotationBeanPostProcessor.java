package com.db.real_spring;

import com.db.my_spring.InjectRandomIntAnnotationObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    private InjectRandomIntAnnotationObjectConfigurator configurator = new InjectRandomIntAnnotationObjectConfigurator();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        configurator.configure(bean);
        return bean;
    }
}
