package com.yk.load;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.yk.game.GameGui;
import com.yk.user.UserInfo;

public class Login {
	private static JPanel jp = new JPanel();
	
	public static JPanel setLogin()
	{
		jp.setLayout(null);
		jp.setSize(400,300);
		jp.setBackground(Color.blue);
		jp.setLocation(GameGui.getJf().getWidth()/2-jp.getWidth()/2,GameGui.getJf().getHeight()/2-jp.getHeight()/2);
		
		/*-------------------------------------------------------------*/
		String info = "登录";
		JLabel jinfo = new JLabel(info);
		jinfo.setFont(new Font("微软雅黑",1,25));
		jinfo.setForeground(Color.white);
		jinfo.setSize(info.length()*25,25);
		jinfo.setLocation(10,20);
		
		jp.add(jinfo);
		/*-------------------------------------------------------------*/
		
		
		/*-------------------------------------------------------------*/
		JLabel ucode = new JLabel("账   号:");
		ucode.setForeground(Color.orange);
		ucode.setFont(new Font("微软雅黑",0,20));
		ucode.setSize(100,20);
		ucode.setLocation(30,100);
		final JTextField usercode = new JTextField();
		usercode.setSize(200, 25);
		usercode.setFont(new Font("微软雅黑",0,15));
		usercode.setLocation(ucode.getX()+ucode.getWidth(),ucode.getY());
		
		jp.add(ucode);
		jp.add(usercode);
		/*-------------------------------------------------------------*/
		
		/*-------------------------------------------------------------*/
		JLabel pass = new JLabel("密   码:");
		pass.setForeground(Color.orange);
		pass.setFont(new Font("微软雅黑",0,20));
		pass.setSize(100,20);
		pass.setLocation(30,150);
		final JPasswordField password = new JPasswordField();
		password.setSize(200, 25);
		password.setFont(new Font("微软雅黑",0,15));
		password.setLocation(pass.getX()+pass.getWidth(),pass.getY());
		
		jp.add(pass);
		jp.add(password);
		/*-------------------------------------------------------------*/
		
		
		
		/*-------------------------------------------------------------*/
		JButton exits = new JButton("退出");
		exits.setFont(new Font("微软雅黑",0,16));
		exits.setSize(80,40);
		exits.setLocation(jp.getWidth()-exits.getWidth()-20,jp.getHeight()-exits.getHeight()-30);
		exits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		jp.add(exits);
		/*-------------------------------------------------------------*/
		
		/*-------------------------------------------------------------*/
		JButton reg = new JButton("登录");
		reg.setFont(new Font("微软雅黑",0,16));
		reg.setSize(80,40);
		reg.setLocation(exits.getX()-reg.getWidth()-20,exits.getY());
		reg.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(new UserInfo().getUsername().equals(usercode.getText()) && new UserInfo().getPassword().equals(password.getText()))
				{
					
					jp.setVisible(false);
					GameGui.getCon().remove(jp);
					GameGui.getCon().add(ChangeGui.setChangeGui());
					SwingUtilities.updateComponentTreeUI(GameGui.getJf());
				}
				else
				{
					usercode.setText("登录失败");
					password.setText("");
					
				}
			}
		});
		jp.add(reg);
		/*-------------------------------------------------------------*/
		
		return jp;
	}

}
