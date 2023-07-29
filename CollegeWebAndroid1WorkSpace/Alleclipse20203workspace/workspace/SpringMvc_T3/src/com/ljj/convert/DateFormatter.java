package com.ljj.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date>{
	
	String datePattern = "yyyy-MM-dd HH:mm:ss";
	private SimpleDateFormat simpleDateFormat;
	
	@Override
	public String print(Date date, Locale locale) {
		System.out.println("Formatter");
		return new SimpleDateFormat().format(date);
	}

	@Override
	public Date parse(String source, Locale locale) throws ParseException {
		System.out.println("Formatter");
		simpleDateFormat = new SimpleDateFormat(datePattern);
		return simpleDateFormat.parse(source);
	}
	
}
