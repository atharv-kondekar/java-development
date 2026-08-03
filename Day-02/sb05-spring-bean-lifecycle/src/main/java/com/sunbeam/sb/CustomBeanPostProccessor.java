package com.sunbeam.sb;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProccessor implements BeanPostProcessor{
	@Override
	public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if(bean instanceof Box)
			System.out.println(beanName + " - BeanPostProcessor.postProcessBeforeInitialization()");
		return bean;
	}
	
	@Override
	public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if(bean instanceof Box)
			System.out.println(beanName + " - BeanPostProcessor.postProcessAfterInitialization()");
		return bean;
	}
}