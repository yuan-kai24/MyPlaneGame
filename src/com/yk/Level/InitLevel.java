package com.yk.Level;

import java.util.Random;

import javax.swing.SwingUtilities;

import com.yk.map.LevelMap;
import com.yk.tool.CreateIcon;
import com.yk.tool.PlayStop;
import com.yk.tool.StringOperation;
import com.yk.trajectory.BulletAdd;
import com.yk.trajectory.LeftRightBullet;
import com.yk.trajectory.LevelBullet;
import com.yk.user.User;

//序章关卡
public class InitLevel extends Thread {

	private LevelMap lm;

	private XJLabel[] boos = new XJLabel[31];
	private Random ran = new Random();
	private int boosX;
	private LevelInfo li = new LevelInfo("01level");// 关卡信息

	public InitLevel(LevelMap lm) {
		this.lm = lm;
		boosX = lm.getJp().getWidth() - 300;
		setBoosInit();
	}

	public void init() {

		// 添加用户(用戶初始化)
		lm.getJp().add(User.setUser(lm, boos));
		lm.setDisplayJl();
		PlayStop.setStop(lm);//添加暂停按钮
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
		boos[i] = new XJLabel();//boos
		boos[i].setVisible(false);
		CreateIcon.setCharacter(boos[i], "01boos");
		boos[i].setLocation(ran.nextInt(boosX) + 100, 0);
		boos[i].setThread(li.getBoosHp(), li.getBoosAt());
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "01booszd", 500),
				LevelBullet.getClassName());
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "01booszd", 2000),
				LeftRightBullet.getClassName());
		boos[i].setLastboos(true);
	}

	private void createSam(int i) {//初级小怪
		boos[i] = new XJLabel();
		boos[i].setVisible(false);
		CreateIcon.setCharacter(boos[i], "01xg1");
		boos[i].setLocation(ran.nextInt(boosX) + 100, 0);
		boos[i].setThread(li.getOneHp(), li.getOneAt());
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "01xgzd", 3000),
				LevelBullet.getClassName());
	}

	private void createCen(int i) {//中级小怪
		boos[i] = new XJLabel();
		boos[i].setVisible(false);
		CreateIcon.setCharacter(boos[i], "01xg2");
		boos[i].setThread(li.getTwoHp(), li.getTwoat());
		boos[i].setLocation(ran.nextInt(boosX) + 100, 0);
		
		boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "01xgzd", 2000),
				LevelBullet.getClassName());
	}

	public void run() {
		int i = 0;
		while (i < 31 && StringOperation.strWho(User.hp, "0")) {
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
							i++;
						}
					}
				}

			}
			try {
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
		lm.getJp().add(xjl);
		xjl.startThread();
		new BoosMove(xjl).start();
	}

}
