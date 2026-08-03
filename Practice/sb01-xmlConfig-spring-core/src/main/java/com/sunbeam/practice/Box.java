package com.sunbeam.practice;

public interface Box {
	void setLength(double length);
	void setBreadth(double breadth);
	void setHeight(double height);
	
	double getLength();
	double getBreadth();
	double getHeight();
	
	double calArea();
	double calVolume();
}
