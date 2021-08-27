package com.db.real_spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Objects;

/**
 * @author Evgeny Borisov
 */
public class BeanDefinitionValidatorBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(definitionName);
            if (Objects.equals(beanDefinition.getScope(), "prototype") && beanDefinition.getDestroyMethodName()!=null) {
                System.out.println("WARNING!!! Your prototype bean has destroy method!");
            }
        }
    }
}
