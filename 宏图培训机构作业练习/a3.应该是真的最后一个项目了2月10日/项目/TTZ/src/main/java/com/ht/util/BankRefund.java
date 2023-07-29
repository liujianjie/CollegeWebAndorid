package com.ht.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRefund {
	/**
	 * 
	 * �ȶ�𻹿����Ϣ�٣���ǰ�ڻ��Ķࡿ
	 * 
	 * @param totalMoeny
	 *            �����ܶ�
	 * @param rate
	 *            ������ҵ����
	 * @param year
	 *            ��������
	 */
	public static Map<String, Double> principal_debj(Double totalMoney, double rate, int month) {
		Map<String, Double> map = new HashMap<String, Double>();
		/**
		 * ÿ�±���
		 */
		int totalMonth = month;// ��
		double monthPri = totalMoney / totalMonth;
		/**
		 * ��ȡ������
		 */
		double monRate = resMonthRate(rate);
		// System.out.println("��ȡ������" + monRate);
		BigDecimal b = new BigDecimal(monRate);
		monRate = b.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
		Double sums = 0.00;
		for (int i = 1; i <= totalMonth; i++) {
			double monthRes = monthPri + (totalMoney - monthPri * (i - 1)) * monRate;
			BigDecimal b1 = new BigDecimal(monthRes);
			monthRes = b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			// System.out.println("��" + i + "�£�����Ϊ��" + monthRes);
			map.put(i + "", monthRes);
			sums += monthRes;
		}
		// System.out.println("�ܻ�����Ϊ:" + sums);
		return map;
	}

	/**
	 * 
	 * �ȶϢ�����Ϣ�ࡿ
	 * 
	 * @param totalMoeny
	 *            �����ܶ�
	 * @param rate
	 *            ������ҵ����
	 * @param year
	 *            ��������
	 */
	public static Double interest_debx(Double totalMoney, double rate, int month) {
		/**
		 * ��ȡ������
		 */
		double monRate = resMonthRate(rate);
		// System.out.println("������" + monRate);
		/**
		 * �»��Ϣ
		 */
		double monInterest = totalMoney * monRate * Math.pow((1 + monRate), month)
				/ (Math.pow((1 + monRate), month) - 1);
		BigDecimal b = new BigDecimal(monInterest);
		monInterest = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		// System.out.println("�¹���Ϣ�ͣ�" + monInterest);
		// System.out.println("����:" + (monInterest - (totalMoney * monRate /
		// month)));
		// System.out.println("��Ϣ:" + (totalMoney * monRate / month));
		// System.out
		// .println("�������Ϣ:" + ((monInterest - (totalMoney * monRate / month)) +
		// (totalMoney * monRate / month)));
		return monInterest;
	}

	/**
	 * 
	 * ת��Ϊ������
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
		Double totalMoney = 20000.00;// �����
		double rate = 0.14;// �껯����
		int month = 12;// �������(��)
		// BankRefund.interest(totalMoney, rate, year);
		// BankRefund.interest_debx(totalMoney, rate, month);
		// BankRefund.principal_debj(totalMoney, rate, month);
	}
}
