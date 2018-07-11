package com.yk.tool;

import javax.swing.JLabel;

import com.yk.Level.XJLabel;
import com.yk.map.LevelMap;
import com.yk.plane.PlaneBoom;
import com.yk.user.User;

public class RemoveNpcCuthp {

	public static void starCut(JLabel jbull, XJLabel nowxjl,XJLabel [] xjl,
			LevelMap lm) {
		jbull.setVisible(false);
		if (nowxjl != null) {
			nowxjl.setHp(StringOperation.strCut(nowxjl.getHp(), User.ap));
			if (!StringOperation.strWho(nowxjl.getHp(), "0")) {
				PlaneBoom.setBoom(nowxjl,lm);
				nowxjl.setVisible(false);
				lm.getJp().remove(nowxjl);
				for(int i = 0;i < xjl.length;i++)
				{
					if(xjl[i].isVisible())
					{
						return;
					}
				}
				if (nowxjl.isLastboos()) {
					OkButton.setOkButton(lm, "挑战成功");
				}
			}
		}

	}

}
