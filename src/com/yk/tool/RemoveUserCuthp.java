package com.yk.tool;

import javax.swing.SwingUtilities;

import com.yk.Level.XJLabel;
import com.yk.map.LevelMap;
import com.yk.plane.PlaneBoom;
import com.yk.user.User;

public class RemoveUserCuthp {

	public static void startCut(XJLabel xjl, final LevelMap lm) {

			User.hp = StringOperation.strCut(User.hp, xjl.getAp());
			SwingUtilities.updateComponentTreeUI(lm.getJp());
			lm.setDisplayJl();
			if (!StringOperation.strWho(User.hp, "0")) {
				// 用户死亡
				PositionMove.strup = false;
				PlaneBoom.setBoom(User.getJl(),lm);
				lm.getJp().remove(User.getJl());
				/*----------------------------------------------------------*/
				OkButton.setOkButton(lm, "挑战失败");
				/*----------------------------------------------------------*/

		}

	}

}
