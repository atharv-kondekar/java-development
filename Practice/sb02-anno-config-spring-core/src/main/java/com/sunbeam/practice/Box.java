package com.sunbeam.practice;

public interface Box {
	void setLength(double length);
	void setBreadth(double breadth);
	void setHeight(double height);
	
	double getLength();
	double getHeight();
	double getBreadth();
	
	double calArea();
	double calVolume();
}
