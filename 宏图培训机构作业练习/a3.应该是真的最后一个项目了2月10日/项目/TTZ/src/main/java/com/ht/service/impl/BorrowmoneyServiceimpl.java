package com.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.BorrowmoneyDao;
import com.ht.pojo.Borrowmoney;
import com.ht.pojo.Borrowmoney2;
import com.ht.pojo.TenderRecord;
import com.ht.service.BorrowmoneyService;

@Service
public class BorrowmoneyServiceimpl implements BorrowmoneyService {
	@Resource
	private BorrowmoneyDao bdao;

	@Override
	public List<Borrowmoney> selBorrow(String id) {

		return bdao.selBorrow(id);
	}

	@Override
	public int Insertborrow(Borrowmoney bro) {
		// TODO Auto-generated method stub
		return bdao.Insertborrow(bro);
	}

	@Override
	public List<Borrowmoney> selAllBorrow() {
		return bdao.selAllBorrow();
	}

	@Override
	public int updBorrowStatu(Map map) {
		// TODO Auto-generated method stub
		return bdao.updBorrowStatu(map);
	}

	@Override
	public Borrowmoney selBorrowByid(String id) {
		// TODO Auto-generated method stub
		return bdao.selBorrowByid(id);
	}

	@Override
	public List<Borrowmoney2> selBorrowMoneySomeList(Map<String, Object> map) {

		return bdao.selBorrowMoneySomeList(map);
	}

	@Override
	public Map<String, Object> selMoreBorrowMoneySomeList(Integer cpage) {
		Integer pageCount = 9;
		Integer totalCount = bdao.selBorrowListsize();
		Integer totalPage = (totalCount + pageCount - 1) / pageCount;

		if (cpage > totalPage) {
			cpage = totalPage;
		}
		if (cpage <= 0) {
			cpage = 1;
		}
		if (totalPage == 0) {
			totalPage = 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", cpage);
		map.put("totalPage", totalPage);
		map.put("totalCount", totalCount);

		List<Borrowmoney> bomlist = bdao.selMoreBorrowMoneySomeList(map);
		map.put("bomlist", bomlist);

		// ��һ���ж���������ֵ�������ҳ��ѯ��
		map.put("where", 0);
		return map;
	}

	public Map<String, Object> selMoreBorrowMoneySomeListWhere(Map<String, Object> map) {
		// ���� ��Ϊ���޶�ֻ��1������ ����˵1 ����ѡ�������ȷʵ 1~6�� ����Ҫ��������ȥ
		String borrowqxs = (String) map.get("borrowqx");
		if (borrowqxs.equals("1")) {
			map.put("borrowqxg", 6);
		} else if (borrowqxs.equals("6")) {
			map.put("borrowqxg", 12);
		} else if (borrowqxs.equals("12")) {
			map.put("borrowqxg", null);
		}
		Integer cpage = (Integer) map.get("cpage");
		Integer pageCount = 9;
		Integer totalCount = bdao.selBorrowListWheresize(map);
		Integer totalPage = (totalCount + pageCount - 1) / pageCount;

		if (cpage > totalPage) {
			cpage = totalPage;
		}
		if (cpage <= 0) {
			cpage = 1;
		}
		if (totalPage == 0) {
			totalPage = 1;
		}
		map.put("pageCount", pageCount);
		map.put("currPage", cpage);
		map.put("totalPage", totalPage);
		map.put("totalCount", totalCount);

		List<Borrowmoney> bomlist = bdao.selMoreBorrowMoneySomeListWhere(map);
		map.put("bomlist", bomlist);
		String borrow_type = (String) map.get("borrow_type");
		if (borrow_type != null && !borrow_type.equals("")) {
			if (borrow_type.equals("������Ѻ")) {
				borrow_type = "1";
			} else if (borrow_type.equals("������Ѻ")) {
				borrow_type = "2";
			} else if (borrow_type.equals("���ô���")) {
				borrow_type = "3";
			}
			map.put("borrow_type", borrow_type);
		}
		String repayment = (String) map.get("repayment");
		if (repayment != null && !repayment.equals("")) {
			if (repayment.equals("�ȶϢ")) {
				repayment = "1";
			} else if (repayment.equals("�ȶ��")) {
				repayment = "2";
			}
			map.put("repayment", repayment);
		}

		// ��һ���ж���������ֵ�������ҳ��ѯ��
		map.put("where", 1);
		return map;
	}

	@Override
	public Borrowmoney getBorrowMoney(String id) {
		return bdao.getBorrowMoney(id);
	}

	// ���Ľ���Ͷ���ܶ� ��Ͷ�� �����ʽ��¼ ��Ͷ�ʼ�¼������ ���ô洢����
	public int goBorrowmoneyTZ(Map<String, Object> map) {
		return bdao.goBorrowmoneyTZ(map);

	}

	// ���Ľ��� ��������
	public int updateBorrowmoneyTJ(Map<String, Object> map) {
		return bdao.updateBorrowmoneyTJ(map);
	}

	@Override
	public List selBorrowMoneymb() {
		// TODO Auto-generated method stub
		return bdao.selBorrowMoneymb();
	}

	// ���ݽ��id���Ҹñʽ�������Ͷ��
	@Override
	public List<TenderRecord> selectTenderRecordForT_ID(String t_id) {
		// TODO Auto-generated method stub
		return bdao.selectTenderRecordForT_ID(t_id);
	}

	// ����
	@Override
	public int Tohuankuang(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bdao.Tohuankuang(map);
	}

	// ���� ��Ͷ��������
	public int TohuankuangSY(Map<String, Object> map) {

		return bdao.TohuankuangSY(map);
	}

	@Override
	public List<Borrowmoney> sel_borrow() {
		// TODO Auto-generated method stub
		return bdao.sel_borrow();
	}

	// vip����Ϣ����
	public int InsertVipborrow(Borrowmoney bro) {
		// TODO Auto-generated method stub
		return bdao.InsertVipborrow(bro);
	}

	// �����Ͳ��ҽ��(vip��)
	public List<Borrowmoney> selectBorrowMoneyVip(Map<String, Object> map) {
		return bdao.selectBorrowMoneyVip(map);
	}

	// ����vip�ŵ�״̬(10 ���� 11����)
	public int updateVipBorrowmoney(Map<String, Object> map) {

		return bdao.updateVipBorrowmoney(map);
	}

	// ���ҷ����е�ɢ��
	public List<Borrowmoney> selectBorrowMoneyOnStatu2() {

		return bdao.selectBorrowMoneyOnStatu2();
	}

	// vip��Ͷ��
	public int goBorrowmoneyVipTZ(Map<String, Object> map) {

		return bdao.goBorrowmoneyVipTZ(map);
	}

	@Override
	public List<Borrowmoney> selTongji() {
		// TODO Auto-generated method stub
		return bdao.selTongji();
	}

	// ����ծȨת����Ϣ
	public int InsertZaiQuanborrow(Borrowmoney bro) {
		return bdao.InsertZaiQuanborrow(bro);
	}

	// ���ҷ����ŵ�ծȨ��Ѻ��� 12ծȨ��Ѻ��
	public List<Borrowmoney> selectBorrowMoneyZaiQuanstatu12() {
		return bdao.selectBorrowMoneyZaiQuanstatu12();
	}

	// ����ծȨ
	public int goBorrowmoneyZaiquan(Map<String, Object> map) {

		return bdao.goBorrowmoneyZaiquan(map);
	}

	@Override
	public List<Borrowmoney> sel_borrow_statu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bdao.sel_borrow_statu(map);
	}
}
