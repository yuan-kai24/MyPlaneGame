package com.yk.trajectory;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.map.LevelMap;
import com.yk.tool.CollisionDetection;
import com.yk.tool.CreateIcon;
import com.yk.tool.PositionMove;
import com.yk.tool.StringOperation;
import com.yk.user.User;

public class PlaneAdd extends Thread {

	private JPanel jp;
	private JLabel addjl = new JLabel();
	private Random ran = new Random();
	private int movex,movey;

	public PlaneAdd(LevelMap lm) {
		jp = lm.getJp();
		setAddjl();
	}

	private void setAddjl() {
		CreateIcon.setCharacter(addjl, "addap");
		addjl.setLocation(ran.nextInt(jp.getWidth() - addjl.getWidth()), ran.nextInt(jp.getHeight()-addjl.getHeight()));
		jp.add(addjl);
		SwingUtilities.updateComponentTreeUI(jp);
		if(ran.nextInt(10)%2==0)
		{
			movex = 5;
		}
		else
		{
			movex = -5;
		}
		if(ran.nextInt(10)%2==1)
		{
			movey = 5;
		}
		else
		{
			movey = -5;
		}
		this.start();
	}

	public void run() {
		while (addjl.isVisible()) {

			if (User.isstop) {
				addjl.setLocation(addjl.getX()+movex,addjl.getY()+movey);
				try {
					if (CollisionDetection.setCollInit(addjl, User.getJl())) {
						addjl.setVisible(false);
						SwingUtilities.updateComponentTreeUI(jp);
						PositionMove.bulletcount++;
						Thread.sleep(2000);
						if (!StringOperation.strWho(User.hp, "0")) {
							break;
						}
						Thread.sleep(2000);
						if (!StringOperation.strWho(User.hp, "0")) {
							break;
						}
						Thread.sleep(2000);
						if (!StringOperation.strWho(User.hp, "0")) {
							break;
						}
						Thread.sleep(2000);
						if (!StringOperation.strWho(User.hp, "0")) {
							break;
						}
						
						Thread.sleep(2000);
						if (PositionMove.bulletcount != 1
								&& StringOperation.strWho(User.hp, "0")) {
							PositionMove.bulletcount--;
							break;
						} else {
							break;
						}

					}
					if(addjl.getX() < 5 || addjl.getX() > (jp.getWidth()-addjl.getWidth()-5))
					{
						movex = -movex;
					}
					if(addjl.getY() < 5 || addjl.getY() > (jp.getHeight()-addjl.getHeight()-5))
					{
						movey = -movey;
					}
					Thread.sleep(20);
					if (!StringOperation.strWho(User.hp, "0")) {
						break;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		addjl.setVisible(false);
		jp.remove(addjl);

	}
}
