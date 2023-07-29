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

		// 放一个判断是这里出现的条件分页查询的
		map.put("where", 0);
		return map;
	}

	public Map<String, Object> selMoreBorrowMoneySomeListWhere(Map<String, Object> map) {
		// 期限 因为期限都只有1个参数 比如说1 但是选择的条件确实 1~6月 所以要加上条件去
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
			if (borrow_type.equals("车辆抵押")) {
				borrow_type = "1";
			} else if (borrow_type.equals("房产抵押")) {
				borrow_type = "2";
			} else if (borrow_type.equals("信用贷款")) {
				borrow_type = "3";
			}
			map.put("borrow_type", borrow_type);
		}
		String repayment = (String) map.get("repayment");
		if (repayment != null && !repayment.equals("")) {
			if (repayment.equals("等额本息")) {
				repayment = "1";
			} else if (repayment.equals("等额本金")) {
				repayment = "2";
			}
			map.put("repayment", repayment);
		}

		// 放一个判断是这里出现的条件分页查询的
		map.put("where", 1);
		return map;
	}

	@Override
	public Borrowmoney getBorrowMoney(String id) {
		return bdao.getBorrowMoney(id);
	}

	// 更改借款表投资总额 和投资 插入资金记录 和投资记录表数据 调用存储过程
	public int goBorrowmoneyTZ(Map<String, Object> map) {
		return bdao.goBorrowmoneyTZ(map);

	}

	// 更改借款表 条件更改
	public int updateBorrowmoneyTJ(Map<String, Object> map) {
		return bdao.updateBorrowmoneyTJ(map);
	}

	@Override
	public List selBorrowMoneymb() {
		// TODO Auto-generated method stub
		return bdao.selBorrowMoneymb();
	}

	// 根据借款id查找该笔借款的所有投资
	@Override
	public List<TenderRecord> selectTenderRecordForT_ID(String t_id) {
		// TODO Auto-generated method stub
		return bdao.selectTenderRecordForT_ID(t_id);
	}

	// 还款
	@Override
	public int Tohuankuang(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bdao.Tohuankuang(map);
	}

	// 还款 给投资人收益
	public int TohuankuangSY(Map<String, Object> map) {

		return bdao.TohuankuangSY(map);
	}

	@Override
	public List<Borrowmoney> sel_borrow() {
		// TODO Auto-generated method stub
		return bdao.sel_borrow();
	}

	// vip团信息发布
	public int InsertVipborrow(Borrowmoney bro) {
		// TODO Auto-generated method stub
		return bdao.InsertVipborrow(bro);
	}

	// 按类型查找借款(vip团)
	public List<Borrowmoney> selectBorrowMoneyVip(Map<String, Object> map) {
		return bdao.selectBorrowMoneyVip(map);
	}

	// 更改vip团的状态(10 开启 11结束)
	public int updateVipBorrowmoney(Map<String, Object> map) {

		return bdao.updateVipBorrowmoney(map);
	}

	// 查找发布中的散标
	public List<Borrowmoney> selectBorrowMoneyOnStatu2() {

		return bdao.selectBorrowMoneyOnStatu2();
	}

	// vip标投资
	public int goBorrowmoneyVipTZ(Map<String, Object> map) {

		return bdao.goBorrowmoneyVipTZ(map);
	}

	@Override
	public List<Borrowmoney> selTongji() {
		// TODO Auto-generated method stub
		return bdao.selTongji();
	}

	// 发布债权转让信息
	public int InsertZaiQuanborrow(Borrowmoney bro) {
		return bdao.InsertZaiQuanborrow(bro);
	}

	// 查找发布着的债权抵押借款 12债权抵押中
	public List<Borrowmoney> selectBorrowMoneyZaiQuanstatu12() {
		return bdao.selectBorrowMoneyZaiQuanstatu12();
	}

	// 购买债权
	public int goBorrowmoneyZaiquan(Map<String, Object> map) {

		return bdao.goBorrowmoneyZaiquan(map);
	}

	@Override
	public List<Borrowmoney> sel_borrow_statu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bdao.sel_borrow_statu(map);
	}
}
