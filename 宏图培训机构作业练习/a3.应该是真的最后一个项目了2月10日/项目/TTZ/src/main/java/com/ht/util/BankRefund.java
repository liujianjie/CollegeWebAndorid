package com.ht.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRefund {
	/**
	 * 
	 * 等额本金还款法【利息少，但前期还的多】
	 * 
	 * @param totalMoeny
	 *            贷款总额
	 * @param rate
	 *            贷款商业利率
	 * @param year
	 *            贷款月限
	 */
	public static Map<String, Double> principal_debj(Double totalMoney, double rate, int month) {
		Map<String, Double> map = new HashMap<String, Double>();
		/**
		 * 每月本金
		 */
		int totalMonth = month;// 月
		double monthPri = totalMoney / totalMonth;
		/**
		 * 获取月利率
		 */
		double monRate = resMonthRate(rate);
		// System.out.println("获取月利率" + monRate);
		BigDecimal b = new BigDecimal(monRate);
		monRate = b.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
		Double sums = 0.00;
		for (int i = 1; i <= totalMonth; i++) {
			double monthRes = monthPri + (totalMoney - monthPri * (i - 1)) * monRate;
			BigDecimal b1 = new BigDecimal(monthRes);
			monthRes = b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			// System.out.println("第" + i + "月，还款为：" + monthRes);
			map.put(i + "", monthRes);
			sums += monthRes;
		}
		// System.out.println("总还款金额为:" + sums);
		return map;
	}

	/**
	 * 
	 * 等额本息还款【利息多】
	 * 
	 * @param totalMoeny
	 *            贷款总额
	 * @param rate
	 *            贷款商业利率
	 * @param year
	 *            贷款月限
	 */
	public static Double interest_debx(Double totalMoney, double rate, int month) {
		/**
		 * 获取月利率
		 */
		double monRate = resMonthRate(rate);
		// System.out.println("月利率" + monRate);
		/**
		 * 月还款本息
		 */
		double monInterest = totalMoney * monRate * Math.pow((1 + monRate), month)
				/ (Math.pow((1 + monRate), month) - 1);
		BigDecimal b = new BigDecimal(monInterest);
		monInterest = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		// System.out.println("月供本息和：" + monInterest);
		// System.out.println("本金:" + (monInterest - (totalMoney * monRate /
		// month)));
		// System.out.println("利息:" + (totalMoney * monRate / month));
		// System.out
		// .println("本金加利息:" + ((monInterest - (totalMoney * monRate / month)) +
		// (totalMoney * monRate / month)));
		return monInterest;
	}

	/**
	 * 
	 * 转换为月利率
	 * 
	 * @param rate
	 * @return
	 */
	public static double resMonthRate(double rate) {
		return rate / 12;
	}

	/**
	 * TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Double totalMoney = 20000.00;// 借款金额
		double rate = 0.14;// 年化收益
		int month = 12;// 借款期限(月)
		// BankRefund.interest(totalMoney, rate, year);
		// BankRefund.interest_debx(totalMoney, rate, month);
		// BankRefund.principal_debj(totalMoney, rate, month);
	}
}
