package com.bank;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@ConfigurationPropertiesBinding
@Component
public class PersnoalConverter implements Converter<String, Person>,
ApplicationContextAware{

	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx=applicationContext;
	}

	@Override
	public Person convert(String beanName) {
		Person p = (Person)ctx.getBean(beanName);
		return p;
	}
}
