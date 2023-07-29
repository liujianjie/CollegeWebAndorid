package com.zuxia.util;

/**
 * 字符串工具类
 */
public class StringUtil {
	
	/**
	 * 过滤<, >,\n 字符的方法。
	 * @param input 需要过滤的字符
	 * @return 完成过滤以后的字符串
	 */
	public static String filterHTML(String input) {
		if (input == null) {
			return null;
		}
		if (input.length() == 0) {
			return input;
		}
		input = input.replaceAll("&", "&amp;");
		input = input.replaceAll("<", "&lt;");
		input = input.replaceAll(">", "&gt;");
		input = input.replaceAll(" ", "&nbsp;");
		input = input.replaceAll("'", "&#39;");
		input = input.replaceAll("\"", "&quot;");
		return input.replaceAll("\n", "<br>");
	}
	
	/**
	 * 验证字符串是否为空（null或空字符串）
	 * @param str 要验证的字符串
	 * @return 验证结果（字符串为空返回true，否则返回false）
	 */
	public static boolean isNullOrEmpty(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	/*
	 * 计算字符串的字节长度(字母数字计1，汉字及标点计2) 　　 　　
	 */
	public static int byteLength(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Integer.toHexString(str.charAt(i)).length() == 4) {
				count += 2;
			} else {
				count++;
			}
		}
		return count;
	}

	/**
	 * 按指定长度，省略字符串部分字符
	 * @param str 字符串
	 * @param len 保留字符串长度
	 * @return 省略后的字符串
	 */
	public static String omitString(String str, int len) {
		StringBuffer sb = new StringBuffer();
		if (byteLength(str) > len) {
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				char temp = str.charAt(i);
				if (Integer.toHexString(temp).length() == 4) {
					count += 2;
				} else {
					count++;
				}
				if (count < len - 3) {
					sb.append(temp);
				}
				if (count == len - 3) {
					sb.append(temp);
					break;
				}
				if (count > len - 3) {
					sb.append(" ");
					break;
				}
			}
			sb.append("...");
		} else {
			sb.append(str);
		}
		return sb.toString();
	}
}