package com.yk.tool;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CreateIcon {
	
	public static void setCharacter(final JLabel jl,String path)
	{
		File fl = new File("resources/imges/"+path+".png");
		Icon icon = null;
		try {
			icon = new ImageIcon(fl.toURI().toURL());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jl.setIcon(icon);
		jl.setSize(icon.getIconWidth(),icon.getIconHeight());
	}
	
	public static void setButton(final JButton jb,String path)
	{
		File fl = new File("resources/imges/"+path+".png");
		Icon icon = null;
		try {
			icon = new ImageIcon(fl.toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		jb.setIcon(icon);
		jb.setSize(icon.getIconWidth(),icon.getIconHeight());
	}
	
	public static void setGuiIcon(JFrame jf, String path)
	{
		File fl = new File("resources/imges/"+path+".png");
		try {
			Image imge = ImageIO.read(fl);
			jf.setIconImage(imge);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void setFullScreen(JLabel jl,Component com,String path)
	{
		File fl = new File("resources/imges/"+path+".png");
		jl.setSize(com.getWidth(),com.getHeight());
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(fl.toURI().toURL());
			icon = new ImageIcon(( icon.getImage().getScaledInstance(jl.getWidth(), jl.getHeight(), Image.SCALE_DEFAULT)));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		jl.setIcon(icon);
		  
	}

}
