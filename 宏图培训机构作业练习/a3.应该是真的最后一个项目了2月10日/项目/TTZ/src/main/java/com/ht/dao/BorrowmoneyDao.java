package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Borrowmoney;
import com.ht.pojo.Borrowmoney2;
import com.ht.pojo.TenderRecord;

public interface BorrowmoneyDao {
	public List<Borrowmoney> selBorrow(String id);

	public List<Borrowmoney> selAllBorrow();

	public Borrowmoney selBorrowByid(String id);

	public int Insertborrow(Borrowmoney bro);

	public int updBorrowStatu(Map map);

	// 三个时间段的时间查询
	public List<Borrowmoney2> selBorrowMoneySomeList(Map<String, Object> map);

	// 刘建杰写 为了查询借贷信息。2月23日 -所有借贷信息的列表，几个简单字段，不包含所有字段 最后还有类型吧 要分页
	public List<Borrowmoney> selMoreBorrowMoneySomeList(Map<String, Object> map);

	public int selBorrowListsize();// size

	// 条件查询
	public List<Borrowmoney> selMoreBorrowMoneySomeListWhere(Map<String, Object> map);

	public int selBorrowListWheresize(Map<String, Object> map);// 条件查询大小

	public Borrowmoney getBorrowMoney(String id);

	// 更改借款表投资总额 和投资 插入资金记录 和投资记录表数据 调用存储过程
	public int goBorrowmoneyTZ(Map<String, Object> map);

	// 更改借款表 条件更改
	public int updateBorrowmoneyTJ(Map<String, Object> map);

	// 查询满标的借款
	public List selBorrowMoneymb();

	// 根据借款id查找该笔借款的所有投资
	public List<TenderRecord> selectTenderRecordForT_ID(String t_id);

	public List<Borrowmoney> sel_borrow();// 列表

	// 还款
	public int Tohuankuang(Map<String, Object> map);

	// 还款 给投资人收益
	public int TohuankuangSY(Map<String, Object> map);

	// vip团信息发布
	public int InsertVipborrow(Borrowmoney bro);

	// 按类型查找借款(vip团)
	public List<Borrowmoney> selectBorrowMoneyVip(Map<String, Object> map);

	// 更改vip团的状态(10 开启 11结束)
	public int updateVipBorrowmoney(Map<String, Object> map);

	// 查找发布中的散标
	public List<Borrowmoney> selectBorrowMoneyOnStatu2();

	// vip标投资
	public int goBorrowmoneyVipTZ(Map<String, Object> map);
	
	//首页统计图
	public List<Borrowmoney> selTongji();

	// 发布债权转让信息
	public int InsertZaiQuanborrow(Borrowmoney bro);

	// 查找发布着的债权抵押借款 12债权抵押中
	public List<Borrowmoney> selectBorrowMoneyZaiQuanstatu12();
	
	//购买债权
	public int goBorrowmoneyZaiquan(Map<String, Object> map);
	
	//条件查询借贷信息
	public List<Borrowmoney> sel_borrow_statu(Map<String, Object> map);

}
