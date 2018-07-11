package com.yk.tool;

import javax.swing.JLabel;

import com.yk.Level.XJLabel;

public class CollisionDetection {
	// 触碰事件
	public static boolean setCollInit(JLabel j1, JLabel j2) {
		// first object begin x and last x
		int ax1 = j1.getX();
		int ax2 = j1.getX() + j1.getWidth();
		// first object bengin y and last y
		int ay1 = j1.getY();
		int ay2 = j1.getY() + j1.getHeight();
		// second object...
		int bx1 = j2.getX() + 10;
		int bx2 = j2.getX() + j2.getWidth() - 10;

		int by1 = j2.getY() + 10;
		int by2 = j2.getY() + j2.getHeight() - 10;
		if ((ax1 > bx1 && ax1 < bx2) || (ax2 > bx1 && ax2 < bx2)) {
			if ((ay1 > by1 && ay1 < by2) || (ay2 > by1 && ay2 < by2)) {
				if (j2.isVisible() && j1.isVisible()) {
					return true;
				}

			}
		}
		return false;
	}

	public static XJLabel setCollInit(JLabel j1, XJLabel[] j2) {
		if (j2 != null) {
			for (int i = 0; i < j2.length; i++) {
				if (setCollInit(j1, j2[i])) {
					return j2[i];
				}
			}
		}

		return null;
	}

}
