package com.sunbeam.practice;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class CustomBeanPostProcessor implements BeanPostProcessor
,BeanNameAware{

	private String beanName;
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	@Override
	public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Box)
			System.out.println(this.beanName+" - BeanPostProcessor.postProcessBeforeInitialization()");
		return bean;
	}

	@Override
	public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Box)
			System.out.println(this.beanName+" - BeanPostProcessor.postProcessAfterInitialization()");
		return bean;
	}
}
