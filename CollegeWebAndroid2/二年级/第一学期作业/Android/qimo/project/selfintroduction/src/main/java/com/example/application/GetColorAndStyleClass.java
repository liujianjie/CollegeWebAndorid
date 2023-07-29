package com.example.application;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;

// 公共从索引变成颜色项和样式
public class GetColorAndStyleClass {
	public static int getColorFromIndex(int index){
		int co = 0;
		switch (index) {
		case 0:
			co = Color.BLACK;
			break;
		case 1:
			co = Color.RED;
			break;
		case 2:
			co = Color.YELLOW;
			break;
		case 3:
			co = Color.BLUE;
			break;
		default:
			break;
		}
		return co;
	}
	public static int getStyleFromIndex(int index){
		int co = 0;
		switch (index) {
		case 0:
			co = Typeface.NORMAL;
			break;
		case 1:
			co = Typeface.BOLD;
			break;
		case 2:
			co = Typeface.ITALIC;
			break;
		case 3:
			co = Typeface.BOLD_ITALIC;
			break;
		}
		return co;
	}
}
