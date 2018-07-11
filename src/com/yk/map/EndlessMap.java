package com.yk.map;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.Level.EndlessLevel;
import com.yk.game.GameGui;
import com.yk.load.ChangeGui;
import com.yk.tool.CreateIcon;
import com.yk.user.User;

public class EndlessMap extends Thread implements LevelMap {
	JPanel jp = new JPanel();
	JLabel displayjf = new JLabel();
	Thread level;
	private JLabel mybk = new JLabel();

	public JPanel setInitMap() {
		jp.setSize(GameGui.getCon().getWidth(), GameGui.getCon().getHeight());
		jp.setLayout(null);
		jp.setBackground(Color.black);

		displayjf.setFont(new Font("微软雅黑", 0, 20));
		displayjf.setSize(200, 25);
		displayjf.setLocation(jp.getWidth() - displayjf.getWidth(),
				jp.getHeight() - 30);

		jp.add(displayjf, 0);

		jp.setVisible(true);
		CreateIcon.setFullScreen(mybk, jp, "ebk");
		jp.add(mybk, -1);
		/*--------------------begin------------------------*/
		level = new EndlessLevel(this);
		((EndlessLevel) level).init();
		SwingUtilities.updateComponentTreeUI(jp);
		/*------------------------------------------------*/

		return jp;
	}

	public JPanel getJp() {
		return jp;
	}

	public void setDisplayJl() {
		displayjf.setText("血量:" + User.hp);
	}

	public void clearThis() {// 闯关结束
		jp.setVisible(false);
		jp.removeAll();
		GameGui.getCon().remove(jp);
		GameGui.getCon().add(ChangeGui.getJp());
		ChangeGui.getJp().setVisible(true);
		SwingUtilities.updateComponentTreeUI(GameGui.getJf());
	}

	public String getBoom() {
		return "colorboom";
	}

}
