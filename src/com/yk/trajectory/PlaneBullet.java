package com.yk.trajectory;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.map.LevelMap;
import com.yk.plane.PlaneInfo;
import com.yk.tool.CollisionDetection;
import com.yk.tool.CreateIcon;
import com.yk.tool.RemoveNpcCuthp;
import com.yk.tool.StringOperation;
import com.yk.user.User;

import com.yk.Level.XJLabel;

public class PlaneBullet extends Thread {
	private JLabel jl;
	private JPanel jp;
	private JLabel jbull;
	private XJLabel[] xjl;
	private XJLabel nowxjl = null;
	private LevelMap lm;

	public PlaneBullet(JLabel jl, JPanel jp, XJLabel[] xjl) {
		this.jl = jl;
		this.jp = jp;
		this.xjl = xjl;
	}

	public void initBulet(LevelMap lm) {
		this.lm = lm;
		jbull = new JLabel();
		CreateIcon.setCharacter(jbull,
				new PlaneInfo(User.getPath()).getBullet());
		jbull.setLocation(jl.getX() - jbull.getWidth() / 2 + jl.getWidth() / 2,
				jl.getY() - jbull.getHeight());
		jp.add(jbull,1);
		SwingUtilities.updateComponentTreeUI(jp);
		super.start();
	}

	public void run() {
		while (jbull.getY() > -10) {
			if (User.isstop) {
				jbull.setLocation(jbull.getX(), jbull.getY() - 5);
					nowxjl = CollisionDetection.setCollInit(jbull, xjl);
					if (nowxjl != null
							&& StringOperation.strWho(nowxjl.getHp(), "0")) {
						RemoveNpcCuthp.starCut(jbull, nowxjl,xjl, lm);
						break;
					}
			}

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		jp.remove(jbull);
		SwingUtilities.updateComponentTreeUI(jp);

	}
}
