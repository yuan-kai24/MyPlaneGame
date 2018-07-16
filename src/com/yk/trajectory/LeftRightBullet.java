package com.yk.trajectory;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.Level.XJLabel;
import com.yk.map.LevelMap;
import com.yk.tool.CollisionDetection;
import com.yk.tool.CreateIcon;
import com.yk.tool.RemoveUserCuthp;
import com.yk.tool.StringOperation;
import com.yk.user.User;

public class LeftRightBullet extends Thread {
	private XJLabel xjl;
	private JPanel jp;
	private LevelMap lm;
	private JLabel bbulll, bbullr;
	private String namel, namer;

	public LeftRightBullet(XJLabel xjl, LevelMap lm, String name) {
		this.xjl = xjl;
		this.jp = lm.getJp();// 存入面板
		this.lm = lm;
		namel = name + "l";
		namer = name + "r";
	}

	public void initBulet() {
		bbulll = new JLabel();
		bbullr = new JLabel();
		CreateIcon.setCharacter(bbulll, namel);
		CreateIcon.setCharacter(bbullr, namer);
		/*--------------------------位置设置--------------------------------*/
		bbulll.setLocation(xjl.getX() + 15, xjl.getY() + xjl.getHeight()
				- bbulll.getHeight());
		jp.add(bbulll);
		bbullr.setLocation(xjl.getX() + xjl.getWidth() - 45,
				xjl.getY() + xjl.getHeight() - bbullr.getHeight());
		jp.add(bbullr);
		/*-----------------------------------------------------------------*/
		SwingUtilities.updateComponentTreeUI(jp);
		this.start();
	}

	public void run() {
		while (true  && StringOperation.strWho(User.hp, "0")) {
			if (User.isstop) {
				setActionRL();
				if (CollisionDetection.setCollInit(bbulll, User.getJl())
						&& StringOperation.strWho(User.hp, "0")) {
					RemoveUserCuthp.startCut(xjl, lm);
					bbulll.setVisible(false);
				}// 左飞
				if (CollisionDetection.setCollInit(bbullr, User.getJl())) {
					RemoveUserCuthp.startCut(xjl, lm);
					bbullr.setVisible(false);
				}// 右飞

				if (!bbullr.isVisible()) {
					jp.remove(bbullr);
				}
				/* 消失条件 */
				if (!bbulll.isVisible()) {
					jp.remove(bbulll);
					if (!bbullr.isVisible()) {// 退出条件
						break;
					}
				}

				if (bbullr.getY() > jp.getHeight() - 100) {
					if (bbullr.getY() > jp.getHeight() - 100) {
						break;
					}

				}
			}

			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bbullr.setVisible(false);
		bbulll.setVisible(false);
		jp.remove(bbullr);
		jp.remove(bbulll);
		SwingUtilities.updateComponentTreeUI(jp);

	}

	private void setActionRL() {

		bbulll.setLocation(bbulll.getX() - 2, bbulll.getY() + 5);
		bbullr.setLocation(bbullr.getX() + 2, bbullr.getY() + 5);

	}

	public static String getClassName() {
		return "LeftRightBullet";
	}
}
