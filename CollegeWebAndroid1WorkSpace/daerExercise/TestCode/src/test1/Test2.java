package test1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test2 {
public static void main(String[] args) {
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Calendar calendar = Calendar.getInstance();
	String day = formatter.format(calendar.getTime());// 今天
	
	// 明天
	calendar.setTime(calendar.getTime());
	System.out.println(calendar.getTimeInMillis());
	calendar.add(Calendar.DAY_OF_MONTH, 1);
	System.out.println(calendar.getTimeInMillis());
	String tomorrow = formatter.format(calendar.getTime());// 明天
	
	System.out.println(day);
	System.out.println(tomorrow);
	
}
}
