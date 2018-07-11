package com.yk.user;

import javax.swing.JLabel;

import com.yk.Level.XJLabel;
import com.yk.game.GameGui;
import com.yk.map.LevelMap;
import com.yk.plane.PlaneInfo;
import com.yk.tool.CreateIcon;
import com.yk.tool.PositionMove;
import com.yk.tool.StringOperation;

public class User {
	private static String path = new UserInfo().getPlane();
	private static JLabel jl = new JLabel();
	public static String hp;
	public static String ap;
	public static boolean isstop = true;

	public static JLabel setUser(LevelMap lm, XJLabel[] xjl) {

		jl.setVisible(true);
		PositionMove.strup = true;
		isstop = true;
		path = new UserInfo().getPlane();
		CreateIcon.setCharacter(jl, path);
		Thread userjl = new PositionMove(jl, lm, xjl);
		userjl.start();
		

		jl.setLocation(GameGui.getJf().getWidth() / 2 - 100, GameGui.getJf()
				.getHeight() - 200);
		
		
		hp = StringOperation.strAdd(new PlaneInfo(path).getHp(), new UserInfo().getHp());
		ap = StringOperation.strAdd((new PlaneInfo(path).getAttack()), new UserInfo().getAp());
		return jl;
	}

	

	public static JLabel getJl() {
		return jl;
	}

	public static void UpdataUser() {
		hp = Integer.valueOf((new PlaneInfo(path).getHp()))
				+ Integer.valueOf(new UserInfo().getHp()) + "";
		ap = Integer.valueOf((new PlaneInfo(path).getAttack()))
				+ Integer.valueOf(new UserInfo().getAp()) + "";

	}

	public static void setPath(String path) {
		User.path = path;
	}

	public static String getPath() {
		return path;
	}

}
