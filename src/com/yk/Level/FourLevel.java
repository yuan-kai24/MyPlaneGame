package com.yk.Level;

import java.util.Random;

import javax.swing.SwingUtilities;

import com.yk.map.LevelMap;
import com.yk.tool.CreateIcon;
import com.yk.tool.PlayStop;
import com.yk.tool.StringOperation;
import com.yk.trajectory.BulletAdd;
import com.yk.trajectory.DiffusionBullet;
import com.yk.trajectory.LeftRightBullet;
import com.yk.trajectory.LevelBullet;
import com.yk.trajectory.ScatteringBullet;
import com.yk.trajectory.SpiralBullet;
import com.yk.user.User;

public class FourLevel extends Thread {

	private LevelMap lm;

	private XJLabel[] boos = new XJLabel[43];
	private Random ran = new Random();
	private int boosX;

	public FourLevel(LevelMap lm) {
		this.lm = lm;
		boosX = lm.getJp().getWidth() - 300;
		setBoosInit();
	}

	public void init() {

		// 添加用户(用戶初始化)
		lm.getJp().add(User.setUser(lm, boos), 1);
		lm.setDisplayJl();
		PlayStop.setStop(lm);// 添加暂停按钮

		this.start();

		SwingUtilities.updateComponentTreeUI(lm.getJp());

	}

	public void setBoosInit() {// 手动关卡初始化
		int i = 0;

		while (i < 5) {
			createSam(i, "01xg", "100", "5");
			i++;
		}
		while (i < 9) {
			createCen(i, "01xg", "150", "8");
			i++;
		}
		createBig(i, "01boos", "300", "10");
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "01booszd", 5000),LeftRightBullet.getClassName());
		i++;

		/*-----------------------------------------------------------------------*/

		while (i < 15) {
			createSam(i, "02xg", "150", "8");
			i++;
		}
		while (i < 19) {
			createCen(i, "02xg", "250", "10");
			i++;
		}
		createBig(i, "02boos", "600", "15");
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "02booszdx", 60000),SpiralBullet.getClassName());
		i++;

		/*-----------------------------------------------------------------------*/

		while (i < 25) {
			createSam(i, "03xg", "300", "10");
			i++;
		}
		while (i < 29) {
			createCen(i, "03xg", "500", "15");
			i++;
		}
		createBig(i, "03boos1", "1000", "20");
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03booszdx", 30000),ScatteringBullet.getClassName());
		i++;
		createBig(i, "03boos2", "1100", "22");
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03booszdx", 30000),ScatteringBullet.getClassName());
		i++;
		createBig(i, "03boos3", "1200", "25");
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03booszdx", 30000),ScatteringBullet.getClassName());
		i++;

		/*-----------------------------------------------------------------------*/

		while (i < 37) {
			createSam(i, "04xg", "800", "20");
			i++;
		}
		while (i < 41) {
			createCen(i, "04xg", "1500", "30");
			i++;
		}
		createBig(i, "04boos", "3000", "50");
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "luoxuanzd", 20000),DiffusionBullet.getClassName());
		i++;
		createBig(i, "05boos", "10000", "100");
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "05xgzd", 3000),LevelBullet.getClassName());
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "05booszd", 60000),SpiralBullet.getClassName());
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03booszdx", 30000),ScatteringBullet.getClassName());
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "luoxuanzd", 20000),DiffusionBullet.getClassName());

	}

	private void createSam(int i, String path, String hp, String ap) {// 初级小怪
		boos[i] = new XJLabel();
		boos[i].setVisible(false);
		CreateIcon.setCharacter(boos[i], path + "1");
		boos[i].setLocation(ran.nextInt(boosX), 0);
		boos[i].setThread(hp, ap);
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, path + "zd", 3000),
				LevelBullet.getClassName());
	}

	private void createCen(int i, String path, String hp, String ap) {// 中级小怪
		boos[i] = new XJLabel();
		boos[i].setVisible(false);
		CreateIcon.setCharacter(boos[i], path + "2");
		boos[i].setThread(hp, ap);
		boos[i].setLocation(ran.nextInt(boosX), 0);

		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, path + "zd", 2000),
				LevelBullet.getClassName());
	}

	private void createBig(int i, String path, String hp, String ap) {
		boos[i] = new XJLabel();// boos
		boos[i].setVisible(false);
		CreateIcon.setCharacter(boos[i], path);
		boos[i].setLocation(ran.nextInt(boosX), 0);
		boos[i].setThread(hp, ap);
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, path + "zd", 1000),
				LevelBullet.getClassName());
	}

	public void run() {
		int i = 0;
		while (i < 43 && StringOperation.strWho(User.hp, "0")) {
			try {
				if (User.isstop) {
					if (i < 10) {
						setDis(boos[i]);
						i++;
					} else {

						if (getBoosVis(boos, 0, 10) && i < 20) {
							setDis(boos[i]);
							i++;
						} else {

							if (getBoosVis(boos, 0, 20) && i < 32) {
								setDis(boos[i]);
								i++;
							}
							else
							{
								if(getBoosVis(boos, 0, 32) && i < 42)
								{
									setDis(boos[i]);
									i++;
								}
								else
								{
									if(getBoosVis(boos, 0, 42))
									{
										setDis(boos[i]);
										i++;
									}
								}
								
								
							}
						}
					}

				}
				
				SwingUtilities.updateComponentTreeUI(lm.getJp());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		boos[42].setLastboos(true);
	}

	public boolean getBoosVis(XJLabel[] xjl, int begin, int end) {
		for (int i = begin; i < end; i++) {
			if (xjl[i].isVisible()) {
				return false;
			}
		}
		return true;
	}

	public void setDis(XJLabel xjl) {
		xjl.setVisible(true);
		lm.getJp().add(xjl, 2);
		xjl.startThread();
		new BoosMove(xjl).start();
	}
}
