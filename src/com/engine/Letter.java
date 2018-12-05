package com.engine;

public class Letter {
int id;
int x;
int y;
int width;
int height;
int xoffset;
int yoffset;
int xadvance;
int yadvance;
public Letter(int id, int x, int y, int width, int height, int xoffset, int yoffset, int xadvance, int yadvance) {
	this.id = id;
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.xoffset = xoffset;
	this.yoffset = yoffset;
	this.xadvance = xadvance;
	this.yadvance = yadvance;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getXoffset() {
	return xoffset;
}
public void setXoffset(int xoffset) {
	this.xoffset = xoffset;
}
public int getYoffset() {
	return yoffset;
}
public void setYoffset(int yoffset) {
	this.yoffset = yoffset;
}
public int getXadvance() {
	return xadvance;
}
public void setXadvance(int xadvance) {
	this.xadvance = xadvance;
}
public int getYadvance() {
	return yadvance;
}
public void setYadvance(int yadvance) {
	this.yadvance = yadvance;
}

}
