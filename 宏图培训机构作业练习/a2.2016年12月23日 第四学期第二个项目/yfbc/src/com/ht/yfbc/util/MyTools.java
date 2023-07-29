package com.ht.yfbc.util;

import java.util.UUID;

public class MyTools {
	public static String getNewFileName(String oldfilename){
		String uuid=UUID.randomUUID().toString();
		String newfilename=uuid+oldfilename.substring(oldfilename.lastIndexOf("."), oldfilename.length());
		/**补充：substring(int beginIndex ,int endIndex)如何截取？
		 * 获取该字符串的一个子串，从beginIndex（包括beginIndex位置的字符）
		 * 	取到endIndex(不包括endIndex位置的字符)
		 * 比如：String str="abcdefg";
		 * 		 String str1=str.substring(2,4);
		 * 		 结果为cd
		 * */
		//lastIndexOf(str);获取一个字符串的最后一个指定字符的位置
		return newfilename;
	}
}