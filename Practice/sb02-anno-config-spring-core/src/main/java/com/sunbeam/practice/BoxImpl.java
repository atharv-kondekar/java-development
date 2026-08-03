package com.sunbeam.practice;

public class BoxImpl implements Box {

	private double length;
	private double breadth;
	private double height;
	
	public BoxImpl() {
		super();
	}

	public BoxImpl(double length, double breadth, double height) {
		super();
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	@Override
	public String toString() {
		return "BoxImpl [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double calArea() {
		// TODO Auto-generated method stub
		return length*breadth;
	}

	@Override
	public double calVolume() {
		// TODO Auto-generated method stub
		return length*breadth*height;
	}

}
