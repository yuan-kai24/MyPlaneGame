package com.yk.load;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.yk.game.GameGui;
import com.yk.tool.CreateIcon;
import com.yk.user.UserInfo;

public class Loading {
	private static JPanel jp = new JPanel();
	private static int jl1icon = 0;

	public static JPanel setLoad() {
		jp.setSize(GameGui.getJf().getWidth(), GameGui.getJf().getHeight());
		jp.setLayout(null);
		jp.setVisible(true);
		return jp;
	}

	public static void setLoadIcon() {
		final JLabel jl1 = new JLabel();
		CreateIcon.setCharacter(jl1, "logo");
		jl1.setLocation(jp.getWidth() / 2 - jl1.getWidth() / 2, 20);

		jp.add(jl1);// logo加载
		jl1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				if (jl1icon % 2 == 0) {
					CreateIcon.setCharacter(jl1, "logo2");
					jl1icon++;
				} else {
					CreateIcon.setCharacter(jl1, "logo");
					jl1icon++;
				}
			}
		});
		/*-----------------------------------------------*/
		JLabel form = new JLabel("↓↓↓↓↓此游戏素材来源与网络和↓↓↓↓↓");
		form.setFont(new Font("微软雅黑", Font.BOLD, 30));
		form.setForeground(Color.orange);
		form.setSize(500, 30);
		form.setLocation(jp.getWidth() / 2 - jl1.getWidth() / 2 + 50,
				jl1.getHeight() + 50);
		jp.add(form);

		/*-----------------------------------------------*/

		JLabel jl2 = new JLabel();
		CreateIcon.setCharacter(jl2, "sucaiform");
		jl2.setLocation(GameGui.getJf().getWidth() / 2 - jl1.getWidth() / 2,
				jl1.getHeight() + 100);
		jp.add(jl2);// 素材来源

		/*-----------------------------------------------*/

		JLabel jl3 = new JLabel();
		CreateIcon.setCharacter(jl3, "sucaiform2");
		jl3.setLocation(GameGui.getJf().getWidth() / 2 - jl1.getWidth() / 2
				+ jl2.getWidth() + 115, jl1.getHeight() + 120);
		jp.add(jl3);// 素材来源2
		SwingUtilities.updateComponentTreeUI(jp);
		try {
			Thread.sleep(3000);
			// 加载完成后代码
			setLoadAfter();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setLoadAfter() {
		jp.setVisible(false);
		GameGui.getCon().remove(jp);
		if(" ".equals(new UserInfo().getUsername()) || " ".equals(new UserInfo().getPassword()))
		{
			GameGui.getCon().add(Register.setRegister());
		}
		else
		{
			GameGui.getCon().add(Login.setLogin());
		}

	}
}
