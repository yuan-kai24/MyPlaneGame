package com.yk.Level;

import java.util.Random;

import javax.swing.SwingUtilities;

import com.yk.map.LevelMap;
import com.yk.tool.CreateIcon;
import com.yk.tool.PlayStop;
import com.yk.tool.StringOperation;
import com.yk.trajectory.BulletAdd;
import com.yk.trajectory.LevelBullet;
import com.yk.trajectory.ScatteringBullet;
import com.yk.user.User;

public class TwoLevel extends Thread {

	private LevelMap lm;

	private XJLabel[] boos = new XJLabel[33];
	private Random ran = new Random();
	private int boosX;
	private LevelInfo li = new LevelInfo("03level");// 关卡信息

	public TwoLevel(LevelMap lm) {
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

	public void setBoosInit() {
		int i = 0;

		while (i < 10) {
			createSam(i);
			i++;
		}
		while (i < 30) {
			createCen(i);
			i++;
			createSam(i);
			i++;
		}
		boos[30] = new XJLabel();// boos
		boos[30].setVisible(false);
		CreateIcon.setCharacter(boos[30], "03boos1");
		boos[30].setLocation(ran.nextInt(boosX), 0);
		boos[30].setThread(li.getBoosHp(), li.getBoosAt());
		boos[30].addBulletAdd(new BulletAdd(boos[30], lm, "03booszd", 1000),
				LevelBullet.getClassName());
		BulletAdd spiral = new BulletAdd(boos[30], lm, "03booszdx", 20000);
		spiral.setAddSpeed(10000);
		boos[30].addBulletAdd(spiral, ScatteringBullet.getClassName());

		boos[31] = new XJLabel();// boos
		boos[31].setVisible(false);
		CreateIcon.setCharacter(boos[31], "03boos2");
		boos[31].setLocation(ran.nextInt(boosX), 0);
		boos[31].setThread(li.getBoosHp(), li.getBoosAt());
		boos[31].addBulletAdd(new BulletAdd(boos[31], lm, "03booszd", 1000),
				LevelBullet.getClassName());
		BulletAdd spiral2 = new BulletAdd(boos[31], lm, "03booszdx", 20000);
		spiral.setAddSpeed(10000);
		boos[31].addBulletAdd(spiral2, ScatteringBullet.getClassName());

		boos[32] = new XJLabel();// boos
		boos[32].setVisible(false);
		CreateIcon.setCharacter(boos[32], "03boos3");
		boos[32].setLocation(ran.nextInt(boosX), 0);
		boos[32].setThread(li.getBoosHp(), li.getBoosAt());
		boos[32].addBulletAdd(new BulletAdd(boos[32], lm, "03booszd", 1000),
				LevelBullet.getClassName());
		BulletAdd spiral3 = new BulletAdd(boos[32], lm, "03booszdx", 20000);
		spiral.setAddSpeed(10000);
		boos[32].addBulletAdd(spiral3, ScatteringBullet.getClassName());

	}

	private void createSam(int i) {// 初级小怪
		boos[i] = new XJLabel();
		boos[i].setVisible(false);
		CreateIcon.setCharacter(boos[i], "03xg1");
		boos[i].setLocation(ran.nextInt(boosX), 0);
		boos[i].setThread(li.getOneHp(), li.getOneAt());
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03xgzd", 3000),
				LevelBullet.getClassName());
	}

	private void createCen(int i) {// 中级小怪
		boos[i] = new XJLabel();
		boos[i].setVisible(false);
		CreateIcon.setCharacter(boos[i], "03xg2");
		boos[i].setThread(li.getTwoHp(), li.getTwoat());
		boos[i].setLocation(ran.nextInt(boosX), 0);

		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03xgzd", 2000),
				LevelBullet.getClassName());
	}

	public void run() {
		int i = 0;
		while (i < 31 && StringOperation.strWho(User.hp, "0")) {
			try {
				if (User.isstop) {
					if (i < 10) {
						setDis(boos[i]);
						i++;
					} else {

						if (getBoosVis(boos, 0, 10) && i < 30) {
							setDis(boos[i]);
							i++;
						} else {

							if (getBoosVis(boos, 0, 30)) {
								setDis(boos[i]);
								Thread.sleep(6000);
								setDis(boos[i+1]);
								Thread.sleep(4000);
								setDis(boos[i+2]);
								boos[i].setLastboos(true);
								boos[i+1].setLastboos(true);
								boos[i+2].setLastboos(true);
								i++;
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
