package com.yk.map;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.yk.Level.TwoLevel;
import com.yk.game.GameGui;
import com.yk.load.LevelChange;
import com.yk.tool.CreateIcon;
import com.yk.tool.PositionMove;
import com.yk.tool.StringOperation;
import com.yk.user.User;
import com.yk.user.UserInfo;
import com.yk.user.UserSetInfo;

public class TwoMap extends Thread implements LevelMap {
	JPanel jp = new JPanel();
	JLabel displayjf = new JLabel();
	Thread level;
	private UserInfo usi = new UserInfo();
	private JLabel mybk = new JLabel();
	private JPanel jpb = new JPanel();

	public JPanel setInitMap() {
		
		jpb.setSize(GameGui.getCon().getWidth(), GameGui.getCon().getHeight());
		jpb.setLayout(null);
		
		jp.setSize(GameGui.getCon().getWidth(), GameGui.getCon().getHeight());
		jp.setLayout(null);
		jp.setOpaque(false);

		displayjf.setFont(new Font("微软雅黑", 0, 20));
		displayjf.setSize(200, 25);
		displayjf.setLocation(jp.getWidth() - displayjf.getWidth(),
				jp.getHeight() - 30);
		
		jp.add(displayjf,0);
		
		jp.setVisible(true);
		jpb.add(jp);
		this.start();
		return jpb;
	}


	public JPanel getJp() {
		return jp;
	}

	public void setDisplayJl() {//此方法应该写在user里，标记，后期改
		displayjf.setText("血量:" + User.hp);
	}

	public void clearThis() {//闯关结束
		new endploat().start();
	}

	public void run() {

		JTextArea ploat = new JTextArea();
		ploat.setEnabled(false);
		jp.add(ploat,0);
		ploat.setFont(new Font("微软雅黑", 0, 30));
		ploat.setSize(1000, 1000);
		ploat.setOpaque(false);
		if (!StringOperation.strWho(new UserInfo().getGrade(), "3")) {
			try {//起始剧情
				Thread.sleep(500);
				ploat.append("神秘人：勇敢的飞行员，你惧怕黑暗吗..." + "\n\n");
				Thread.sleep(1800);
				ploat.append(usi.getName() + "：这是哪儿！！！你是谁？" + "\n\n");
				Thread.sleep(1800);
				ploat.append("神秘人：我是谁？我谁也不是，又谁都是。" + "\n\n");
				Thread.sleep(1800);
				ploat.append(usi.getName() + "：装神弄鬼，放我出去" + "\n\n");
				Thread.sleep(1800);
				ploat.append("神秘人：外面的世界有什么好，待在我创造的黑白世界里吧！" + "\n\n");
				Thread.sleep(1800);
				ploat.append(usi.getName() + "：（创造世界？）你到底是什么人" + "\n\n");
				Thread.sleep(1800);
				ploat.append("神秘人：不相信我？" + "\n\n");
				Thread.sleep(1800);
				ploat.append(usi.getName() + "：随便把人抓来这里，谁不怀疑" + "\n\n");
				Thread.sleep(1800);
				ploat.append("神秘人：也罢，用这架战机打败我，我就让你出去" + "\n\n");
				Thread.sleep(1800);
				ploat.append("神秘人：顺便让你见识一下我的世界" + "\n\n");
				Thread.sleep(1800);
				ploat.append(usi.getName() + "：哼！！！" + "\n\n");
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		jp.remove(ploat);
		
		CreateIcon.setFullScreen(mybk, jp, "03bk");
		jpb.add(mybk,-1);
		/*--------------------begin------------------------*/
		level = new TwoLevel(this);
		((TwoLevel) level).init();
		SwingUtilities.updateComponentTreeUI(jp);
		/*------------------------------------------------*/
	}

	class endploat extends Thread {

		public void run() {

			JTextArea ploat = new JTextArea();
			ploat.setEnabled(false);
			jp.remove(mybk);
			SwingUtilities.updateComponentTreeUI(jp);
			jp.add(ploat,0);
			ploat.setFont(new Font("微软雅黑", 0, 30));
			ploat.setSize(1000, 1000);
			ploat.setForeground(Color.white);
			ploat.setOpaque(false);
			if (!StringOperation.strWho(new UserInfo().getGrade(), "3") && StringOperation.strWho(User.hp, "0")) {
				PositionMove.strup = false;
				try {//结束剧情
					Thread.sleep(500);
					ploat.append("神秘人：你对外面还有眷念，留你在这里也无用" + "\n\n");
					Thread.sleep(1800);
					ploat.append(usi.getName() + "：那还不让我出去" + "\n\n");
					Thread.sleep(1800);
					ploat.append("神秘人：总有一天，你会自愿来的" + "\n\n");
					Thread.sleep(1800);
					ploat.append(usi.getName() + "：不会的." + "\n\n");
					Thread.sleep(1800);
					ploat.append("神秘人：呵呵，这个世界相对外面的世界，单纯却共通，有何感悟" + "\n\n");
					Thread.sleep(1800);
					ploat.append(usi.getName() + "：哼！！！" + "\n\n");
					Thread.sleep(1800);
					ploat.append("神秘人：看来还是有，不想说，算了吧" + "\n\n");
					Thread.sleep(1800);
					ploat.append(usi.getName() + "：黑与白之间，更多的是灰暗吧" + "\n\n");
					Thread.sleep(1800);
					ploat.append("神秘人：哈哈！送你点礼物，用这个力量攻击这里，出去吧！" + "\n\n");
					Thread.sleep(1800);
					Thread.sleep(1000);
					while (User.getJl().getY() > 0) {
						User.getJl().setLocation( User.getJl().getX(),User.getJl().getY()-8);
						Thread.sleep(5);
					}
					/*
					 * 初始过关代码区
					 */
					UserSetInfo uset = new UserSetInfo();
					uset.setGrade("4");
					uset.setHp(StringOperation.strAdd(uset.getHp(), "50"));
					uset.setAp(StringOperation.strAdd(uset.getAp(), "5"));
					uset.setPlane("user04");
					uset.setStorage();
					
					/*----------------------------------------------------------------*/
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if(!StringOperation.strWho(new UserInfo().getAp(), "40") && StringOperation.strWho(User.hp, "0"))
			{
				UserSetInfo uset = new UserSetInfo();
				uset.setAp(StringOperation.strAdd(uset.getAp(), "1"));
				uset.setStorage();
			}
			
			jpb.setVisible(false);
			jpb.removeAll();
			GameGui.getCon().remove(jpb);
			GameGui.getJf().add(LevelChange.getJp());
			LevelChange.getJp().setVisible(true);
			SwingUtilities.updateComponentTreeUI(GameGui.getJf());

		}

	}

	@Override
	public String getBoom() {
		// TODO Auto-generated method stub
		return "colorboom";
	}
}
