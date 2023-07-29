package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String test = "2021-6-23 11:23:00";
		Date dt = sd.parse(test);
		System.out.println(dt);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int monthDay = calendar.get(Calendar.DAY_OF_MONTH);
        int yearDay = calendar.get(Calendar.DAY_OF_YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        
        weekDay = weekDay == 1 ? 7 : weekDay - 1; 
        
        System.out.println(weekDay);
        System.out.println(hour);
        System.out.println(min);
	}
}
