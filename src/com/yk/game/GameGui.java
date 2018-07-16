package com.yk.game;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.yk.load.Loading;
import com.yk.tool.CreateIcon;


public class GameGui {
	private static JFrame jf = new JFrame();
	private static Container con = jf.getContentPane();
	
	public static JFrame setInitGui(){
		
		jf.setUndecorated(true);
		jf.setSize(500,500);
		
		jf.getGraphicsConfiguration().getDevice().setFullScreenWindow(jf);
		con.setLayout(null);
		jf.setLayout(null);
		
		CreateIcon.setGuiIcon(jf, "logo2");
		
		con.add(Loading.setLoad());
		Loading.setLoadIcon();//加载程序
		
		SwingUtilities.updateComponentTreeUI(jf);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		return jf;
	}
	
	
	
	public static JFrame getJf()
	{
		return jf;
	}
	public static Container getCon()
	{
		return con;
	}

}
