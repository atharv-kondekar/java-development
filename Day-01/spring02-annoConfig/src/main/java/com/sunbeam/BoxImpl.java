package com.sunbeam;

public class BoxImpl {
	private int length;
	private int breadth;
	private int height;

	
	
	public BoxImpl() {
		super();
	}
	public int getLength() {
		System.out.println("getLenght() Called");
		return length;
	}
	public void setLength(int length) {
		System.out.println("setlength() Called");
		this.length = length;
	}
	public int getBreadth() {
		System.out.println("getbreadth() Called");
		return breadth;
	}
	public void setBreadth(int breadth) {
		System.out.println("setbreadth() Called");
		this.breadth = breadth;
	}
	public int getHeight() {
		System.out.println("getHeight() Called");
		return height;
	}
	public void setHeight(int height) {
		System.out.println("setheight() Called");
		this.height = height;
	}
	
	public BoxImpl(int length, int breadth, int height) {
		super();
		System.out.println("BoxImpl(int,int,int) Called");
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	
	public int calVolume() {
		return this.length*this.breadth*this.height;
	}
	
	public int  calArea() {
		return this.breadth*this.length;
	}
	
}
