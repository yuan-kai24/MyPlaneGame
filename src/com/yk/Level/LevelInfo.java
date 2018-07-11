package com.yk.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class LevelInfo {
	private Properties prt = new Properties();

	public LevelInfo(String name) {
		InputStream in = LevelInfo.class.getResourceAsStream(name);
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(in,
					"UTF-8"));
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

	public String getOneAt() {
		return prt.getProperty("oneat");
	}

	public String getOneHp() {
		return prt.getProperty("onehp");
	}
	public String getTwoat() {
		return prt.getProperty("twoat");
	}

	public String getTwoHp() {
		return prt.getProperty("twohp");
	}
	public String getBoosAt() {
		return prt.getProperty("boosat");
	}

	public String getBoosHp() {
		return prt.getProperty("booshp");
	}
	
	public String getXgZd()
	{
		return prt.getProperty("xgzd");
	}
	
	public String getBoosZd()
	{
		return prt.getProperty("booszd");
	}
}
