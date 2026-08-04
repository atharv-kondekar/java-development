package com.sunbeam.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BoxImpl implements Box , BeanNameAware,InitializingBean
,DisposableBean,ApplicationContextAware{
	private double length;
	private double breadth;
	private double height;

	private String beanName;
	@Override
	public void setBeanName(String name) {
		this.beanName=name;
		System.out.println(this.beanName+" - BeanNameAware.setbeanName()");
	}

	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
		System.out.println(this.beanName+" - ApplicationContextAware.setApplicationContext()");
	}
	@PostConstruct
	void setDB() {
		System.out.println(this.beanName+" - @PostConstruct - DB Connection ✅");

	}

	@PreDestroy
	void closeDB() {
		System.out.println(this.beanName+"- @PreDestroy - DB Connection Closed");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this.beanName+" - InitializingBean.afterPropertiesSet()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(this.beanName+" - DisposableBean.destroy()");
	}

	public BoxImpl() {
		System.out.println("-BoxImpl()");
		super();
	}

	public BoxImpl(double length, double breadth, double height) {
		super();
		System.out.println("-BoxImpl(double,double,double)");
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	public double getLength() {
		System.out.println("-BoxImpl() - getLength()");
		return length;
	}

	public void setLength(double length) {
		System.out.println("-BoxImpl() - setLength()");
		this.length = length;
	}

	public double getBreadth() {
		System.out.println("-BoxImpl() - getBreadth()");
		return breadth;
	}

	public void setBreadth(double breadth) {
		System.out.println("-BoxImpl() - setBreadth()");
		this.breadth = breadth;
	}

	public double getHeight() {
		System.out.println("-BoxImpl() - getHeight()");
		return height;
	}

	public void setHeight(double height) {
		System.out.println("-BoxImpl() - setHeight()");
		this.height = height;
	}

	@Override
	public String toString() {
		return "BoxImpl [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}

	public double calVolume(){
		return this.length*this.breadth*this.height;
	}

}
