package com.ht.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ht.pojo.Borrowmoney;
import com.ht.pojo.Borrowmoney2;
import com.ht.pojo.DetailRepayment;
import com.ht.pojo.Forengmessage;
import com.ht.pojo.FundraisingDeadline;
import com.ht.pojo.People;
import com.ht.pojo.Rates;
import com.ht.pojo.TenderRecord;
import com.ht.pojo.Ttzbank;
import com.ht.pojo.Ttzuser;
import com.ht.pojo.Ziliao;
import com.ht.service.BankcardService;
import com.ht.service.BorrowmoneyService;
import com.ht.service.DetailRepaymentService;
import com.ht.service.ForengmessageService;
import com.ht.service.FundraisingDeadlineService;
import com.ht.service.PeopleService;
import com.ht.service.RatesServiceI;
import com.ht.service.TenderRecordService;
import com.ht.service.TtzbanlService;
import com.ht.service.TtzuserService;
import com.ht.service.ZiliaoService;
import com.ht.util.BankRefund;
import com.ht.util.SplitTzMoney;
import com.ht.util.SystemContant;

@Controller
@RequestMapping("Borrow")
public class BorrowmoneyController {
	@Resource
	private BorrowmoneyService bservice;
	@Resource
	private DetailRepaymentService dservice;
	@Resource
	private BankcardService bankService;
	@Resource
	private TtzbanlService ttzBankService;
	@Resource
	private TtzuserService ttzuserservice;
	@Resource
	private ForengmessageService forservice;
	@Resource
	private TenderRecordService tenderService;
	@Resource
	private PeopleService peoservice;
	@Resource
	private ZiliaoService zlservice;
	@Resource
	private FundraisingDeadlineService funservice;
	@Resource
	private RatesServiceI reteservice;

	@RequestMapping("selBorrowMoney") // 查询我的所有借款（前台）
	public String selBorrowMoney(Model model) {
		List<Borrowmoney> borrlist = bservice.selBorrow(SystemContant.tuser.getUserid());
		Double ljjk = 0.00;// 累计利息
		Double ljlx = 0.00;// 累计金额
		for (Borrowmoney borrowmoney : borrlist) {
			if (!borrowmoney.getStatu().equals("5")) {
				ljjk += borrowmoney.getB_money();
				ljlx += borrowmoney.getShould_money() - borrowmoney.getB_money();
			}
		}
		model.addAttribute("ljjk", ljjk);
		model.addAttribute("ljlx", ljlx);
		model.addAttribute("borrlist", borrlist);
		return "../foregroundSystem/personal_jiekuanjilu.jsp";
	}

	@RequestMapping("selBorrowAll") // 查询所有借款（后台）
	public String selBorrowTobk(Model model) {
		List<Borrowmoney> allborrow = bservice.selAllBorrow();
		model.addAttribute("allborrow", allborrow);
		return "../backgroundSystem/borrow.jsp";
	}

	@RequestMapping("updBorrowstatu") // 更改借款状态
	public String updBorrowstatu(@RequestParam(value = "statu") String statu, @RequestParam(value = "id") String id) {
		Map map = new HashMap();
		map.put("statu", statu);
		map.put("id", id);
		int i = bservice.updBorrowStatu(map);
		Borrowmoney bro = bservice.selBorrowByid(id);
		if (statu.equals("2")) {// 通过
			// 插入消息
			Forengmessage fors = new Forengmessage();
			fors.setM_title("您的借款申请已经通过!");
			fors.setM_content("您的借款申请已经通过!");
			fors.setM_userid(bro.getTid());
			fors.setM_type("1");
			fors.setM_statu("1");
			fors.setM_time(new Date());
			forservice.insertForengmessage(fors);
		} else if (statu.equals("0")) {// 失败
			// 插入消息
			Forengmessage fors = new Forengmessage();
			fors.setM_title("您的借款申请失败!");
			fors.setM_content("请确认您的身份信息是否完善!");
			fors.setM_userid(bro.getTid());
			fors.setM_type("1");
			fors.setM_statu("1");
			fors.setM_time(new Date());
			forservice.insertForengmessage(fors);
		}
		return "selBorrowAll.action";
	}

	@RequestMapping("selBorrowByid") // 查询单条借款
	public String selBorrowByid(@RequestParam(value = "id") String id, Borrowmoney borrow, Model model) {
		borrow = bservice.selBorrowByid(id);
		model.addAttribute("borrow", borrow);
		return "../foregroundSystem/infor.jsp";
	}

	// 借款
	@RequestMapping("BorrowMoney")
	public String BorrowMoney(Model model, Borrowmoney bro) {
		Integer borrowqx = Integer.parseInt(bro.getBorrowqx());// 借款期限
		// 匹配设置项设置利率
		Double mange = 0.00;// 借款管理费
		List<Rates> rates = reteservice.selrateslist();
		Map<String, Object> ratemap = new HashMap<String, Object>();
		for (Rates rates2 : rates) {
			if (rates2.getR_name().equals("借款期限(月)")) {
				ratemap.put(rates2.getR_tiao() + "", rates2.getR_zhi());
			} else if (rates2.getR_name().equals("借款管理费")) {
				mange = rates2.getR_zhi();
			}
		}
		Double rate = 0.00;
		if (borrowqx <= 1) {// 小于等于1月
			bro.setRate(ratemap.get("小于等于1月") + "");
			rate = Double.parseDouble(ratemap.get("小于等于1月") + "");
		} else if (borrowqx > 1 && borrowqx <= 12) {// 大于1月小于12月
			bro.setRate(ratemap.get("大于1月小于12月") + "");
			rate = Double.parseDouble(ratemap.get("大于1月小于12月") + "");
		} else if (borrowqx > 12) {// 大于12月
			bro.setRate(ratemap.get("大于12月") + "");
			rate = Double.parseDouble(ratemap.get("大于12月") + "");
		}

		// 匹配设置项筹款期限
		List<FundraisingDeadline> listfun = funservice.FundraisingDeadlinelist();
		Map<String, Object> funmap = new HashMap<String, Object>();
		for (FundraisingDeadline fundraisingDeadline : listfun) {
			funmap.put(fundraisingDeadline.getJiekuantime() + "", fundraisingDeadline.getChoukuantime());
		}
		Calendar curr = Calendar.getInstance();
		if (borrowqx <= 6) {
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + Integer.parseInt(funmap.get("小于6个月") + ""));
			bro.setYx_time(curr.getTime());
		} else if (borrowqx > 6 && borrowqx <= 12) {
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + Integer.parseInt(funmap.get("大于6个月小于12个月") + ""));
			bro.setYx_time(curr.getTime());
		} else if (borrowqx > 12 && borrowqx < 24) {
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + Integer.parseInt(funmap.get("大于12个月小于24个月") + ""));
			bro.setYx_time(curr.getTime());
		} else if (borrowqx > 24) {
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + Integer.parseInt(funmap.get("大于24个月") + ""));
			bro.setYx_time(curr.getTime());
		}
		// 设置 应还款金额计算(分还款方式)
		if (bro.getRepayment().equals("等额本息")) {
			Double db = BankRefund.interest_debx(bro.getB_money(), rate, Integer.parseInt(bro.getBorrowqx()));
			bro.setShould_money(db * (Integer.parseInt(bro.getBorrowqx())));// 应还款金额
		} else if (bro.getRepayment().equals("等额本金")) {
			Map<String, Double> map = BankRefund.principal_debj(bro.getB_money(), rate,
					Integer.parseInt(bro.getBorrowqx()));
			Double zhk = 0.00;
			for (int i = 0; i < map.size(); i++) {
				Double dd = map.get((i + 1) + "");
				zhk += dd;
			}
			bro.setShould_money(zhk);// 应还款金额
		}
		bro.setB_money(bro.getB_money());
		bro.setManage_money(bro.getB_money() * mange);// 借款管理费
		bro.setPaid_money(bro.getB_money() - (bro.getB_money() * mange));// 实收金额
		bro.setRepay_money(0.00);// 以还款金额
		bro.setCollection_money(0.00);// 收款本金
		bro.setPrincipal_money(0.00);// 收款利息
		bro.setFine_money(0.00);// 罚金
		bro.setTb_money(0.00);// 投标总额
		bro.setTb_unreward("0");// 有无投标奖励
		bro.setTb_rewardtype("");// 投标奖励类型
		bro.setTb_reward("");// 投标奖励
		bro.setRepayment(bro.getRepayment());// 还款方式
		bro.setTb_maxmoney(bro.getB_money());// 最高投标金额
		bro.setTb_minmoney(10000.0);// 最低投标金额
		bro.setBorrowqx(bro.getBorrowqx());// 借款期限
		bro.setBorrow_yt(bro.getBorrow_yt());// 借款用途
		String sex = null;
		if (SystemContant.tuser.getPsex().equals("男")) {
			sex = "先生";
		} else {
			sex = "女士";
		}
		// 林女士的车辆抵押借款
		bro.setBorrow_bt(SystemContant.tuser.getPname().substring(0, 1) + sex + "的" + bro.getBorrow_type() + "借款");// 借款标题
		bro.setBorrow_sm(bro.getBorrow_sm());// 借款说明
		bro.setBorrow_time(new Date());// 借款时间
		bro.setBorrow_type(bro.getBorrow_type());// 借款方式
		bro.setMbsj(new Date());// 满标时间
		bro.setRealreplay_time(new Date());// *最终还款日
		bro.setStatu("1");// 状态 1 审核中
		bro.setSfdxb("0");// 是否定向标 0 不是
		bro.setB_password("123");// 标密码
		bro.setTb_openmessage("1"); // 是否公开投标信息
		bro.setSucces_completion(0.00);// 完成百分比
		bro.setBorrow_fbtime(new Date());// *借款发布时间
		bro.setRepay_startime(new Date());// *还款开始时间
		bro.setRepay_lasttime(new Date());// *还款最后时间
		bro.setDbw(bro.getDbw());// 担保物
		bro.setDbx(bro.getDbx());// 担保项
		bro.setRelease_time(new Date());// *计划发布时间
		bro.setTid(bro.getTid());// 会员表主键id
		bro.setTname(SystemContant.tuser.getPname());
		bservice.Insertborrow(bro);
		// 插入消息
		Forengmessage fors = new Forengmessage();
		fors.setM_title("借款提交成功!请等待审核通过!");
		fors.setM_content("借款提交成功!请等待审核通过!");
		fors.setM_userid(SystemContant.tuser.getUserid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		return "redirect:../SelHuiKuan.action";
	}

	// 给我一个楼层。。 在index页面向用户展示贷款页 三个时间的查询
	@RequestMapping("selBorrowMoneySomeList")
	public String selBorrowMoneySomeList(Model model, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ltyue", 0);// 最小
		map.put("gtyue", 1);// 最大 最近一个月
		List<Borrowmoney2> list1 = bservice.selBorrowMoneySomeList(map);
		map.put("ltyue", 2);// 最小
		map.put("gtyue", 12);// 最大 1月~12月
		List<Borrowmoney2> list2 = bservice.selBorrowMoneySomeList(map);
		map.put("ltyue", 13);// 最小
		map.put("gtyue", 60);// 最大 12月~60月
		List<Borrowmoney2> list3 = bservice.selBorrowMoneySomeList(map);
		session.setAttribute("list1", list1);
		session.setAttribute("list2", list2);
		session.setAttribute("list3", list3);
		// 已开启的VIP团
		map.put("statu", "已开团");
		List<Borrowmoney> list4 = bservice.selectBorrowMoneyVip(map);
		session.setAttribute("vip", list4);
		List<Borrowmoney> list5 = bservice.selectBorrowMoneyZaiQuanstatu12();
		session.setAttribute("list5", list5);
		sumMoney(session);// 数据展示
		return "redirect:../foregroundSystem/index.jsp";
	}

	// 全部展示分页 部分数据
	@RequestMapping("selMoreBorrowMoneySomeList")
	public String selMoreBorrowMoneySomeList(Model model, @RequestParam(value = "cpage") Integer cpage) {
		Map<String, Object> map = bservice.selMoreBorrowMoneySomeList(cpage);
		model.addAttribute("map", map);
		return "../foregroundSystem/list.jsp";
	}

	// 全部展示分页 部分数据 有条件
	@RequestMapping("selMoreBorrowMoneySomeListWhere") // 条件有 贷款类型，贷款利率，期限，还款方式
	public String selMoreBorrowMoneySomeListWhere(Model model, @RequestParam(value = "cpage") Integer cpage,
			@RequestParam(value = "borrow_type", required = false) String borrow_type,
			@RequestParam(value = "rate", required = false) String rate,
			@RequestParam(value = "borrowqx", required = false) String borrowqx,
			@RequestParam(value = "repayment", required = false) String repayment,
			@RequestParam(value = "ratel", required = false) String ratel,
			@RequestParam(value = "rateg", required = false) String rateg) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (borrow_type != null && !borrow_type.equals("")) {
			if (borrow_type.equals("1")) {
				borrow_type = "车辆抵押";
			} else if (borrow_type.equals("2")) {
				borrow_type = "房产抵押";
			} else if (borrow_type.equals("3")) {
				borrow_type = "信用贷款";
			}
		}
		if (repayment != null && !repayment.equals("")) {
			if (repayment.equals("1")) {
				repayment = "等额本息";
			} else if (repayment.equals("2")) {
				repayment = "等额本金";
			}
		}
		map.put("borrow_type", borrow_type);
		map.put("borrowqx", borrowqx);
		map.put("repayment", repayment);
		map.put("cpage", cpage);
		map.put("ratel", ratel);
		map.put("rateg", rateg);
		Map<String, Object> map2 = bservice.selMoreBorrowMoneySomeListWhere(map);
		model.addAttribute("map", map2);
		return "../foregroundSystem/list.jsp";
	}

	// 获取一个数据。。。。
	@RequestMapping("getBorrowMoney")
	public String getBorrowMoney(Model model, @RequestParam(value = "id") String b_id) {
		Borrowmoney bor = bservice.getBorrowMoney(b_id);
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		if (SystemContant.tuser != null) {
			List<Ttzbank> ttzbs = ttzBankService.seluserBank(SystemContant.tuser.getUserid());
			model.addAttribute("ttzbs", ttzbs);// 当前登陆用户绑定的银行卡
		}
		People peo = peoservice.selectOnePeopleForIDcard(bor.getTid());
		Ziliao ziliao = zlservice.selectOneUserZiLiao(bor.getTid());
		model.addAttribute("peo", peo);// 借款人信息
		model.addAttribute("ziliao", ziliao);// 借款人认证信息
		model.addAttribute("bor", bor);// 借款详情
		model.addAttribute("Tenders", Tenders);// 所有投资
		return "../foregroundSystem/infor.jsp";
	}

	// 投资
	@RequestMapping("borrowTZ")
	public String borrowTZ(@RequestParam(value = "b_id") String b_id, @RequestParam(value = "tzje") Double tzje,
			@RequestParam(value = "zffs") String zffs, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 更改该条借款投资总额
		map.put("tzje", tzje);
		map.put("myid", SystemContant.tuser.getUserid());
		map.put("p_b_id", b_id);
		map.put("sjbh", new Random().nextInt());
		// 判断是用什么支付的 扣取费用
		if (zffs.equals("余额支付")) {// 余额支付
			map.put("zffs", 1);
			map.put("tzcard", 0 + "");
		} else {// 银行卡支付
			String tzcard = zffs.split(",")[0];// 银行卡号
			map.put("zffs", 2);
			map.put("tzcard", tzcard);
		}
		bservice.goBorrowmoneyTZ(map);
		// 查询用户
		Ttzuser user = ttzuserservice.Login(SystemContant.tuser.getUsername(), SystemContant.tuser.getPwd());
		session.setAttribute("user", user);
		// 插入投资成功消息!
		Forengmessage fors = new Forengmessage();
		fors.setM_title("投资成功!");
		fors.setM_content("投资成功!");
		fors.setM_userid(SystemContant.tuser.getUserid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		return "redirect:getBorrowMoney.action?id=" + b_id;
	}

	@RequestMapping("selBorrowMB")
	public String selBorrowMB(Model model) {
		List mblist = bservice.selBorrowMoneymb();
		model.addAttribute("mblist", mblist);
		return "../backgroundSystem/manbiao.jsp";
	}

	@RequestMapping("updMBstatu") // 更改借款状态 满标发钱 (后台来的方法)
	public String updMBstatu(@RequestParam(value = "statu") String statu, @RequestParam(value = "id") String id) {
		Map map = new HashMap();
		map.put("statu", statu);
		map.put("id", id);
		int i = bservice.updBorrowStatu(map);
		// 查出这笔借款
		Borrowmoney bro = bservice.selBorrowByid(id);
		// 插入消息
		Forengmessage fors = new Forengmessage();
		fors.setM_title("您的借款已经满标!");
		fors.setM_content("您的借款已经满标,系统即将将借款金额发放到您的余额!");
		fors.setM_userid(bro.getTid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		// 给自己加钱 并插入 /手续费/资金记录//更改最后还款时间//还款开始时间
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("b_id", bro.getB_id());
		map1.put("tid", bro.getTid());
		map1.put("manage_money", bro.getManage_money());
		map1.put("paid_money", bro.getPaid_money());
		ttzuserservice.updateTtzBorrowMoney(map1);
		// 生成还款计划
		if (bro.getRepayment().equals("等额本息")) {
			// 得到每月该还款
			Double myhk = BankRefund.interest_debx(bro.getB_money(), Double.parseDouble(bro.getRate()),
					Integer.parseInt(bro.getBorrowqx()));
			if (myhk != null && myhk > 0) {
				Calendar curr = Calendar.getInstance();
				for (int j = 1; j <= Integer.parseInt(bro.getBorrowqx()); j++) {
					DetailRepayment det = new DetailRepayment();
					det.setB_id(bro.getB_id());
					det.setPeriods(j);
					det.setRepay_interest(myhk - (bro.getB_money() * (Double.parseDouble(bro.getRate()) / 12)
							/ Integer.parseInt(bro.getBorrowqx())));// 本息
					det.setRepay_capital(myhk);
					det.setRepay_corpus((bro.getB_money() * (Double.parseDouble(bro.getRate()) / 12)
							/ Integer.parseInt(bro.getBorrowqx())));// 利息
					curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + 1); // 增加一月
					det.setRepay_date(curr.getTime());// 还款日期
					det.setRepay_status(0);// 未还款
					det.setActual_repay_date(new Date());// 实际还款时期
					det.setActual_repay_capital(0.00);// 实际还款本息
					dservice.insertReplayJH(det);
				}
			}
		} else if (bro.getRepayment().equals("等额本金")) {
			Map<String, Double> maps = BankRefund.principal_debj(bro.getB_money(), Double.parseDouble(bro.getRate()),
					Integer.parseInt(bro.getBorrowqx()));
			Calendar curr = Calendar.getInstance();
			for (int j = 1; j <= maps.size(); j++) {
				Double myyhbx = maps.get(j + "");// 每月本息
				Double monthPri = bro.getB_money() / Integer.parseInt(bro.getBorrowqx());// 每月本金
				Double mybx = myyhbx - monthPri;
				DetailRepayment det = new DetailRepayment();
				det.setB_id(bro.getB_id());
				det.setPeriods(j);
				det.setRepay_interest(mybx);
				det.setRepay_capital(myyhbx);
				det.setRepay_corpus(monthPri);
				curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + 1); // 增加一月
				det.setRepay_date(curr.getTime());// 还款日期
				det.setRepay_status(0);// 未还款
				det.setActual_repay_date(new Date());// 实际还款时期
				det.setActual_repay_capital(0.00);// 实际还款本息
				dservice.insertReplayJH(det);
			}
		}
		return "redirect:selBorrowMB.action";
	}

	// 查看还款计划
	@RequestMapping("SeeMyDetailRepayment") // 更改借款状态
	public String SeeMyDetailRepayment(@RequestParam(value = "b_id") String b_id, Model model) {
		List<DetailRepayment> dets = dservice.SeeMyDetailRepayment(b_id);
		Double ljhk = 0.00;// 累计还款
		Double yhk = 0.00;// 应还款
		for (DetailRepayment detailRepayment : dets) {
			if (detailRepayment.getRepay_status() == 1) {
				ljhk += detailRepayment.getRepay_capital();
			}
			yhk += detailRepayment.getRepay_capital();
		}
		List<Ttzbank> ttzbs = ttzBankService.seluserBank(SystemContant.tuser.getUserid());
		model.addAttribute("ttzbs", ttzbs);// 当前登陆用户绑定的银行卡
		model.addAttribute("dets", dets);
		model.addAttribute("ljhk", ljhk);
		model.addAttribute("yhk", yhk);
		return "../foregroundSystem/personal_jiekuanjilu_huankuanjh.jsp";
	}

	@RequestMapping("Tohuankuan") // 还款
	public String Tohuankuan(@RequestParam(value = "b_id") String b_id, @RequestParam(value = "zffs") String zffs,
			@RequestParam(value = "repay_money") String repay_money, @RequestParam(value = "repay_id") String repay_id,
			@RequestParam(value = "hkqs") Integer hkqs) {
		Map<String, Object> map = new HashMap<String, Object>();
		// System.out.println("repay_money:" + repay_money);
		// System.out.println("repay_id:" + repay_id);
		// System.out.println("b_id:" + b_id);
		// System.out.println("zffs:" + zffs);
		// 查出该条借款信息
		Borrowmoney bor = bservice.getBorrowMoney(b_id);
		map.put("userid", SystemContant.tuser.getUserid());
		map.put("money", SystemContant.tuser.getMoney());
		map.put("sjbh", new Random().nextInt());
		map.put("b_id", b_id);// 借款表主键
		map.put("repay_money", repay_money);// 本次还款的钱
		map.put("repay_id", repay_id);// 还款表的主键
		if (zffs.equals("余额支付")) {// 余额支付
			map.put("zffs", 1);
		} else {// 银行卡支付
			String tzcard = zffs.split(",")[0];// 银行卡号
			map.put("zffs", 2);
			map.put("tzcard", tzcard);
			map.put("tzcardye", zffs.split(",")[1]);
		}
		bservice.Tohuankuang(map);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 按期给投资人收益
		// 查出所有投资人
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		for (TenderRecord tenderRecord : Tenders) {
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("userid", tenderRecord.getTender_name());
			map2.put("sjbh", new Random().nextInt());
			if (bor.getRepayment().equals("等额本金")) {
				Map<String, Double> maps = BankRefund.principal_debj(tenderRecord.getTender_money(),
						Double.parseDouble(bor.getRate()), Integer.parseInt(bor.getBorrowqx()));
				// System.out.println("投资了:" + tenderRecord.getTender_money());
				for (int i = 1; i <= maps.size(); i++) {
					if (hkqs == i) {
						map2.put("sy_money", maps.get(i + ""));// 收益每月
						map2.put("sy_xq", bor.getBorrow_bt() + ",第" + i + "期收益");// 收益每月
						// System.out.println("每月收益:" + maps.get(i + ""));
					}
				}
			} else {// 等额本息
				// System.out.println("投资了:" + tenderRecord.getTender_money());
				Double doubles = BankRefund.interest_debx(tenderRecord.getTender_money(),
						Double.parseDouble(bor.getRate()), Integer.parseInt(bor.getBorrowqx()));
				map2.put("sy_money", doubles);// 收益每月
				map2.put("sy_xq", bor.getBorrow_bt() + ",第" + hkqs + "期收益");// 收益每月
				// System.out.println("每月收益:" + doubles);
			}
			bservice.TohuankuangSY(map2);
		}
		// 插入消息
		Forengmessage fors = new Forengmessage();
		fors.setM_title("还款成功!");
		fors.setM_content("还款成功!");
		fors.setM_userid(SystemContant.tuser.getUserid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		return "redirect:SeeMyDetailRepayment.action?b_id=" + b_id;
	}

	//////////////////////////////////////////////////////////////////////
	// 团团赚VIP团信息发布
	@RequestMapping("addVIPTuan")
	public String addVIPTuan(Borrowmoney bro) {

		bro.setRate(bro.getRate());// 年利率
		bro.setB_money(bro.getB_money());
		bro.setYx_time(bro.getYx_time());
		bro.setTb_minmoney(bro.getTb_minmoney());// 最低投标金额
		bro.setBorrow_bt(bro.getBorrow_bt());// 借款标题
		bro.setBorrow_sm(bro.getBorrow_sm());// 借款说明
		// 默认未开启
		System.out.println("满标额度:" + bro.getB_money());
		System.out.println("年利率:" + bro.getRate());
		System.out.println("vip过期时间:" + bro.getYx_time());
		System.out.println("最低起投金额:" + bro.getTb_minmoney());
		System.out.println("标题:" + bro.getBorrow_bt());
		System.out.println("说明:" + bro.getBorrow_sm());

		int i = bservice.InsertVipborrow(bro);

		return "redirect:SeeVIPTuan.action";
	}

	// 查看vip团
	@RequestMapping("SeeVIPTuan")
	public String SeeVIPTuan(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statu", "全部vip团");
		List<Borrowmoney> vips = bservice.selectBorrowMoneyVip(map);
		model.addAttribute("vip", vips);
		return "../backgroundSystem/VipList.jsp";
	}

	// 更改vip团的状态 10 开启 11 结束
	@RequestMapping("updateVipBorrowmoney")
	public String updateVipBorrowmoney(@RequestParam(value = "b_id") String b_id,
			@RequestParam(value = "statu") String statu) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statu", statu);
		map.put("b_id", b_id);
		bservice.updateVipBorrowmoney(map);

		return "redirect:SeeVIPTuan.action";
	}

	// vip团投资页
	@RequestMapping("getBorrowMoneyVIP")
	public String getBorrowMoneyVIP(Model model, @RequestParam(value = "id") String b_id) {
		Borrowmoney bor = bservice.getBorrowMoney(b_id);
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		if (SystemContant.tuser != null) {
			List<Ttzbank> ttzbs = ttzBankService.seluserBank(SystemContant.tuser.getUserid());
			model.addAttribute("ttzbs", ttzbs);// 当前登陆用户绑定的银行卡
		}
		model.addAttribute("bor", bor);// 借款详情
		model.addAttribute("Tenders", Tenders);// 所有投资
		return "../foregroundSystem/inforVip.jsp";
	}

	// Vip团投资
	@RequestMapping("borrowVIPTZ")
	public String borrowVIPTZ(@RequestParam(value = "b_id") String b_id, @RequestParam(value = "tzje") Double tzje,
			@RequestParam(value = "zffs") String zffs, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 更改该条借款投资总额
		map.put("tzje", tzje);
		map.put("myid", SystemContant.tuser.getUserid());
		map.put("p_b_id", b_id);
		map.put("sjbh", new Random().nextInt());
		// 判断是用什么支付的 扣取费用
		if (zffs.equals("余额支付")) {// 余额支付
			map.put("zffs", 1);
			map.put("tzcard", 0 + "");
		} else {// 银行卡支付
			String tzcard = zffs.split(",")[0];// 银行卡号
			map.put("zffs", 2);
			map.put("tzcard", tzcard);
		}
		// 投资VIP标
		bservice.goBorrowmoneyTZ(map);
		// 插入投资成功消息
		Forengmessage fors = new Forengmessage();
		fors.setM_title("投资成功!");
		fors.setM_content("投资成功!");
		fors.setM_userid(SystemContant.tuser.getUserid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		// 将投资金额分散投资于其它标
		// 1 .查找其它散标 剔除不符合的
		List<Borrowmoney> bros = bservice.selectBorrowMoneyOnStatu2();
		for (int i = 0; i < bros.size(); i++) {
			Borrowmoney bor = bros.get(i);
			if (bor.getB_money() - bor.getTb_money() < tzje) {
				bros.remove(i);
			}
		}
		// 2.将金额大小分成n份
		Double monit = SplitTzMoney.SplitMoney(tzje, bros.size());
		// 3.投资散标
		for (int i = 0; i < bros.size(); i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			Borrowmoney bor = bros.get(i);
			// 更改该条借款投资总额
			map1.put("tzje", monit);
			map1.put("myid", SystemContant.tuser.getUserid());
			map1.put("p_b_id", bor.getB_id());
			bservice.goBorrowmoneyVipTZ(map1);
			// 插入自动投资成功消息
			Forengmessage zdtz = new Forengmessage();
			zdtz.setM_title("自动投资成功!");
			zdtz.setM_content("自动投资成功!");
			zdtz.setM_userid(SystemContant.tuser.getUserid());
			zdtz.setM_type("1");
			zdtz.setM_statu("1");
			zdtz.setM_time(new Date());
			forservice.insertForengmessage(zdtz);
		}
		// 查询用户
		Ttzuser user = ttzuserservice.Login(SystemContant.tuser.getUsername(), SystemContant.tuser.getPwd());
		session.setAttribute("user", user);
		return "redirect:getBorrowMoneyVIP.action?id=" + b_id;
	}

	// 不要再删掉了啊，我写了三遍了。。。。。。。
	public void sumMoney(HttpSession session) {
		Double TenderMoney = tenderService.selTenderSumMoney();
		session.setAttribute("sumTenderMoney", TenderMoney);

		Double DetailMoney = dservice.selDetailMoney();
		session.setAttribute("sumDetailMoney", DetailMoney);

		int UserMoney = ttzuserservice.selUserMoney();
		session.setAttribute("sumUserMoney", UserMoney);

		int UserCount = ttzuserservice.selUserCount();
		session.setAttribute("UserCount", UserCount);
	}

	// 债权转让
	@RequestMapping("ZaiQuanZuanRang")
	public String ZaiQuanZuanRang(@RequestParam(value = "tender_id") String tender_id) {
		// 将投资状态改为债权转让中
		tenderService.updateTenderRecordstatu5(tender_id);
		TenderRecord ten = tenderService.selectOneTenderRecordForTender_id(tender_id);
		// 将转让信息生成成一个借款
		Borrowmoney bro = new Borrowmoney();
		bro.setRate(0.11 + "");// 年利率
		bro.setB_money(ten.getTender_money());
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.DAY_OF_MONTH, curr.get(Calendar.DAY_OF_MONTH) + 3);
		bro.setYx_time(curr.getTime());
		bro.setTb_minmoney(ten.getTender_money() / 2);// 最低投标金额
		bro.setDbx(tender_id);
		String sex = "";
		if (ten.getSex().equals("男")) {
			sex = "先生";
		} else {
			sex = "女士";
		}
		bro.setBorrow_bt(ten.getZsname().substring(0, 1) + sex + "债权抵押借款" + ten.getTender_money());// 借款标题
		bro.setBorrow_sm(ten.getZsname().substring(0, 1) + sex + "债权抵押借款" + ten.getTender_money());// 借款说明
		bro.setTid(ten.getTender_name());
		bro.setTname(ten.getZsname());

		int i = bservice.InsertZaiQuanborrow(bro);

		return "redirect:../TenderRecordCompletedStatuON0.action";
	}

	// 查看债权转让借款
	@RequestMapping("getBorrowMoneyZaiQuan")
	public String getBorrowMoneyZaiQuan(Model model, @RequestParam(value = "id") String b_id) {
		Borrowmoney bor = bservice.getBorrowMoney(b_id);
		TenderRecord ten = tenderService.selectOneTenderRecordForTender_id(bor.getDbx());
		Borrowmoney oldbro = bservice.getBorrowMoney(ten.getT_id());
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		if (SystemContant.tuser != null) {
			List<Ttzbank> ttzbs = ttzBankService.seluserBank(SystemContant.tuser.getUserid());
			model.addAttribute("ttzbs", ttzbs);// 当前登陆用户绑定的银行卡
		}
		Ziliao ziliao = zlservice.selectOneUserZiLiao(oldbro.getTid());
		People peo = peoservice.selectOnePeopleForIDcard(oldbro.getTid());
		model.addAttribute("peo", peo);// 借款人信息
		model.addAttribute("ziliao", ziliao);// 借款人认证信息
		model.addAttribute("bor", bor);// 借款详情
		model.addAttribute("Tenders", Tenders);// 所有投资
		model.addAttribute("ten", ten);// 债权转让信息
		model.addAttribute("oldbro", oldbro);// 债权借款
		return "../foregroundSystem/inforZaiQuan.jsp";
	}

	// 购买债权
	@RequestMapping("borrowZaiQuan")
	public String borrowZaiQuan(@RequestParam(value = "b_id") String b_id,
			@RequestParam(value = "old_b_id") String old_b_id, @RequestParam(value = "tzje") Double tzje,
			@RequestParam(value = "zffs") String zffs, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 更改该条借款投资总额
		map.put("tzje", tzje);
		map.put("myid", SystemContant.tuser.getUserid());
		map.put("p_b_id", b_id);
		map.put("sjbh", new Random().nextInt());
		// 判断是用什么支付的 扣取费用
		if (zffs.equals("余额支付")) {// 余额支付
			map.put("zffs", 1);
			map.put("tzcard", 0 + "");
		} else {// 银行卡支付
			String tzcard = zffs.split(",")[0];// 银行卡号
			map.put("zffs", 2);
			map.put("tzcard", tzcard);
		}
		// 投资债权转让原标
		map.put("old_b_id", old_b_id);
		bservice.goBorrowmoneyZaiquan(map);
		// 查询用户
		Ttzuser user = ttzuserservice.Login(SystemContant.tuser.getUsername(), SystemContant.tuser.getPwd());
		session.setAttribute("user", user);
		return "redirect:getBorrowMoneyZaiQuan.action?id=" + b_id;
	}

	// 后台查看投资。。。。
	@RequestMapping("backSelTZ")
	public String backSelTZ(Model model, @RequestParam(value = "id") String b_id) {
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		model.addAttribute("Tenders", Tenders);// 所有投资
		return "../backgroundSystem/borrow_list_tz.jsp";
	}

}
