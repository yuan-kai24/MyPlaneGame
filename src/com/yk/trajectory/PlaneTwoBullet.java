package com.yk.trajectory;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.Level.XJLabel;
import com.yk.map.LevelMap;
import com.yk.plane.PlaneInfo;
import com.yk.tool.CollisionDetection;
import com.yk.tool.CreateIcon;
import com.yk.tool.RemoveNpcCuthp;
import com.yk.tool.StringOperation;
import com.yk.user.User;

public class PlaneTwoBullet {
	private JLabel jl;
	private JPanel jp;
	private JLabel jbullo;
	private JLabel jbullt;
	private XJLabel[] xjl;
	private XJLabel nowxjl = null;
	private LevelMap lm;

	public PlaneTwoBullet(JLabel jl, JPanel jp, XJLabel[] xjl) {
		this.jl = jl;
		this.jp = jp;
		this.xjl = xjl;
	}

	public void initBulet(LevelMap lm) {
		this.lm = lm;
		jbullo = new JLabel();
		CreateIcon.setCharacter(jbullo,
				new PlaneInfo(User.getPath()).getBullet());
		jbullo.setLocation(jl.getX() - jbullo.getWidth() / 2 + jl.getWidth() / 2 - jbullo.getWidth()-5,
				jl.getY() - jbullo.getHeight()/2);

		jbullt = new JLabel();
		CreateIcon.setCharacter(jbullt,
				new PlaneInfo(User.getPath()).getBullet());
		jbullt.setLocation(jl.getX() - jbullo.getWidth() / 2 + jl.getWidth() / 2 + jbullo.getWidth()+5,
				jl.getY() - jbullo.getHeight() / 2);

		jp.add(jbullo,1);
		jp.add(jbullt,1);  
		new BulletFly(jbullo).start();
		new BulletFly(jbullt).start();
		SwingUtilities.updateComponentTreeUI(jp);
	}

	class BulletFly extends Thread {
		
		private JLabel myjl;
		BulletFly(JLabel myjl)
		{
			this.myjl = myjl;
		}
		
		public void run() {
			while (myjl.getY() > -10) {
				if (User.isstop) {
					myjl.setLocation(myjl.getX(), myjl.getY() - 5);
					nowxjl = CollisionDetection.setCollInit(myjl, xjl);
					if (nowxjl != null
 							&& StringOperation.strWho(nowxjl.getHp(), "0")) {
						RemoveNpcCuthp.starCut(myjl, nowxjl,xjl, lm);
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
			jp.remove(myjl);
			SwingUtilities.updateComponentTreeUI(jp);
		}
	}

}
