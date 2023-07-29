package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * description
 *
 * @author mist
 */
public class DateTimeUtils {

    public static String generateOrderNum(){
        Random random= new Random(System.currentTimeMillis());
        String rand= (Math.abs(random.nextInt(900))+100)+"";
        String orderid=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+rand;
        return orderid;
    }
    }
