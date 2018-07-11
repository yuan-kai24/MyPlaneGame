package com.yk.trajectory;

import java.util.Random;


import com.yk.Level.XJLabel;
import com.yk.map.LevelMap;
import com.yk.tool.StringOperation;
import com.yk.user.User;

public class BulletAdd extends Thread{
	private XJLabel xjl;
	private LevelMap im;
	private String path;
	private Random ran = new Random();//随机子弹发射时间
	private int speed;//子弹发射时间
	private int addspeed = 100;//增加的子弹时间
	private String index = "LevelBullet";
	public BulletAdd(XJLabel xjl,LevelMap im,String path,int speed)
	{
		this.im = im;
		this.xjl = xjl;
		this.path = path;
		this.speed = speed;
	}
	
	public void run() {
		while(xjl.isVisible() && StringOperation.strWho(xjl.getHp(), "0") && StringOperation.strWho(User.hp, "0"))
		{//修复爆炸时子弹发射
			if(User.isstop)
			{
				new BoosTraIndex(index, xjl, im, path);
			}
			try {
				Thread.sleep(ran.nextInt(speed)+addspeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void setAddBullet(String index)
	{
		this.index = index;
	}
	
	public void setAddSpeed(int addspeed)
	{
		this.addspeed = addspeed;
	}
	
	
	
}
