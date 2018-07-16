package com.yk.load;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.yk.game.GameGui;
import com.yk.map.EndlessMap;
import com.yk.tool.CreateIcon;

public class EndlessGui {
private static JPanel jp = new JPanel();
	
	public static JPanel setEndless()
	{
		jp.setLayout(null);
		jp.setSize(GameGui.getJf().getWidth(),GameGui.getJf().getHeight());
		JLabel background = new JLabel();
		CreateIcon.setFullScreen(background,GameGui.getJf(), "levelchangebk");
		
		CreateIcon.setFullScreen(background, jp, "ebk");
		JPanel map = new EndlessMap().setInitMap();
		jp.add(map);
	
		jp.add(background);
		
		return jp;
	}
	
	public static JPanel getJp()
	{
		return jp;
	}

}
