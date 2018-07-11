package com.yk.tool;

import java.awt.Component;
import java.awt.event.MouseEvent; 
import java.awt.event.MouseMotionListener;

public class FormMove {
	//窗体移动
	private int x,y;
	public void setMove(final Component com)
	{
		com.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
			public void mouseDragged(MouseEvent e) {
				com.setLocation(e.getX()+com.getX()-x,e.getY()+com.getY()-y);
			}
		});
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
