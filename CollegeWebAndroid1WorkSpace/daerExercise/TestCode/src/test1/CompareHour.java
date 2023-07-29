package test1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CompareHour {
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
		Calendar calendar = Calendar.getInstance();
		System.out.println(formatter.format(calendar.getTime()));
		
	}
}	
