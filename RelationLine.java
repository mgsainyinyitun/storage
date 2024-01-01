package com.app.object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RelationLine {
	
	private int startX = 0;
	private int startY = 0;
	
	public double getControlX1() {
		return controlX1;
	}

	public void setControlX1(double controlX1) {
		this.controlX1 = controlX1;
	}

	public double getControlY1() {
		return controlY1;
	}

	public void setControlY1(double controlY1) {
		this.controlY1 = controlY1;
	}

	public double getControlX2() {
		return controlX2;
	}

	public void setControlX2(double controlX2) {
		this.controlX2 = controlX2;
	}

	public double getControlY2() {
		return controlY2;
	}

	public void setControlY2(double controlY2) {
		this.controlY2 = controlY2;
	}

	private double controlX1 = 0;
	private double controlY1 = 0;
	private double controlX2 = 0;
	private double controlY2 = 0;
	
	private int endX = 0;
	private int endY = 0;
	
	public RelationLine(TextRectangle tf,TextRectangle ts) {
		this.startX = tf.getRightCenterPoint().getX();
		this.startY = tf.getRightCenterPoint().getY();
		this.endX = ts.getLeftCenterPoint().getX();
		this.endY = ts.getLeftCenterPoint().getY();
		computeControlPoint();
	}
	
	public RelationLine(TextRectangle tf,TextRectangle ts,double ctlx1,double ctly1,double ctlx2,double ctly2) {
		this.startX = tf.getRightCenterPoint().getX();
		this.startY = tf.getRightCenterPoint().getY();
		this.endX = ts.getLeftCenterPoint().getX();
		this.endY = ts.getLeftCenterPoint().getY();
		
		System.out.println("("+startX+","+startY+") && (" + endX + ","+endY+")");
		
		this.controlX1 = ctlx1;
		this.controlY1 = ctly1;
		this.controlX2 = ctlx2;
		this.controlY2 = ctly2;
	}
	
	public void draw(GraphicsContext gc) {
		gc.setStroke(Color.RED);
		gc.setLineWidth(2.0);
		gc.beginPath();
		gc.moveTo(startX, startY);
		gc.bezierCurveTo(controlX1, controlY1, controlX2, controlY2, endX, endY);
		gc.stroke();
	}
	
	private void computeControlPoint() {
		int factor = endX-startX;
		this.controlY1 = this.startY;
		this.controlY2 = this.endY;
		this.controlX1 = this.startX+factor;
		this.controlX2 = this.endX-factor;
	}
}
