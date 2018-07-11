package com.yk.tool;

public class StringOperation {
	
	/*
	 * 测试模式：
	 * 后期采用BigDecimal优化
	 */
	public static String strAdd(String num0,String num1)
	{
		String ret = null;
		
		ret = Integer.valueOf(num0) + Integer.valueOf(num1) + "";
		
		return ret;
	}
	
	public static String strCut(String num0,String num1){
		String ret = null;
		
		ret = Integer.valueOf(num0) - Integer.valueOf(num1) + "";
		
		return ret;
	}
	
	public synchronized static boolean strWho(String n1,String n2)
	{
		Integer in1 = Integer.valueOf(n1);
		Integer in2 = Integer.valueOf(n2);
		if(in1 > in2)
		{
			return true;
		}
		return false;
	}
}
