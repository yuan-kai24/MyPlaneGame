package com.yk.load;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.yk.game.GameGui;
import com.yk.tool.CreateIcon;

public class ChangeGui {
	private static JPanel jp = new JPanel();
	public static JPanel setChangeGui()
	{
		JLabel background = new JLabel();
		CreateIcon.setFullScreen(background,GameGui.getJf(), "changebk");
		jp.setSize(GameGui.getJf().getWidth(),GameGui.getJf().getHeight());
		jp.setLayout(null);
		jp.setBackground(Color.black);
		setChange();
		jp.add(background);
		
		return jp;
	}
	private static void setChange()
	{
		JButton level = new JButton();
		CreateIcon.setButton(level, "levelchange");
		level.setLocation(jp.getWidth()/2-level.getWidth()/2,level.getHeight());
		level.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				jp.setVisible(false);
				GameGui.getCon().remove(jp);
				JPanel level = LevelChange.setLevelChange();
				LevelChange.getJp().setVisible(true);
				GameGui.getCon().add(level);
			}
		});
		jp.add(level);//关卡选择
		
		/*---------------------------------------------------------------------*/
		
		JButton Endless = new JButton();
		CreateIcon.setButton(Endless, "Endless");
		Endless.setLocation(jp.getWidth()/2-Endless.getWidth()/2,Endless.getHeight()*2+10);
		jp.add(Endless);//无尽模式
		Endless.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jp.setVisible(false);
				GameGui.getCon().remove(jp);
				EndlessGui.getJp().setVisible(true);
				GameGui.getJf().add(EndlessGui.setEndless());
			}
		});
		
		/*---------------------------------------------------------------------*/
		
		JButton Setting = new JButton();
		CreateIcon.setButton(Setting, "Setting");
		Setting.setLocation(jp.getWidth()/2-Setting.getWidth()/2,Setting.getHeight()*3+20);
		Setting.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				jp.setVisible(false);
				GameGui.getCon().remove(jp);
				JPanel sett = SettingGui.setSetting();
				SettingGui.getJp().setVisible(true);
				GameGui.getCon().add(sett);				
			}
		});
		jp.add(Setting);//设置
		
		/*---------------------------------------------------------------------*/
		
		JButton exitgame = new JButton();
		CreateIcon.setButton(exitgame, "exitgame");
		exitgame.setLocation(jp.getWidth()/2-exitgame.getWidth()/2,exitgame.getHeight()*4+30);
		exitgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		jp.add(exitgame);//退出游戏
	}
	
	public static JPanel getJp()
	{
		return jp;
	}


}
