package com.yk.user;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class UserSetInfo extends UserInfo {
	private String username = getUsername();
	private String password = getPassword();
	private String name = getName();
	private String grade = getGrade();
	private String hp = getHp();
	private String ap = getAp();
	private String plane = getPlane();
	
	public void setUsername(String str)
	{
		this.username = str;
	}
	public void setPassword(String str)
	{
		this.password = str;
	}
	public void setName(String str)
	{
		this.name = str;
	}
	public void setGrade(String str)
	{
		this.grade = str;
	}
	public void setHp(String str)
	{
		this.hp = str;
	}
	public void setAp(String str)
	{
		this.ap = str;
	}
	public void setPlane(String str)
	{
		this.plane = str;
	}
	
	public void setStorage()
	{
		try {
			File fl = new File("src/com/yk/user/Information");
			OutputStream out = new BufferedOutputStream(new FileOutputStream(fl));
			StringBuilder str = new StringBuilder();
			str.append("username="+username+"\r\n");
			str.append("password="+password+"\r\n");
			str.append("name="+name+"\r\n");
			str.append("grade="+grade+"\r\n");
			str.append("hp="+hp+"\r\n");
			str.append("ap="+ap+"\r\n");
			str.append("plane="+plane+"\r\n");
			
			out.write(str.toString().getBytes("utf-8"));
			
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
