package com.sunbeam.practice;

public interface Box {
	void setLength(double length);
	void setHeight(double height);
	void setBreadth(double breadth);
	
	double getLength();
	double getHeight();
	double getBreadth();
	
	double calVolume();
}
