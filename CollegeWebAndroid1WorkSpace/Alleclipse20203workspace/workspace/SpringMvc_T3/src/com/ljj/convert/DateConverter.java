package com.ljj.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	private String datePattern = "yyyy-MM-dd HH:mm:ss";
	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		System.out.println("convert");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("无效日期格式"+source);
		}
	}

}
