package com.yk.Level;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import com.yk.trajectory.BulletAdd;

public class XJLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	private String hp;
	private String ap;
	private boolean lastboos = false;
	private List<BulletAdd> txjl = new ArrayList<BulletAdd>();

	public void setThread(String hp, String ap) {
		this.hp = hp;
		this.ap = ap;
	}

	public void startThread() {
		for (BulletAdd myxjl : txjl) {
			myxjl.start();
		}
	}

	public void setLastboos(boolean lastboos) {
		this.lastboos = lastboos;
	}

	public boolean isLastboos() {
		return lastboos;
	}

	public void addBulletAdd(BulletAdd txjl, String className) {
		this.txjl.add(txjl);
		txjl.setAddBullet(className);
	}

	public String getHp() {
		return hp;
	}

	public String getAp() {
		return ap;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

}