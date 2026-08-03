package com.sunbeam.practice;

public class BoxImpl implements Box {
	private double length;
	private double height;
	private double breadth;
	
	
	public BoxImpl(double length, double height, double breadth) {
		super();
		this.length = length;
		this.height = height;
		this.breadth = breadth;
	}

	public BoxImpl() {
		super();
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	public double calArea() {
		return length * breadth;
	}
	
	public double calVolume() {
		return length*breadth*height;
	}
	
}
