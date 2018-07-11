package com.yk.tool;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.yk.Level.XJLabel;
import com.yk.game.GameGui;
import com.yk.map.LevelMap;
import com.yk.trajectory.PlaneBullet;
import com.yk.trajectory.PlaneTwoBullet;
import com.yk.user.User;

public class PositionMove extends Thread {
	private JLabel jl;
	private int speed = 10;
	
	private XJLabel [] xjl;
	private boolean top = false, right = false, bottom = false, left = false;
	//增加此变量，爆炸后不能移动（包括子弹发射）
	public static boolean strup;
	public static int bulletcount = 1;
	private static boolean bullet = true;//子弹限制
	private static KeyActionMy ka;//事件
	private JPanel jp;
	private LevelMap lm;

	public PositionMove(JLabel jl,LevelMap lm,XJLabel [] xjl) {
		this.jl = jl;
		this.jp = lm.getJp();
		this.lm = lm;
		this.xjl = xjl;
		bulletcount = 1;
		strup = true;
		GameGui.getJf().removeKeyListener(ka);//避免重复监听器
		GameGui.getJf().addKeyListener((ka = new KeyActionMy()));
		GameGui.getJf().requestFocus();
	}

	public void run() {

		while (strup) {
			if(User.isstop)
			{
				if (left && (jl.getX() - 5) > 0) {
					jl.setLocation(jl.getX() - 5, jl.getY());
				}

				if (top && (jl.getY() - 5) > 150) {
					jl.setLocation(jl.getX(), jl.getY() - 5);
				}

				if (right
						&& (jl.getX() + 5) < (GameGui.getJf().getWidth() - jl
								.getWidth())) {
					jl.setLocation(jl.getX() + 5, jl.getY());
				}

				if (bottom
						&& (jl.getY() + 5) < (GameGui.getJf().getHeight() - jl
								.getHeight())) {
					jl.setLocation(jl.getX(), jl.getY() + 5);
				}
			}
				
			

			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class KeyActionMy implements KeyListener {
		public void keyTyped(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case 65:
			case 37:

				left = false;
				break;
			case 87:
			case 38:
				top = false;
				break;
			case 68:
			case 39:
				right = false;
				break;
			case 83:
			case 40:
				bottom = false;
				break;
			default:
				break;
			}
			if(e.getKeyCode() == 32){
				bullet = true;
			}
		}

		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case 65:
			case 37:
				left = true;
				break;
			case 87:
			case 38:
				top = true;
				break;
			case 68:
			case 39:
				right = true;
				break;
			case 83:
			case 40:
				bottom = true;
				break;
			default:
				break;
			}
			if(e.getKeyCode() == 32  && bullet && strup)
			{
				//逻辑:接收关卡设置传入的子弹，再传入子弹 移动，写入触碰事件
				if(StringOperation.strWho(User.hp,"0") && User.isstop)
				{//修复爆炸后发射子弹问题
					if(bulletcount == 1)
					{
						new PlaneBullet(User.getJl(),jp,xjl).initBulet(lm);
					}
					else if(bulletcount == 2)
					{
						new PlaneTwoBullet(User.getJl(), jp, xjl).initBulet(lm);
					}
					else
					{
						new PlaneBullet(User.getJl(),jp,xjl).initBulet(lm);
						new PlaneTwoBullet(User.getJl(), jp, xjl).initBulet(lm);
					}
					
					
					bullet = false;
				}
				
			}
		}

	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public static void setStrup(boolean strup) {
		PositionMove.strup = strup;
	}

}
