package com.app.object;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {

	List<Rectangle> children = new ArrayList<Rectangle>();

	public void addChildrenNode(Rectangle r) {

		this.children.add(r);
	}

	public int getMaxNodeNumber(Rectangle rs) {
		int maxNodeNumber = 0;

		if (rs.children.size() > 0) {
	
			for (Rectangle r : rs.children) {
				if(r.children.size()>maxNodeNumber) {
					maxNodeNumber = r.children.size();
				}
			}
			
		}else {
			return maxNodeNumber;
		}
		return maxNodeNumber;
	}
}
