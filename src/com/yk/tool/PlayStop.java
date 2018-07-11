package com.yk.tool;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.map.LevelMap;
import com.yk.user.User;

public class PlayStop {

	public static void setStop(final LevelMap lm) {

		final JLabel des = new JLabel("暂 停");
		des.setFont(new Font("微软雅黑", Font.BOLD, 30));
		des.setSize(90, 30);
		des.setLocation(lm.getJp().getWidth() - des.getWidth() - 20, 20);

		lm.getJp().add(des,1);

		final JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setSize(300, 200);
		jp.setBackground(Color.cyan);
		jp.setLocation(lm.getJp().getWidth()/2-jp.getWidth()/2,lm.getJp().getHeight()/2-jp.getHeight()/2);
		new FormMove().setMove(jp);
		/*----------------------------------------------------------------------------*/
		JLabel carry = new JLabel("继 续");
		carry.setFont(new Font("微软雅黑", Font.BOLD, 30));
		carry.setSize(90, 30);
		carry.setLocation(50, jp.getHeight() - carry.getHeight() - 30);
		/*----------------------------------------------------------------------------*/
		JLabel exit = new JLabel("退出");
		exit.setFont(new Font("微软雅黑", Font.BOLD, 30));
		exit.setSize(90, 30);
		exit.setLocation(jp.getWidth() - exit.getWidth(), jp.getHeight()
				- exit.getHeight() - 30);
		/*----------------------------------------------------------------------------*/
		JLabel info = new JLabel("暂停成功");
		info.setFont(new Font("微软雅黑", 0, 40));
		info.setSize(160,40);
		info.setLocation(jp.getWidth()/2-info.getWidth()/2,jp.getHeight()/2-info.getHeight()/2-30);
		
		
		
		jp.add(carry);
		jp.add(exit);
		jp.add(info);
		jp.setVisible(false);

		lm.getJp().add(jp,2);

		/*-------------------------事件区-------------------------------*/
		des.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				User.isstop = false;
				jp.setVisible(true);
				SwingUtilities.updateComponentTreeUI(lm.getJp());
			}
		});
		carry.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				User.isstop = true;
				jp.setVisible(false);
				SwingUtilities.updateComponentTreeUI(lm.getJp());
			}

		});
		exit.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				User.hp = "0";
				User.isstop = true;
				PositionMove.strup = false;
				jp.setVisible(false);
				OkButton.setOkButton(lm, "退出成功");
				
			}
		});

	}

}
