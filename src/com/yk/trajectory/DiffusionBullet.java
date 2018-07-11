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

public class DiffusionBullet extends Thread {
	private XJLabel xjl;
	private JPanel jp;
	private JLabel bbull;
	private String name;
	private LevelMap lm;
	
	

	public DiffusionBullet(XJLabel xjl, LevelMap lm, String name) {
		this.xjl = xjl;
		this.jp = lm.getJp();
		this.name = name;
		this.lm = lm;
	}

	public void initBulet() {
		
		this.start();
	}

	public void run() {
		for(int i = 0;i < 40;i++)
		{
			bbull = new JLabel();
			CreateIcon.setCharacter(bbull, name);
			bbull.setLocation(xjl.getX()+xjl.getWidth()/2 - bbull.getWidth() / 2,
					xjl.getY()+xjl.getHeight()/2 - bbull.getHeight() / 2);
			jp.add(bbull,1);
			new BulletMove(bbull, Math.PI * (0.1*i)).start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	class BulletMove extends Thread {
		private double degree;
		private JLabel bbull;

		public BulletMove(JLabel bbull,double degree) {
			this.degree = degree;
			this.bbull = bbull;
		}

		public void run() {
			int x = bbull.getX(),y = bbull.getY();
			while(x > 0 && x < jp.getWidth() && y > 0 && y <jp.getHeight() && StringOperation.strWho(User.hp, "0"))
			{
				if (User.isstop) {
					x += (int)(10*Math.cos(degree));
					y += -(int)(10*Math.sin(degree));
					bbull.setLocation(x,y);
					
					if (CollisionDetection.setCollInit(bbull, User.getJl())) { 
						RemoveUserCuthp.startCut(xjl, lm);
						break;
					}
					if(!StringOperation.strWho(xjl.getHp(), "0"))
					{
						break;
					}
					
				}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bbull.setVisible(false);
			jp.remove(bbull);
			SwingUtilities.updateComponentTreeUI(jp);
		}
	}

	public static String getClassName() {
		return "DiffusionBullet";
	}
}
