package com.ydcun.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getString(Date date,String format){
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}
	
	public static String getString(Date date){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}
}
