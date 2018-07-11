package com.yk.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class UserInfo {
	private Properties prt = new Properties();

	public UserInfo() {
		File fl = new File("src/com/yk/user/Information");
		try {	
			BufferedReader bf = new BufferedReader(new FileReader(fl));
			prt.load(bf);
			bf.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return prt.getProperty("username");
	}

	public String getPassword() {
		return prt.getProperty("password");
	}

	public String getName() {
		return prt.getProperty("name");
	}

	public String getGrade() {
		return prt.getProperty("grade");
	}

	public String getHp() {
		return prt.getProperty("hp");
	}

	public String getAp() {
		return prt.getProperty("ap");
	}
	
	public String getPlane()
	{
		return prt.getProperty("plane");
	}

}
