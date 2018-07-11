package com.yk.trajectory;


import com.yk.Level.XJLabel;
import com.yk.map.LevelMap;

public class BoosTraIndex {
	// boos的弹道选择
	public BoosTraIndex(String index, XJLabel xjl, LevelMap lm, String path) {
		switch (index) {
		case "LevelBullet":
			newLevelBullet(xjl, lm, path);
			break;
		case "LeftRightBullet":
			newLeftRightBullet(xjl, lm, path);
			break;
		case "DiffusionBullet":
			newDiffusionBullet(xjl, lm, path);
			break;
		case "SpiralBullet":
			newSpiralBullet(xjl, lm, path);
			break;
		case "ScatteringBullet":
			newScatteringBullet(xjl,lm,path);
			break;
		}
	}

	public void newLevelBullet(XJLabel xjl, LevelMap lm, String path) {
		 new LevelBullet(xjl, lm, path).initBulet();
	}

	public void newLeftRightBullet(XJLabel xjl, LevelMap lm, String path) {
		new LeftRightBullet(xjl, lm, path).initBulet();
	}
	
	public void newDiffusionBullet(XJLabel xjl, LevelMap lm, String path)
	{
		new DiffusionBullet(xjl, lm, path).initBulet();
	}
	public void newSpiralBullet(XJLabel xjl, LevelMap lm, String path)
	{
		new SpiralBullet(xjl, lm, path).initBulet();
	}
	public void newScatteringBullet(XJLabel xjl, LevelMap lm, String path)
	{
		new ScatteringBullet(xjl, lm, path).initBulet();
	}

}
