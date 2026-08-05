package com.sunbeam.bank;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//Ensures that , this converter is used
// 				for  Strings "p1/p2" will be Converted into Person Object
@ConfigurationPropertiesBinding //Working this Annotation
@Component
public class PersonalConverter implements Converter<String, Person>,
ApplicationContextAware{

	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}

	@Override
	public Person convert(String beanName) {
		Person p = (Person) ctx.getBean(beanName);
		return p;
	}
}
