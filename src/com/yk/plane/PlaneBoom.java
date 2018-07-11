package com.yk.plane;

import javax.swing.JLabel;

import com.yk.map.LevelMap;
import com.yk.tool.CreateIcon;

public class PlaneBoom extends Thread {

	public static void setBoom(JLabel jl,LevelMap lm) {
		for (int i = 0; i < 17; i++) {
			CreateIcon.setCharacter(jl, lm.getBoom() + "/e" + i + "");
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
