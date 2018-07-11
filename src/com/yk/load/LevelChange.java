package com.yk.load;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.yk.game.GameGui;
import com.yk.map.FourMap;
import com.yk.map.InitMap;
import com.yk.map.OneMap;
import com.yk.map.ThreeMap;
import com.yk.map.TwoMap;
import com.yk.tool.CreateIcon;
import com.yk.tool.StringOperation;
import com.yk.user.UserInfo;

public class LevelChange {
	private static JPanel jp = new JPanel();
	
	public  static JPanel setLevelChange()
	{
		jp.setLayout(null);
		jp.setSize(GameGui.getJf().getWidth(),GameGui.getJf().getHeight());
		JLabel background = new JLabel();
		CreateIcon.setFullScreen(background,GameGui.getJf(), "levelchangebk");
		
		setLeveButton(1);
		jp.add(myerror());
		jp.add(setReturn());
		jp.add(background);
		
		
		
		return jp;
	}
	
	private static JLabel setReturn()
	{
		JLabel jlreturn = new JLabel();
		
		CreateIcon.setCharacter(jlreturn, "return");
		jlreturn.setLocation(15,20);
		jlreturn.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				jp.setVisible(false);
				jp.removeAll();
				GameGui.getCon().add(ChangeGui.getJp());
				ChangeGui.getJp().setVisible(true);
			}
		});
		return jlreturn;
		
	}
	
	public static void setLeveButton(int n)
	{
		JLabel test = new JLabel();
		CreateIcon.setCharacter(test, "levelchange/01");
		int jlx = jp.getWidth()/2-test.getWidth()*2-15;
		int jly = 200;
		
		/*------------------------序章-----------------------------*/
		JButton blackwhiteword = new JButton();
		CreateIcon.setButton(blackwhiteword, "levelchange/01");
		blackwhiteword.setLocation(jlx,jly);
		jp.add(blackwhiteword);
		blackwhiteword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jp.setVisible(false);
				GameGui.getCon().remove(jp);
				JPanel map = new InitMap().setInitMap();
				GameGui.getJf().add(map);
			}
		});
		/*------------------------一-----------------------------*/
		JButton chuangshifengyin = new JButton();
		CreateIcon.setButton(chuangshifengyin, "levelchange/02");
		chuangshifengyin.setLocation(jlx + chuangshifengyin.getWidth()+10,jly);
		jp.add(chuangshifengyin);
		chuangshifengyin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(StringOperation.strWho(new UserInfo().getGrade(), "1"))
				{
					jp.setVisible(false);
				GameGui.getCon().remove(jp);
				JPanel map = new OneMap().setInitMap();
				GameGui.getJf().add(map);
				}
				else
				{
					jpe.setVisible(true);
				}
			}
		});
		/*------------------------二-----------------------------*/
		JButton shengmingjijia = new JButton();
		CreateIcon.setButton(shengmingjijia, "levelchange/03");
		shengmingjijia.setLocation(jlx + (shengmingjijia.getWidth()+10)*2,jly);
		jp.add(shengmingjijia);
		shengmingjijia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(StringOperation.strWho(new UserInfo().getGrade(), "2"))
				{
				jp.setVisible(false);
				GameGui.getCon().remove(jp);
				JPanel map = new TwoMap().setInitMap();
				GameGui.getJf().add(map);
					
				}
				else
				{
					jpe.setVisible(true);
				}
			}
		});
		/*------------------------三-----------------------------*/
		JButton xuanhuankeji = new JButton();
		CreateIcon.setButton(xuanhuankeji, "levelchange/04");
		xuanhuankeji.setLocation(jlx + (xuanhuankeji.getWidth()+10)*3,jly);
		jp.add(xuanhuankeji);
		xuanhuankeji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(StringOperation.strWho(new UserInfo().getGrade(), "3"))
				{
				jp.setVisible(false);
				GameGui.getCon().remove(jp);
				JPanel map = new ThreeMap().setInitMap();
				GameGui.getJf().add(map);
					
				}
				else
				{
					jpe.setVisible(true);
				}
			}
		});
		/*------------------------四-----------------------------*/
		JButton shengmingyiyi = new JButton();
		CreateIcon.setButton(shengmingyiyi, "levelchange/05");
		shengmingyiyi.setLocation(jlx,jly+shengmingyiyi.getHeight()+10);
		jp.add(shengmingyiyi);
		shengmingyiyi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(StringOperation.strWho(new UserInfo().getGrade(), "4"))
				{
					jp.setVisible(false);
					GameGui.getCon().remove(jp);
					JPanel map = new FourMap().setInitMap();
					GameGui.getJf().add(map);
					
				}
				else
				{
					jpe.setVisible(true);
				}
			}
		});
		
	}
	
	public static JPanel getJp()
	{
		return jp;
	}
	
	
	public static JPanel jpe = new JPanel();
	public static JPanel myerror()
	{
		
		jpe.setLayout(null);
		jpe.setSize(300, 200);
		
		JLabel jl = new JLabel("请通过前面关卡");
		jl.setFont(new Font("微软雅黑",0,20));
		jl.setSize(140,20);
		jl.setLocation(35,50);
		jpe.add(jl);
		jpe.setVisible(false);
		JLabel jb = new JLabel();
		CreateIcon.setCharacter(jb, "okbutton");
		jb.setLocation(jpe.getWidth()/2-jb.getWidth()/2,jpe.getHeight()-60);
		jpe.add(jb);
		
		jb.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseClicked(MouseEvent arg0) {
				jpe.setVisible(false);
			}
		});
		
		jpe.setLocation(GameGui.getJf().getWidth()/2-jpe.getWidth()/2,GameGui.getJf().getHeight()/2-jpe.getHeight()/2);
		return jpe;
	}

}
