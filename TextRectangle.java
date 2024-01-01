package com.app.object;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextRectangle extends Rectangle {
	/*
	 * on canvas , to draw text , get text width and height draw rectangle first
	 * draw text next
	 */

	private double width = 0;
	private double height = 0;
	private int x = 0;
	private int y = 0;
	private Text text;
	private String info;
	private int incFactor = 20;

	Font font = Font.font("Arial", 12);


	public TextRectangle(String info, int x, int y) {
		this.x = x;
		this.y = y;
		this.info = info;
		this.text = new Text(info);
		this.width = this.text.getLayoutBounds().getWidth() + incFactor;
		this.height = this.text.getLayoutBounds().getHeight() + incFactor;
	}

	public void draw(GraphicsContext gc) {
		// draw rectangle
		gc.setFill(Color.LIGHTGRAY);
		gc.fillRect(x, y, width, height);
		// draw text
		gc.setFont(font);
		gc.setFill(Color.BLACK);
		gc.fillText(this.info, 5 + x, 2+y + height / 2);
	}
	

	public Point getRightCenterPoint() {
		int w = (int) (this.x + this.width);
		int h = (int) (this.y + this.height/2);
		return new Point(w,h);	
	}
	
	public Point getLeftCenterPoint() {
		int w = (int) (this.x);
		int h = (int) (this.y + this.height/2);
		return new Point(w,h);
	}
	
	public void setPostionToRight(TextRectangle tr,int distance) {
		this.x = (int) (tr.x + tr.width +distance);
		this.y = (int) (tr.y);
	}

	public void setPostionToDown(TextRectangle tr,int distance) {
		this.x = (int) (tr.x);
		this.y = (int) (tr.y + tr.height + distance);
	}
	
	public void setPositionToRightDownDiagonal(TextRectangle tr,int distance) {
		this.x = (int) (tr.x + tr.width +distance);
		this.y = (int) (tr.y+tr.height + distance);
	}
	
	public void setPositionToRightUpDiagonal(TextRectangle tr,int distance) {
		this.x = (int) (tr.x + tr.width +distance);
		this.y = (int) (tr.y-tr.height-distance);
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeith() {
		return height;
	}

	public void setHeith(double heith) {
		this.height = heith;
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
}
