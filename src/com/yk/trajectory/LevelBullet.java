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

/*
 * 关卡npc发射子弹
 * 当子弹击中飞机，减少飞机hp
 * 击中飞机子弹消失，当飞机hp小于等于零，飞机摧毁
 * 直线弹道
 */
public class LevelBullet extends Thread {
	private XJLabel jl;
	private JPanel jp;
	private JLabel bbull;
	private String name;
	private LevelMap lm;

	public LevelBullet(XJLabel jl, LevelMap lm, String name) {
		this.jl = jl;
		this.jp = lm.getJp();
		this.name = name;
		this.lm = lm;
	}

	public void initBulet() {
		bbull = new JLabel();
		CreateIcon.setCharacter(bbull, name);
		bbull.setLocation(jl.getX() - bbull.getWidth() / 2 + jl.getWidth() / 2,
				jl.getY() + bbull.getHeight());
		jp.add(bbull);
		SwingUtilities.updateComponentTreeUI(jp);
		this.start();
	}

	public void run() {
		while (bbull.getY() < jp.getHeight() && StringOperation.strWho(User.hp, "0")) {// 修复用户消失还能发射子弹
			if (User.isstop) {
				bbull.setLocation(bbull.getX(), bbull.getY() + 5);
				// 触碰检测
				if (CollisionDetection.setCollInit(bbull, User.getJl())) { 
					RemoveUserCuthp.startCut(jl, lm);
					break;
				}
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bbull.setVisible(false);
		jp.remove(bbull);
		SwingUtilities.updateComponentTreeUI(jp);

	}

	public static String getClassName() {
		return "LevelBullet";
	}
}
