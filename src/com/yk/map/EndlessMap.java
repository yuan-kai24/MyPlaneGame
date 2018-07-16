package com.yk.map;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.Level.EndlessLevel;
import com.yk.game.GameGui;
import com.yk.load.ChangeGui;
import com.yk.load.EndlessGui;
import com.yk.user.User;

public class EndlessMap extends Thread implements LevelMap {
	JPanel jp = new JPanel();
	JLabel displayjf = new JLabel();
	Thread level;

	public JPanel setInitMap() {
		jp.setSize(GameGui.getCon().getWidth(), GameGui.getCon().getHeight());
		jp.setLayout(null);
		jp.setOpaque(false);
		
		displayjf.setFont(new Font("微软雅黑", 0, 20));
		displayjf.setSize(200, 25);
		displayjf.setLocation(jp.getWidth() - displayjf.getWidth(),
				jp.getHeight() - 30);

		jp.add(displayjf);

		jp.setVisible(true);
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
		EndlessGui.getJp().setVisible(false);
		
		jp.removeAll();
		EndlessGui.getJp().removeAll();
		
		GameGui.getCon().remove(EndlessGui.getJp());
		GameGui.getCon().add(ChangeGui.getJp());
		ChangeGui.getJp().setVisible(true);

		
		SwingUtilities.updateComponentTreeUI(GameGui.getJf());
	}

	public String getBoom() {
		return "colorboom";
	}

}
