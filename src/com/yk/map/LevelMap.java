package com.yk.map;

import javax.swing.JPanel;


public abstract interface LevelMap {
	abstract public JPanel setInitMap();
	abstract public JPanel getJp();
	abstract public void setDisplayJl();
	abstract public void clearThis();
	abstract public String getBoom();
}
