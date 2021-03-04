/**
  * Copyright 2020 bejson.com 
  */
package com.example.demo.entity;

/**
 * Auto-generated: 2020-09-21 22:42:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private double top;
    private double left;
    private double width;
    private double height;
    private String text;
    public void setTop(double top) {
         this.top = top;
     }
     public double getTop() {
         return top;
     }

    public void setLeft(double left) {
         this.left = left;
     }
     public double getLeft() {
         return left;
     }

    public void setWidth(double width) {
         this.width = width;
     }
     public double getWidth() {
         return width;
     }

    public void setHeight(double height) {
         this.height = height;
     }
     public double getHeight() {
         return height;
     }

    public void setText(String text) {
         this.text = text;
     }
     public String getText() {
         return text;
     }
	@Override
	public String toString() {
		return "Data [top=" + top + ", left=" + left + ", width=" + width + ", height=" + height + ", text=" + text
				+ "]";
	}

}