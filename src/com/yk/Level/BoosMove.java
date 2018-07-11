package com.yk.Level;

import java.util.Random;

import com.yk.game.GameGui;
import com.yk.tool.StringOperation;
import com.yk.user.User;

public class BoosMove extends Thread {

	private XJLabel xjl;
	private Random ran = new Random();
	private int speed = 20;

	public BoosMove(XJLabel xjl) {
		this.xjl = xjl;

	}

	public void run() {
		while (xjl.isVisible() && StringOperation.strWho(xjl.getHp(), "0") && StringOperation.strWho(User.hp, "0")) {

			if(User.isstop)
			{
				setMoveIf();
			}
			

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private void setMoveIf() {

		// 左右
		int rans = ran.nextInt(20) % 10;
		switch (rans) {  
		case 0:
		case 4:
			//追逐用户
			if(User.getJl().getX() > xjl.getX())
			{
				setActionMove(5);
			}
			else
			{
				setActionMove(-5);
			}

			break;
		case 1:
		case 2:
		case 3://左
			setActionMove(-5);
			break;
		case 5:
		case 6:
		case 7://右
			setActionMove(5);
		default://4,8,9
			setActionMove(0);
			break;
		}

		// 上下
		switch (ran.nextInt(10) % 3) {
		case 0:
			break;
		case 1:
			setTopBom(1);
			break;
		case 2:
			setTopBom(2);
			break;

		}
	}

	private void setActionMove(int n) {
		int rannew = ran.nextInt(25) + 5;
		for (int i = 0; i < rannew; i++) {
			// 两种情况《---待优化（感觉可以优化）
			if (StringOperation.strWho(xjl.getHp(), "0") && User.isstop) {//优化爆炸后移动
				if (xjl.getX() < (GameGui.getJf().getWidth() - xjl
						.getWidth()) && n > 0) {//移动
					xjl.setLocation(xjl.getX() + n, xjl.getY());
				}
				if(xjl.getX() > 0 && n < 0)
				{
					xjl.setLocation(xjl.getX() + n, xjl.getY());
				}
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public void setTopBom(int n) {
		int rannew = ran.nextInt(35) + 5;
		for (int i = 0; i < rannew; i++) {

			if (StringOperation.strWho(xjl.getHp(), "0")  && User.isstop) {
				if (xjl.getY() > 10 && n == 1) {//上
					xjl.setLocation(xjl.getX(), xjl.getY() - 5);

				}
				if (xjl.getY() < (GameGui.getJf().getHeight() / 2 - xjl
						.getHeight()) && n == 2) {//下
					xjl.setLocation(xjl.getX(), xjl.getY() + 5);
				}
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

}
