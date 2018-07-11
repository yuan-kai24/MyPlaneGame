package com.yk.load;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.yk.game.GameGui;
import com.yk.plane.PlaneInfo;
import com.yk.tool.CreateIcon;
import com.yk.tool.FormMove;
import com.yk.tool.StringOperation;
import com.yk.user.UserInfo;
import com.yk.user.UserSetInfo;

public class SettingGui {
	private static JPanel jp = new JPanel();
	private static JLabel planenow = new JLabel();// 战机
	private static JLabel planehp = new JLabel();
	private static JLabel planeap = new JLabel();
	private static JLabel myhp = new JLabel();
	private static JLabel myap = new JLabel();

	public static JPanel setSetting() {
		jp.setLayout(null);
		jp.setSize(GameGui.getJf().getWidth(), GameGui.getJf().getHeight());
		JLabel background = new JLabel();
		CreateIcon.setFullScreen(background, GameGui.getJf(), "sbk");

		jp.add(myerror());
		jp.add(setUserInfo());
		jp.add(setPlaneSet());
		jp.add(setReturn());
		jp.add(background);

		return jp;
	}

	private static JPanel setUserInfo() {
		JPanel setjp = new JPanel();
		setjp.setLayout(null);
		setjp.setBackground(Color.cyan);
		setjp.setSize(600, 600);
		JLabel username = new JLabel("账号:");
		JLabel password = new JLabel("密码:");
		JLabel name = new JLabel("用户名:");
		/*-----------------------------------------------------------*/
		username.setFont(new Font("微软雅黑", 1, 30));
		username.setForeground(Color.white);
		username.setSize(75, 30);
		username.setLocation(50, 60);

		password.setFont(new Font("微软雅黑", 1, 30));
		password.setForeground(Color.white);
		password.setSize(75, 30);
		password.setLocation(50, 100);

		name.setFont(new Font("微软雅黑", 1, 30));
		name.setForeground(Color.white);
		name.setSize(105, 30);
		name.setLocation(20, 140);

		setjp.add(username);
		setjp.add(password);
		setjp.add(name);
		/*-----------------------------------------------------------*/
		final JTextField jtun = new JTextField();
		final JTextField jpass = new JTextField();
		final JTextField jname = new JTextField();
		/*-----------------------------------------------------------*/
		jtun.setSize(300, 30);
		jtun.setLocation(username.getWidth() + username.getX() + 10,
				username.getY());
		jtun.setFont(new Font("微软雅黑", 0, 25));
		jtun.setText(new UserInfo().getUsername());

		jpass.setSize(300, 30);
		jpass.setLocation(password.getWidth() + password.getX() + 10,
				password.getY());
		jpass.setFont(new Font("微软雅黑", 0, 25));
		jpass.setText(new UserInfo().getPassword());

		jname.setSize(300, 30);
		jname.setLocation(name.getWidth() + name.getX() + 10, name.getY());
		jname.setFont(new Font("微软雅黑", 0, 25));
		jname.setText(new UserInfo().getName());

		setjp.add(jtun);
		setjp.add(jpass);
		setjp.add(jname);
		/*-----------------------------------------------------------*/

		JLabel userhp = new JLabel();
		JLabel userap = new JLabel();
		/*-----------------------------------------------------------*/
		myhp.setFont(new Font("微软雅黑", 1, 30));
		myhp.setForeground(Color.red);
		myhp.setSize(400, 30);
		myhp.setLocation(80, name.getY() + 60);
		myhp.setText("生命值："
				+ StringOperation.strAdd(
						new PlaneInfo(new UserInfo().getPlane()).getHp(),
						new UserInfo().getHp()));

		myap.setFont(new Font("微软雅黑", 1, 30));
		myap.setForeground(Color.orange);
		myap.setSize(400, 30);
		myap.setLocation(80, name.getY() + 110);
		myap.setText("攻击力："
				+ StringOperation.strAdd(
						new PlaneInfo(new UserInfo().getPlane()).getAttack(),
						new UserInfo().getAp()));

		userhp.setFont(new Font("微软雅黑", 1, 30));
		userhp.setForeground(Color.red);
		userhp.setSize(400, 30);
		userhp.setLocation(20, name.getY() + 160);
		userhp.setText("用户生命值：" + new UserInfo().getHp());

		userap.setFont(new Font("微软雅黑", 1, 30));
		userap.setForeground(Color.orange);
		userap.setSize(400, 30);
		userap.setLocation(20, name.getY() + 210);
		userap.setText("用户攻击力：" + new UserInfo().getAp());

		setjp.add(myhp);
		setjp.add(myap);
		setjp.add(userhp);
		setjp.add(userap);
		/*-----------------------------------------------------------*/

		/*-----------------------------------------------------------*/
		CreateIcon.setCharacter(planenow, new UserInfo().getPlane());
		planenow.setName(new UserInfo().getPlane());
		planenow.setLocation(40, setjp.getHeight() - planenow.getHeight() - 40);

		setjp.add(planenow);

		/*-----------------------------------------------------------*/

		/*-----------------------------------------------------------*/

		planehp.setFont(new Font("微软雅黑", 0, 20));
		planehp.setSize(400, 20);
		planehp.setForeground(Color.red);
		planehp.setText("战机生命值:"
				+ new PlaneInfo(new UserInfo().getPlane()).getHp());
		planehp.setLocation(planenow.getX() + planenow.getWidth() + 30,
				planenow.getY() + 20);

		planeap.setFont(new Font("微软雅黑", 0, 20));
		planeap.setSize(400, 20);
		planeap.setForeground(Color.orange);
		planeap.setText("战机攻击力:"
				+ new PlaneInfo(new UserInfo().getPlane()).getAttack());
		planeap.setLocation(planenow.getX() + planenow.getWidth() + 30,
				planenow.getY() + 80);

		setjp.add(planehp);
		setjp.add(planeap);
		/*-----------------------------------------------------------*/

		JButton submitmy = new JButton("确认修改");
		/*-----------------------------------------------------------*/
		submitmy.setSize(180, 40);
		submitmy.setFont(new Font("微软雅黑", 0, 28));
		submitmy.setLocation(setjp.getWidth() - submitmy.getWidth() - 50,
				setjp.getHeight() - submitmy.getHeight() - 20);

		submitmy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserSetInfo uset = new UserSetInfo();
				uset.setUsername(jtun.getText());
				uset.setPassword(jpass.getText());
				uset.setName(jname.getText());
				uset.setPlane(planenow.getName());
				uset.setStorage();
			}
		});

		setjp.add(submitmy);
		/*----------------------------------------------------------*/

		setjp.setLocation(
				GameGui.getJf().getWidth() / 2 - setjp.getWidth() / 2, 100);
		return setjp;
	}

	private static JPanel setPlaneSet() {
		JPanel setplane = new JPanel();
		setplane.setSize(600, 200);
		setplane.setLayout(null);
		setplane.setLocation(jp.getWidth() / 2 - setplane.getWidth() / 2, 750);

		/*------------------------------------------------------------------------------------------*/
		final JButton plane1 = new JButton();
		plane1.setName("user01");
		plane1.setBackground(Color.white);
		CreateIcon.setButton(plane1, plane1.getName());
		plane1.setLocation(10, setplane.getHeight() / 2 - plane1.getHeight()
				/ 2);
		plane1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateIcon.setCharacter(planenow, plane1.getName());
				planenow.setName(plane1.getName());
				planehp.setText("战机生命值:"
						+ new PlaneInfo(plane1.getName()).getHp());
				planeap.setText("战机攻击力:"
						+ new PlaneInfo(plane1.getName()).getAttack());
				myhp.setText("生命值："
						+ StringOperation.strAdd(
								new PlaneInfo(plane1.getName()).getHp(),
								new UserInfo().getHp()));
				myap.setText("攻击力："
						+ StringOperation.strAdd(
								new PlaneInfo(plane1.getName()).getAttack(),
								new UserInfo().getAp()));
				
			}
		});
		setplane.add(plane1);
		/*------------------------------------------------------------------------------------------*/

		/*------------------------------------------------------------------------------------------*/
		final JButton plane2 = new JButton();
		plane2.setName("user03");
		plane2.setBackground(Color.white);
		CreateIcon.setButton(plane2, plane2.getName());
		plane2.setLocation(plane1.getX() + plane1.getWidth() + 10,
				setplane.getHeight() / 2 - plane2.getHeight() / 2);
		plane2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (StringOperation.strWho(new UserInfo().getGrade(), "2")) {
					CreateIcon.setCharacter(planenow, plane2.getName());
					planenow.setName(plane2.getName());
					planehp.setText("战机生命值:"
							+ new PlaneInfo(plane2.getName()).getHp());
					planeap.setText("战机攻击力:"
							+ new PlaneInfo(plane2.getName()).getAttack());
					myhp.setText("生命值："
							+ StringOperation.strAdd(
									new PlaneInfo(plane2.getName()).getHp(),
									new UserInfo().getHp()));
					myap.setText("攻击力："
							+ StringOperation.strAdd(
									new PlaneInfo(plane2.getName()).getAttack(),
									new UserInfo().getAp()));
				} else {
					jpe.setVisible(true);
				}

			}
		});
		setplane.add(plane2);
		/*------------------------------------------------------------------------------------------*/

		/*------------------------------------------------------------------------------------------*/
		final JButton plane3 = new JButton();
		plane3.setName("user04");
		plane3.setBackground(Color.white);
		CreateIcon.setButton(plane3, plane3.getName());
		plane3.setLocation(plane2.getX() + plane2.getWidth() + 10,
				setplane.getHeight() / 2 - plane3.getHeight() / 2);
		plane3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (StringOperation.strWho(new UserInfo().getGrade(), "3")) {
					CreateIcon.setCharacter(planenow, plane3.getName());
					planenow.setName(plane3.getName());
					planehp.setText("战机生命值:"
							+ new PlaneInfo(plane3.getName()).getHp());
					planeap.setText("战机攻击力:"
							+ new PlaneInfo(plane3.getName()).getAttack());
					myhp.setText("生命值："
							+ StringOperation.strAdd(
									new PlaneInfo(plane3.getName()).getHp(),
									new UserInfo().getHp()));
					myap.setText("攻击力："
							+ StringOperation.strAdd(
									new PlaneInfo(plane3.getName()).getAttack(),
									new UserInfo().getAp()));
				} else {
					jpe.setVisible(true);
				}

			}
		});
		setplane.add(plane3);
		/*------------------------------------------------------------------------------------------*/

		/*------------------------------------------------------------------------------------------*/
		final JButton plane4 = new JButton();
		plane4.setName("user05");
		plane4.setBackground(Color.white);
		CreateIcon.setButton(plane4, plane4.getName());
		plane4.setLocation(plane3.getX() + plane3.getWidth() + 10,
				setplane.getHeight() / 2 - plane4.getHeight() / 2);
		plane4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (StringOperation.strWho(new UserInfo().getGrade(), "4")) {
					CreateIcon.setCharacter(planenow, plane4.getName());
					planenow.setName(plane4.getName());
					planehp.setText("战机生命值:"
							+ new PlaneInfo(plane4.getName()).getHp());
					planeap.setText("战机攻击力:"
							+ new PlaneInfo(plane4.getName()).getAttack());
					myhp.setText("生命值："
							+ StringOperation.strAdd(
									new PlaneInfo(plane4.getName()).getHp(),
									new UserInfo().getHp()));
					myap.setText("攻击力："
							+ StringOperation.strAdd(
									new PlaneInfo(plane4.getName()).getAttack(),
									new UserInfo().getAp()));
				} else {
					jpe.setVisible(true);
				}

			}
		});
		setplane.add(plane4);
		/*------------------------------------------------------------------------------------------*/

		return setplane;
	}

	public static JPanel getJp() {
		return jp;
	}

	private static JLabel setReturn() {
		JLabel jlreturn = new JLabel();

		CreateIcon.setCharacter(jlreturn, "return");
		jlreturn.setLocation(15, 20);
		jlreturn.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				jp.setVisible(false);
				jp.removeAll();
				GameGui.getCon().add(ChangeGui.getJp());
				ChangeGui.getJp().setVisible(true);
			}
		});
		return jlreturn;

	}

	public static JPanel jpe = new JPanel();

	public static JPanel myerror() {

		jpe.setLayout(null);
		jpe.setSize(300, 200);
		jpe.setBackground(Color.gray);
		new FormMove().setMove(jpe);

		JLabel jl = new JLabel("战机未解锁");
		jl.setForeground(Color.white);

		jl.setFont(new Font("微软雅黑", 0, 40));
		jl.setSize(200, 40);
		jl.setLocation(jpe.getWidth() / 2 - jl.getWidth() / 2, 50);
		jpe.add(jl);
		jpe.setVisible(false);
		JLabel jb = new JLabel();
		CreateIcon.setCharacter(jb, "okbutton");
		jb.setLocation(jpe.getWidth() / 2 - jb.getWidth() / 2,
				jpe.getHeight() - 60);
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

		jpe.setLocation(GameGui.getJf().getWidth() / 2 - jpe.getWidth() / 2,
				GameGui.getJf().getHeight() / 2 - jpe.getHeight() / 2);
		return jpe;
	}

}
