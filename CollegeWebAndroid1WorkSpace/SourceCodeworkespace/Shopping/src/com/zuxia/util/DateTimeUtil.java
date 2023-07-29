package com.zuxia.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	// 字符串转换为Date
	public static Date convertDate(String dateStr) {
		if(StringUtil.isNullOrEmpty(dateStr)){
			return null;
		}
		
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			d = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return d;
	}
	
	// Date转换为时间字符串
	public static String convertDate(Date date) {
		if(null==date){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static Date convertDateNoTime(String dateStr) {
		if(StringUtil.isNullOrEmpty(dateStr)){
			return null;
		}
		
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return d;
	}
	
	public static String convertDateNoTime(Date date) {
		if(null==date){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
}
