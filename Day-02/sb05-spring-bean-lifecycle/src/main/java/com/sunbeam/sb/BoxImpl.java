package com.sunbeam.sb;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BoxImpl implements Box , InitializingBean,DisposableBean,
BeanNameAware,ApplicationContextAware{
	
	private double length;
	private double breadth;
	private double height;
	
	
	private String beanName;
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println(this.beanName+" - BeanName.setBeanName()");
	}
	
	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx =applicationContext;
		System.out.println(this.beanName+" - ApplicationContextAware.setApplicationContext");
		
	}
	@PostConstruct
	void boxInit() {
		System.out.println(this.beanName+" - BOxImpl - custom init - @PostConstruct");
	}
	
	@PreDestroy
	void boxDestroy() {
		System.out.println(this.beanName+" - BoxImpl - custom destroy - @PreDestroy");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this.beanName+" - BoxImpl - InitializingBean.afterPropertiesSet()");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println(this.beanName+" - BoxImpl - DisposableBean.destroy()");	
	}
	
	
	public BoxImpl() {
		System.out.println("BoxImpl()");
		super();
	}
	
	public BoxImpl(double length, double breadth, double height) {
		super();
		this.length = length;
		this.breadth = breadth;
		this.height = height;
		System.out.println("BoxImpl(double,double,double)");
	}
	/**
	 * @return the length
	 */
	public double getLength() {
		System.out.println("BoxImpl - getLenth()");
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		System.out.println("BoxImpl - setLenth()");
		this.length = length;
	}
	/**
	 * @return the breadth
	 */
	public double getBreadth() {
		System.out.println("BoxImpl - getbreadth()");
		return breadth;
	}
	/**
	 * @param breadth the breadth to set
	 */
	public void setBreadth(double breadth) {
		System.out.println("BoxImpl - setvreadth()");
		this.breadth = breadth;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		System.out.println("BoxImpl - getHeight()");
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		System.out.println("BoxImpl - setHeight()");
		this.height = height;
	}
	@Override
	public String toString() {
		return "BoxImpl [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}
	
	@Override
	public double calVolume() {
		System.out.println("BoxImpl - calVolume()");
		return length*breadth*height;
	}
}
