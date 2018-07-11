package com.yk.plane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PlaneInfo {
	private Properties prt = new Properties();

	public PlaneInfo(String name) {
		InputStream in = PlaneInfo.class.getResourceAsStream(name);
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			prt.load(bf);
			bf.close();
			in.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}// 中文乱码问题
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getAttack()
	{
		return prt.getProperty("attack");
	}
	
	
	public String getHp()
	{
		return prt.getProperty("hp");
	}
	
	public String getBullet()
	{
		return prt.getProperty("bullet");
	}
}
