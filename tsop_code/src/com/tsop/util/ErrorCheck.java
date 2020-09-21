package com.tsop.util;

public class ErrorCheck {
	
	public static boolean nullCheck(String[] str){
		if(str == null){return false;}
		for(int i=0; i<str.length;i++)
		{
			if(str[i] == null){return false;}
		}
		
		return true;
	}
}
