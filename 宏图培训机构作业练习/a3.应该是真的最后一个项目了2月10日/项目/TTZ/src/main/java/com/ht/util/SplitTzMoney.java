package com.ht.util;

import java.util.ArrayList;
import java.util.List;

public class SplitTzMoney {

	// ·ÖÉ¢Í¶×Ê
	public static Double SplitMoney(Double TzMoney, int count) {
		List<Double> list = new ArrayList<Double>();
		Double money = TzMoney / count;
		return money;
	}

	public static void main(String[] args) {
		SplitTzMoney.SplitMoney(90000.00, 4);
	}

}
