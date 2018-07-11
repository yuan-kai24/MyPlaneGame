package com.yk.tool;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.map.LevelMap;

public class OkButton {
	
	public static void setOkButton(final LevelMap lm,String info)
	{
		final JPanel jp = new JPanel();
		jp.setSize(200,200);
		jp.setLocation(lm.getJp().getWidth()/2-jp.getWidth()/2,lm.getJp().getHeight()/2-jp.getHeight()/2);
		jp.setLayout(null);
		
		final JLabel jb = new JLabel("确定");
		CreateIcon.setCharacter(jb, "okbutton");
		jb.setLocation(jp.getWidth()/2-jb.getWidth()/2,jp.getHeight()-80);
		
		JLabel jl = new JLabel(info);
		jl.setFont(new Font("微软雅黑",0,18));
		jl.setSize(18*info.length(),30);
		jl.setLocation(jp.getWidth()/2-jl.getWidth()/2,jb.getY()-60);
		
		jp.add(jl);
		jp.add(jb);
		jb.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				
				lm.clearThis();
				jp.removeAll();
				lm.getJp().remove(jp);
				SwingUtilities.updateComponentTreeUI(lm.getJp());
			}
		});
		
		new FormMove().setMove(jp);
		lm.getJp().add(jp,2);
	}

}
