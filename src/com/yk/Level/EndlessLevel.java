package com.yk.Level;

import java.util.Random;

import javax.swing.SwingUtilities;

import com.yk.map.LevelMap;
import com.yk.tool.CreateIcon;
import com.yk.tool.PlayStop;
import com.yk.tool.StringOperation;
import com.yk.trajectory.BulletAdd;
import com.yk.trajectory.DiffusionBullet;
import com.yk.trajectory.LevelBullet;
import com.yk.trajectory.ScatteringBullet;
import com.yk.trajectory.SpiralBullet;
import com.yk.user.User;

public class EndlessLevel extends Thread {

	private LevelMap lm;

	private XJLabel[] boos = new XJLabel[50];
	private Random ran = new Random();
	private int boosX;
	private String hp = "5";
	private String ap = "1";

	public EndlessLevel(LevelMap lm) {
		this.lm = lm;
		boosX = lm.getJp().getWidth() - 400;
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
		for (int i = 0; i < boos.length; i++) {
			boos[i] = new XJLabel();
			boos[i].setVisible(false);
		}

	}

	private void createSam(int i) {
		boos[i].setLocation(ran.nextInt(boosX), 0);
		boos[i].setThread(hp, ap);
	}

	private void createBoos() {
		for (int i = 0; i < 50; i++) {
			if (!boos[i].isVisible()) {
				setDisboos(i);
				createSam(i);
				setZdStylr(i);
				setDis(boos[i]);
				hp = StringOperation.strAdd(hp, "5");
				ap = StringOperation.strAdd(ap, "1");

				return;
			}
		}
	}

	private void setDisboos(int i) {
		Random ran = new Random();
		boos[i] = new XJLabel();
		boos[i].setVisible(false);
		boos[i].setThread(hp, ap);
		int rannum = ran.nextInt(10) % 10;
		switch (rannum) {
		case 0:
			CreateIcon.setCharacter(boos[i], "01boos");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "01booszd", 3000),
					LevelBullet.getClassName());
			break;
		case 1:
			CreateIcon.setCharacter(boos[i], "02boos");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "02booszd", 3000),
					LevelBullet.getClassName());
			break;
		case 2:
			CreateIcon.setCharacter(boos[i], "03boos1");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03booszd", 3000),
					LevelBullet.getClassName());
			break;
		case 3:
			CreateIcon.setCharacter(boos[i], "03boos2");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03booszd", 3000),
					LevelBullet.getClassName());
			break;
		case 4:
			CreateIcon.setCharacter(boos[i], "03boos3");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "03booszd", 3000),
					LevelBullet.getClassName());
			break;
		case 5:
			CreateIcon.setCharacter(boos[i], "04boos");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "04booszd", 3000),
					LevelBullet.getClassName());
			break;
		case 6:
			CreateIcon.setCharacter(boos[i], "04xg1");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "04xgzd", 3000),
					LevelBullet.getClassName());
			break;
		case 7:
			CreateIcon.setCharacter(boos[i], "05xg2");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "05xgzd", 3000),
					LevelBullet.getClassName());
			break;
		case 8:
			CreateIcon.setCharacter(boos[i], "02xg1");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "02xgzd", 3000),
					LevelBullet.getClassName());
			break;
		case 9:
			CreateIcon.setCharacter(boos[i], "01xg2");
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, "01xgzd", 3000),
					LevelBullet.getClassName());
			break;

		}

	}

	private void setZdStylr(int i) {
		int rannum = ran.nextInt(10) % 10;
		switch (rannum) {
		case 0:
			boos[i].addBulletAdd(
					new BulletAdd(boos[i], lm, getzdS(), 30000),
					DiffusionBullet.getClassName());
			break;
		case 1:
			boos[i].addBulletAdd(new BulletAdd(boos[i], lm, getzdS(), 30000),
					ScatteringBullet.getClassName());
			break;
		case 2:
			boos[i].addBulletAdd(
					new BulletAdd(boos[i], lm, getzdS(), 30000),
					SpiralBullet.getClassName());
			break;
		default:
			break;

		}

	}

	private String getzdS() {
		int rannum = ran.nextInt(100) % 6;
		String str = null;

		switch (rannum) {
		case 0:
			str = "02xgzd";
			break;
		case 1:
			str = "03booszdx";
			break;
		case 2:
			str = "02booszdx";
			break;
		case 3:
			str = "05booszd";
			break;
		case 4:
			str = "luoxuanzd";
			break;
		case 5:
			str = "05xgzd";
			break;
		}

		return str;

	}

	public void run() {
		while (StringOperation.strWho(User.hp, "0")) {
			try {
				if (User.isstop) {
					createBoos();
					SwingUtilities.updateComponentTreeUI(lm.getJp());
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setDis(XJLabel xjl) {
		xjl.setVisible(true);
		lm.getJp().add(xjl, 1);
		xjl.startThread();
		new BoosMove(xjl).start();
	}
}
