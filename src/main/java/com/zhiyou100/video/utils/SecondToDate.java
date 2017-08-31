package com.zhiyou100.video.utils;

public class SecondToDate {
	
	public static String ToDate(int seconds){
		int temp=0;
	    StringBuffer sb=new StringBuffer();
	    //sb.append(seconds/3600+":");
	    sb.append((seconds/3600<10)?"0"+(seconds/3600)+":" : ""+(seconds/3600)+":");
	    temp=seconds%3600/60;
	    sb.append((temp<10)?"0"+temp+":":""+temp+":");
	    temp=seconds%3600%60;
	    sb.append((temp<10)?"0"+temp:""+temp);
	    return sb.toString();
	}
}
