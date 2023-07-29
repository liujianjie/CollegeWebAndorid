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

	@RequestMapping("selBorrowMoney") // ��ѯ�ҵ����н�ǰ̨��
	public String selBorrowMoney(Model model) {
		List<Borrowmoney> borrlist = bservice.selBorrow(SystemContant.tuser.getUserid());
		Double ljjk = 0.00;// �ۼ���Ϣ
		Double ljlx = 0.00;// �ۼƽ��
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

	@RequestMapping("selBorrowAll") // ��ѯ���н���̨��
	public String selBorrowTobk(Model model) {
		List<Borrowmoney> allborrow = bservice.selAllBorrow();
		model.addAttribute("allborrow", allborrow);
		return "../backgroundSystem/borrow.jsp";
	}

	@RequestMapping("updBorrowstatu") // ���Ľ��״̬
	public String updBorrowstatu(@RequestParam(value = "statu") String statu, @RequestParam(value = "id") String id) {
		Map map = new HashMap();
		map.put("statu", statu);
		map.put("id", id);
		int i = bservice.updBorrowStatu(map);
		Borrowmoney bro = bservice.selBorrowByid(id);
		if (statu.equals("2")) {// ͨ��
			// ������Ϣ
			Forengmessage fors = new Forengmessage();
			fors.setM_title("���Ľ�������Ѿ�ͨ��!");
			fors.setM_content("���Ľ�������Ѿ�ͨ��!");
			fors.setM_userid(bro.getTid());
			fors.setM_type("1");
			fors.setM_statu("1");
			fors.setM_time(new Date());
			forservice.insertForengmessage(fors);
		} else if (statu.equals("0")) {// ʧ��
			// ������Ϣ
			Forengmessage fors = new Forengmessage();
			fors.setM_title("���Ľ������ʧ��!");
			fors.setM_content("��ȷ�����������Ϣ�Ƿ�����!");
			fors.setM_userid(bro.getTid());
			fors.setM_type("1");
			fors.setM_statu("1");
			fors.setM_time(new Date());
			forservice.insertForengmessage(fors);
		}
		return "selBorrowAll.action";
	}

	@RequestMapping("selBorrowByid") // ��ѯ�������
	public String selBorrowByid(@RequestParam(value = "id") String id, Borrowmoney borrow, Model model) {
		borrow = bservice.selBorrowByid(id);
		model.addAttribute("borrow", borrow);
		return "../foregroundSystem/infor.jsp";
	}

	// ���
	@RequestMapping("BorrowMoney")
	public String BorrowMoney(Model model, Borrowmoney bro) {
		Integer borrowqx = Integer.parseInt(bro.getBorrowqx());// �������
		// ƥ����������������
		Double mange = 0.00;// �������
		List<Rates> rates = reteservice.selrateslist();
		Map<String, Object> ratemap = new HashMap<String, Object>();
		for (Rates rates2 : rates) {
			if (rates2.getR_name().equals("�������(��)")) {
				ratemap.put(rates2.getR_tiao() + "", rates2.getR_zhi());
			} else if (rates2.getR_name().equals("�������")) {
				mange = rates2.getR_zhi();
			}
		}
		Double rate = 0.00;
		if (borrowqx <= 1) {// С�ڵ���1��
			bro.setRate(ratemap.get("С�ڵ���1��") + "");
			rate = Double.parseDouble(ratemap.get("С�ڵ���1��") + "");
		} else if (borrowqx > 1 && borrowqx <= 12) {// ����1��С��12��
			bro.setRate(ratemap.get("����1��С��12��") + "");
			rate = Double.parseDouble(ratemap.get("����1��С��12��") + "");
		} else if (borrowqx > 12) {// ����12��
			bro.setRate(ratemap.get("����12��") + "");
			rate = Double.parseDouble(ratemap.get("����12��") + "");
		}

		// ƥ��������������
		List<FundraisingDeadline> listfun = funservice.FundraisingDeadlinelist();
		Map<String, Object> funmap = new HashMap<String, Object>();
		for (FundraisingDeadline fundraisingDeadline : listfun) {
			funmap.put(fundraisingDeadline.getJiekuantime() + "", fundraisingDeadline.getChoukuantime());
		}
		Calendar curr = Calendar.getInstance();
		if (borrowqx <= 6) {
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + Integer.parseInt(funmap.get("С��6����") + ""));
			bro.setYx_time(curr.getTime());
		} else if (borrowqx > 6 && borrowqx <= 12) {
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + Integer.parseInt(funmap.get("����6����С��12����") + ""));
			bro.setYx_time(curr.getTime());
		} else if (borrowqx > 12 && borrowqx < 24) {
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + Integer.parseInt(funmap.get("����12����С��24����") + ""));
			bro.setYx_time(curr.getTime());
		} else if (borrowqx > 24) {
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + Integer.parseInt(funmap.get("����24����") + ""));
			bro.setYx_time(curr.getTime());
		}
		// ���� Ӧ���������(�ֻ��ʽ)
		if (bro.getRepayment().equals("�ȶϢ")) {
			Double db = BankRefund.interest_debx(bro.getB_money(), rate, Integer.parseInt(bro.getBorrowqx()));
			bro.setShould_money(db * (Integer.parseInt(bro.getBorrowqx())));// Ӧ������
		} else if (bro.getRepayment().equals("�ȶ��")) {
			Map<String, Double> map = BankRefund.principal_debj(bro.getB_money(), rate,
					Integer.parseInt(bro.getBorrowqx()));
			Double zhk = 0.00;
			for (int i = 0; i < map.size(); i++) {
				Double dd = map.get((i + 1) + "");
				zhk += dd;
			}
			bro.setShould_money(zhk);// Ӧ������
		}
		bro.setB_money(bro.getB_money());
		bro.setManage_money(bro.getB_money() * mange);// �������
		bro.setPaid_money(bro.getB_money() - (bro.getB_money() * mange));// ʵ�ս��
		bro.setRepay_money(0.00);// �Ի�����
		bro.setCollection_money(0.00);// �տ��
		bro.setPrincipal_money(0.00);// �տ���Ϣ
		bro.setFine_money(0.00);// ����
		bro.setTb_money(0.00);// Ͷ���ܶ�
		bro.setTb_unreward("0");// ����Ͷ�꽱��
		bro.setTb_rewardtype("");// Ͷ�꽱������
		bro.setTb_reward("");// Ͷ�꽱��
		bro.setRepayment(bro.getRepayment());// ���ʽ
		bro.setTb_maxmoney(bro.getB_money());// ���Ͷ����
		bro.setTb_minmoney(10000.0);// ���Ͷ����
		bro.setBorrowqx(bro.getBorrowqx());// �������
		bro.setBorrow_yt(bro.getBorrow_yt());// �����;
		String sex = null;
		if (SystemContant.tuser.getPsex().equals("��")) {
			sex = "����";
		} else {
			sex = "Ůʿ";
		}
		// ��Ůʿ�ĳ�����Ѻ���
		bro.setBorrow_bt(SystemContant.tuser.getPname().substring(0, 1) + sex + "��" + bro.getBorrow_type() + "���");// ������
		bro.setBorrow_sm(bro.getBorrow_sm());// ���˵��
		bro.setBorrow_time(new Date());// ���ʱ��
		bro.setBorrow_type(bro.getBorrow_type());// ��ʽ
		bro.setMbsj(new Date());// ����ʱ��
		bro.setRealreplay_time(new Date());// *���ջ�����
		bro.setStatu("1");// ״̬ 1 �����
		bro.setSfdxb("0");// �Ƿ���� 0 ����
		bro.setB_password("123");// ������
		bro.setTb_openmessage("1"); // �Ƿ񹫿�Ͷ����Ϣ
		bro.setSucces_completion(0.00);// ��ɰٷֱ�
		bro.setBorrow_fbtime(new Date());// *����ʱ��
		bro.setRepay_startime(new Date());// *���ʼʱ��
		bro.setRepay_lasttime(new Date());// *�������ʱ��
		bro.setDbw(bro.getDbw());// ������
		bro.setDbx(bro.getDbx());// ������
		bro.setRelease_time(new Date());// *�ƻ�����ʱ��
		bro.setTid(bro.getTid());// ��Ա������id
		bro.setTname(SystemContant.tuser.getPname());
		bservice.Insertborrow(bro);
		// ������Ϣ
		Forengmessage fors = new Forengmessage();
		fors.setM_title("����ύ�ɹ�!��ȴ����ͨ��!");
		fors.setM_content("����ύ�ɹ�!��ȴ����ͨ��!");
		fors.setM_userid(SystemContant.tuser.getUserid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		return "redirect:../SelHuiKuan.action";
	}

	// ����һ��¥�㡣�� ��indexҳ�����û�չʾ����ҳ ����ʱ��Ĳ�ѯ
	@RequestMapping("selBorrowMoneySomeList")
	public String selBorrowMoneySomeList(Model model, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ltyue", 0);// ��С
		map.put("gtyue", 1);// ��� ���һ����
		List<Borrowmoney2> list1 = bservice.selBorrowMoneySomeList(map);
		map.put("ltyue", 2);// ��С
		map.put("gtyue", 12);// ��� 1��~12��
		List<Borrowmoney2> list2 = bservice.selBorrowMoneySomeList(map);
		map.put("ltyue", 13);// ��С
		map.put("gtyue", 60);// ��� 12��~60��
		List<Borrowmoney2> list3 = bservice.selBorrowMoneySomeList(map);
		session.setAttribute("list1", list1);
		session.setAttribute("list2", list2);
		session.setAttribute("list3", list3);
		// �ѿ�����VIP��
		map.put("statu", "�ѿ���");
		List<Borrowmoney> list4 = bservice.selectBorrowMoneyVip(map);
		session.setAttribute("vip", list4);
		List<Borrowmoney> list5 = bservice.selectBorrowMoneyZaiQuanstatu12();
		session.setAttribute("list5", list5);
		sumMoney(session);// ����չʾ
		return "redirect:../foregroundSystem/index.jsp";
	}

	// ȫ��չʾ��ҳ ��������
	@RequestMapping("selMoreBorrowMoneySomeList")
	public String selMoreBorrowMoneySomeList(Model model, @RequestParam(value = "cpage") Integer cpage) {
		Map<String, Object> map = bservice.selMoreBorrowMoneySomeList(cpage);
		model.addAttribute("map", map);
		return "../foregroundSystem/list.jsp";
	}

	// ȫ��չʾ��ҳ �������� ������
	@RequestMapping("selMoreBorrowMoneySomeListWhere") // ������ �������ͣ��������ʣ����ޣ����ʽ
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
				borrow_type = "������Ѻ";
			} else if (borrow_type.equals("2")) {
				borrow_type = "������Ѻ";
			} else if (borrow_type.equals("3")) {
				borrow_type = "���ô���";
			}
		}
		if (repayment != null && !repayment.equals("")) {
			if (repayment.equals("1")) {
				repayment = "�ȶϢ";
			} else if (repayment.equals("2")) {
				repayment = "�ȶ��";
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

	// ��ȡһ�����ݡ�������
	@RequestMapping("getBorrowMoney")
	public String getBorrowMoney(Model model, @RequestParam(value = "id") String b_id) {
		Borrowmoney bor = bservice.getBorrowMoney(b_id);
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		if (SystemContant.tuser != null) {
			List<Ttzbank> ttzbs = ttzBankService.seluserBank(SystemContant.tuser.getUserid());
			model.addAttribute("ttzbs", ttzbs);// ��ǰ��½�û��󶨵����п�
		}
		People peo = peoservice.selectOnePeopleForIDcard(bor.getTid());
		Ziliao ziliao = zlservice.selectOneUserZiLiao(bor.getTid());
		model.addAttribute("peo", peo);// �������Ϣ
		model.addAttribute("ziliao", ziliao);// �������֤��Ϣ
		model.addAttribute("bor", bor);// �������
		model.addAttribute("Tenders", Tenders);// ����Ͷ��
		return "../foregroundSystem/infor.jsp";
	}

	// Ͷ��
	@RequestMapping("borrowTZ")
	public String borrowTZ(@RequestParam(value = "b_id") String b_id, @RequestParam(value = "tzje") Double tzje,
			@RequestParam(value = "zffs") String zffs, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ���ĸ������Ͷ���ܶ�
		map.put("tzje", tzje);
		map.put("myid", SystemContant.tuser.getUserid());
		map.put("p_b_id", b_id);
		map.put("sjbh", new Random().nextInt());
		// �ж�����ʲô֧���� ��ȡ����
		if (zffs.equals("���֧��")) {// ���֧��
			map.put("zffs", 1);
			map.put("tzcard", 0 + "");
		} else {// ���п�֧��
			String tzcard = zffs.split(",")[0];// ���п���
			map.put("zffs", 2);
			map.put("tzcard", tzcard);
		}
		bservice.goBorrowmoneyTZ(map);
		// ��ѯ�û�
		Ttzuser user = ttzuserservice.Login(SystemContant.tuser.getUsername(), SystemContant.tuser.getPwd());
		session.setAttribute("user", user);
		// ����Ͷ�ʳɹ���Ϣ!
		Forengmessage fors = new Forengmessage();
		fors.setM_title("Ͷ�ʳɹ�!");
		fors.setM_content("Ͷ�ʳɹ�!");
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

	@RequestMapping("updMBstatu") // ���Ľ��״̬ ���귢Ǯ (��̨���ķ���)
	public String updMBstatu(@RequestParam(value = "statu") String statu, @RequestParam(value = "id") String id) {
		Map map = new HashMap();
		map.put("statu", statu);
		map.put("id", id);
		int i = bservice.updBorrowStatu(map);
		// �����ʽ��
		Borrowmoney bro = bservice.selBorrowByid(id);
		// ������Ϣ
		Forengmessage fors = new Forengmessage();
		fors.setM_title("���Ľ���Ѿ�����!");
		fors.setM_content("���Ľ���Ѿ�����,ϵͳ�����������ŵ��������!");
		fors.setM_userid(bro.getTid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		// ���Լ���Ǯ ������ /������/�ʽ��¼//������󻹿�ʱ��//���ʼʱ��
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("b_id", bro.getB_id());
		map1.put("tid", bro.getTid());
		map1.put("manage_money", bro.getManage_money());
		map1.put("paid_money", bro.getPaid_money());
		ttzuserservice.updateTtzBorrowMoney(map1);
		// ���ɻ���ƻ�
		if (bro.getRepayment().equals("�ȶϢ")) {
			// �õ�ÿ�¸û���
			Double myhk = BankRefund.interest_debx(bro.getB_money(), Double.parseDouble(bro.getRate()),
					Integer.parseInt(bro.getBorrowqx()));
			if (myhk != null && myhk > 0) {
				Calendar curr = Calendar.getInstance();
				for (int j = 1; j <= Integer.parseInt(bro.getBorrowqx()); j++) {
					DetailRepayment det = new DetailRepayment();
					det.setB_id(bro.getB_id());
					det.setPeriods(j);
					det.setRepay_interest(myhk - (bro.getB_money() * (Double.parseDouble(bro.getRate()) / 12)
							/ Integer.parseInt(bro.getBorrowqx())));// ��Ϣ
					det.setRepay_capital(myhk);
					det.setRepay_corpus((bro.getB_money() * (Double.parseDouble(bro.getRate()) / 12)
							/ Integer.parseInt(bro.getBorrowqx())));// ��Ϣ
					curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + 1); // ����һ��
					det.setRepay_date(curr.getTime());// ��������
					det.setRepay_status(0);// δ����
					det.setActual_repay_date(new Date());// ʵ�ʻ���ʱ��
					det.setActual_repay_capital(0.00);// ʵ�ʻ��Ϣ
					dservice.insertReplayJH(det);
				}
			}
		} else if (bro.getRepayment().equals("�ȶ��")) {
			Map<String, Double> maps = BankRefund.principal_debj(bro.getB_money(), Double.parseDouble(bro.getRate()),
					Integer.parseInt(bro.getBorrowqx()));
			Calendar curr = Calendar.getInstance();
			for (int j = 1; j <= maps.size(); j++) {
				Double myyhbx = maps.get(j + "");// ÿ�±�Ϣ
				Double monthPri = bro.getB_money() / Integer.parseInt(bro.getBorrowqx());// ÿ�±���
				Double mybx = myyhbx - monthPri;
				DetailRepayment det = new DetailRepayment();
				det.setB_id(bro.getB_id());
				det.setPeriods(j);
				det.setRepay_interest(mybx);
				det.setRepay_capital(myyhbx);
				det.setRepay_corpus(monthPri);
				curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + 1); // ����һ��
				det.setRepay_date(curr.getTime());// ��������
				det.setRepay_status(0);// δ����
				det.setActual_repay_date(new Date());// ʵ�ʻ���ʱ��
				det.setActual_repay_capital(0.00);// ʵ�ʻ��Ϣ
				dservice.insertReplayJH(det);
			}
		}
		return "redirect:selBorrowMB.action";
	}

	// �鿴����ƻ�
	@RequestMapping("SeeMyDetailRepayment") // ���Ľ��״̬
	public String SeeMyDetailRepayment(@RequestParam(value = "b_id") String b_id, Model model) {
		List<DetailRepayment> dets = dservice.SeeMyDetailRepayment(b_id);
		Double ljhk = 0.00;// �ۼƻ���
		Double yhk = 0.00;// Ӧ����
		for (DetailRepayment detailRepayment : dets) {
			if (detailRepayment.getRepay_status() == 1) {
				ljhk += detailRepayment.getRepay_capital();
			}
			yhk += detailRepayment.getRepay_capital();
		}
		List<Ttzbank> ttzbs = ttzBankService.seluserBank(SystemContant.tuser.getUserid());
		model.addAttribute("ttzbs", ttzbs);// ��ǰ��½�û��󶨵����п�
		model.addAttribute("dets", dets);
		model.addAttribute("ljhk", ljhk);
		model.addAttribute("yhk", yhk);
		return "../foregroundSystem/personal_jiekuanjilu_huankuanjh.jsp";
	}

	@RequestMapping("Tohuankuan") // ����
	public String Tohuankuan(@RequestParam(value = "b_id") String b_id, @RequestParam(value = "zffs") String zffs,
			@RequestParam(value = "repay_money") String repay_money, @RequestParam(value = "repay_id") String repay_id,
			@RequestParam(value = "hkqs") Integer hkqs) {
		Map<String, Object> map = new HashMap<String, Object>();
		// System.out.println("repay_money:" + repay_money);
		// System.out.println("repay_id:" + repay_id);
		// System.out.println("b_id:" + b_id);
		// System.out.println("zffs:" + zffs);
		// ������������Ϣ
		Borrowmoney bor = bservice.getBorrowMoney(b_id);
		map.put("userid", SystemContant.tuser.getUserid());
		map.put("money", SystemContant.tuser.getMoney());
		map.put("sjbh", new Random().nextInt());
		map.put("b_id", b_id);// ��������
		map.put("repay_money", repay_money);// ���λ����Ǯ
		map.put("repay_id", repay_id);// ����������
		if (zffs.equals("���֧��")) {// ���֧��
			map.put("zffs", 1);
		} else {// ���п�֧��
			String tzcard = zffs.split(",")[0];// ���п���
			map.put("zffs", 2);
			map.put("tzcard", tzcard);
			map.put("tzcardye", zffs.split(",")[1]);
		}
		bservice.Tohuankuang(map);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// ���ڸ�Ͷ��������
		// �������Ͷ����
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		for (TenderRecord tenderRecord : Tenders) {
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("userid", tenderRecord.getTender_name());
			map2.put("sjbh", new Random().nextInt());
			if (bor.getRepayment().equals("�ȶ��")) {
				Map<String, Double> maps = BankRefund.principal_debj(tenderRecord.getTender_money(),
						Double.parseDouble(bor.getRate()), Integer.parseInt(bor.getBorrowqx()));
				// System.out.println("Ͷ����:" + tenderRecord.getTender_money());
				for (int i = 1; i <= maps.size(); i++) {
					if (hkqs == i) {
						map2.put("sy_money", maps.get(i + ""));// ����ÿ��
						map2.put("sy_xq", bor.getBorrow_bt() + ",��" + i + "������");// ����ÿ��
						// System.out.println("ÿ������:" + maps.get(i + ""));
					}
				}
			} else {// �ȶϢ
				// System.out.println("Ͷ����:" + tenderRecord.getTender_money());
				Double doubles = BankRefund.interest_debx(tenderRecord.getTender_money(),
						Double.parseDouble(bor.getRate()), Integer.parseInt(bor.getBorrowqx()));
				map2.put("sy_money", doubles);// ����ÿ��
				map2.put("sy_xq", bor.getBorrow_bt() + ",��" + hkqs + "������");// ����ÿ��
				// System.out.println("ÿ������:" + doubles);
			}
			bservice.TohuankuangSY(map2);
		}
		// ������Ϣ
		Forengmessage fors = new Forengmessage();
		fors.setM_title("����ɹ�!");
		fors.setM_content("����ɹ�!");
		fors.setM_userid(SystemContant.tuser.getUserid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		return "redirect:SeeMyDetailRepayment.action?b_id=" + b_id;
	}

	//////////////////////////////////////////////////////////////////////
	// ����׬VIP����Ϣ����
	@RequestMapping("addVIPTuan")
	public String addVIPTuan(Borrowmoney bro) {

		bro.setRate(bro.getRate());// ������
		bro.setB_money(bro.getB_money());
		bro.setYx_time(bro.getYx_time());
		bro.setTb_minmoney(bro.getTb_minmoney());// ���Ͷ����
		bro.setBorrow_bt(bro.getBorrow_bt());// ������
		bro.setBorrow_sm(bro.getBorrow_sm());// ���˵��
		// Ĭ��δ����
		System.out.println("������:" + bro.getB_money());
		System.out.println("������:" + bro.getRate());
		System.out.println("vip����ʱ��:" + bro.getYx_time());
		System.out.println("�����Ͷ���:" + bro.getTb_minmoney());
		System.out.println("����:" + bro.getBorrow_bt());
		System.out.println("˵��:" + bro.getBorrow_sm());

		int i = bservice.InsertVipborrow(bro);

		return "redirect:SeeVIPTuan.action";
	}

	// �鿴vip��
	@RequestMapping("SeeVIPTuan")
	public String SeeVIPTuan(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statu", "ȫ��vip��");
		List<Borrowmoney> vips = bservice.selectBorrowMoneyVip(map);
		model.addAttribute("vip", vips);
		return "../backgroundSystem/VipList.jsp";
	}

	// ����vip�ŵ�״̬ 10 ���� 11 ����
	@RequestMapping("updateVipBorrowmoney")
	public String updateVipBorrowmoney(@RequestParam(value = "b_id") String b_id,
			@RequestParam(value = "statu") String statu) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statu", statu);
		map.put("b_id", b_id);
		bservice.updateVipBorrowmoney(map);

		return "redirect:SeeVIPTuan.action";
	}

	// vip��Ͷ��ҳ
	@RequestMapping("getBorrowMoneyVIP")
	public String getBorrowMoneyVIP(Model model, @RequestParam(value = "id") String b_id) {
		Borrowmoney bor = bservice.getBorrowMoney(b_id);
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		if (SystemContant.tuser != null) {
			List<Ttzbank> ttzbs = ttzBankService.seluserBank(SystemContant.tuser.getUserid());
			model.addAttribute("ttzbs", ttzbs);// ��ǰ��½�û��󶨵����п�
		}
		model.addAttribute("bor", bor);// �������
		model.addAttribute("Tenders", Tenders);// ����Ͷ��
		return "../foregroundSystem/inforVip.jsp";
	}

	// Vip��Ͷ��
	@RequestMapping("borrowVIPTZ")
	public String borrowVIPTZ(@RequestParam(value = "b_id") String b_id, @RequestParam(value = "tzje") Double tzje,
			@RequestParam(value = "zffs") String zffs, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ���ĸ������Ͷ���ܶ�
		map.put("tzje", tzje);
		map.put("myid", SystemContant.tuser.getUserid());
		map.put("p_b_id", b_id);
		map.put("sjbh", new Random().nextInt());
		// �ж�����ʲô֧���� ��ȡ����
		if (zffs.equals("���֧��")) {// ���֧��
			map.put("zffs", 1);
			map.put("tzcard", 0 + "");
		} else {// ���п�֧��
			String tzcard = zffs.split(",")[0];// ���п���
			map.put("zffs", 2);
			map.put("tzcard", tzcard);
		}
		// Ͷ��VIP��
		bservice.goBorrowmoneyTZ(map);
		// ����Ͷ�ʳɹ���Ϣ
		Forengmessage fors = new Forengmessage();
		fors.setM_title("Ͷ�ʳɹ�!");
		fors.setM_content("Ͷ�ʳɹ�!");
		fors.setM_userid(SystemContant.tuser.getUserid());
		fors.setM_type("1");
		fors.setM_statu("1");
		fors.setM_time(new Date());
		forservice.insertForengmessage(fors);
		// ��Ͷ�ʽ���ɢͶ����������
		// 1 .��������ɢ�� �޳������ϵ�
		List<Borrowmoney> bros = bservice.selectBorrowMoneyOnStatu2();
		for (int i = 0; i < bros.size(); i++) {
			Borrowmoney bor = bros.get(i);
			if (bor.getB_money() - bor.getTb_money() < tzje) {
				bros.remove(i);
			}
		}
		// 2.������С�ֳ�n��
		Double monit = SplitTzMoney.SplitMoney(tzje, bros.size());
		// 3.Ͷ��ɢ��
		for (int i = 0; i < bros.size(); i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			Borrowmoney bor = bros.get(i);
			// ���ĸ������Ͷ���ܶ�
			map1.put("tzje", monit);
			map1.put("myid", SystemContant.tuser.getUserid());
			map1.put("p_b_id", bor.getB_id());
			bservice.goBorrowmoneyVipTZ(map1);
			// �����Զ�Ͷ�ʳɹ���Ϣ
			Forengmessage zdtz = new Forengmessage();
			zdtz.setM_title("�Զ�Ͷ�ʳɹ�!");
			zdtz.setM_content("�Զ�Ͷ�ʳɹ�!");
			zdtz.setM_userid(SystemContant.tuser.getUserid());
			zdtz.setM_type("1");
			zdtz.setM_statu("1");
			zdtz.setM_time(new Date());
			forservice.insertForengmessage(zdtz);
		}
		// ��ѯ�û�
		Ttzuser user = ttzuserservice.Login(SystemContant.tuser.getUsername(), SystemContant.tuser.getPwd());
		session.setAttribute("user", user);
		return "redirect:getBorrowMoneyVIP.action?id=" + b_id;
	}

	// ��Ҫ��ɾ���˰�����д�������ˡ�������������
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

	// ծȨת��
	@RequestMapping("ZaiQuanZuanRang")
	public String ZaiQuanZuanRang(@RequestParam(value = "tender_id") String tender_id) {
		// ��Ͷ��״̬��ΪծȨת����
		tenderService.updateTenderRecordstatu5(tender_id);
		TenderRecord ten = tenderService.selectOneTenderRecordForTender_id(tender_id);
		// ��ת����Ϣ���ɳ�һ�����
		Borrowmoney bro = new Borrowmoney();
		bro.setRate(0.11 + "");// ������
		bro.setB_money(ten.getTender_money());
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.DAY_OF_MONTH, curr.get(Calendar.DAY_OF_MONTH) + 3);
		bro.setYx_time(curr.getTime());
		bro.setTb_minmoney(ten.getTender_money() / 2);// ���Ͷ����
		bro.setDbx(tender_id);
		String sex = "";
		if (ten.getSex().equals("��")) {
			sex = "����";
		} else {
			sex = "Ůʿ";
		}
		bro.setBorrow_bt(ten.getZsname().substring(0, 1) + sex + "ծȨ��Ѻ���" + ten.getTender_money());// ������
		bro.setBorrow_sm(ten.getZsname().substring(0, 1) + sex + "ծȨ��Ѻ���" + ten.getTender_money());// ���˵��
		bro.setTid(ten.getTender_name());
		bro.setTname(ten.getZsname());

		int i = bservice.InsertZaiQuanborrow(bro);

		return "redirect:../TenderRecordCompletedStatuON0.action";
	}

	// �鿴ծȨת�ý��
	@RequestMapping("getBorrowMoneyZaiQuan")
	public String getBorrowMoneyZaiQuan(Model model, @RequestParam(value = "id") String b_id) {
		Borrowmoney bor = bservice.getBorrowMoney(b_id);
		TenderRecord ten = tenderService.selectOneTenderRecordForTender_id(bor.getDbx());
		Borrowmoney oldbro = bservice.getBorrowMoney(ten.getT_id());
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		if (SystemContant.tuser != null) {
			List<Ttzbank> ttzbs = ttzBankService.seluserBank(SystemContant.tuser.getUserid());
			model.addAttribute("ttzbs", ttzbs);// ��ǰ��½�û��󶨵����п�
		}
		Ziliao ziliao = zlservice.selectOneUserZiLiao(oldbro.getTid());
		People peo = peoservice.selectOnePeopleForIDcard(oldbro.getTid());
		model.addAttribute("peo", peo);// �������Ϣ
		model.addAttribute("ziliao", ziliao);// �������֤��Ϣ
		model.addAttribute("bor", bor);// �������
		model.addAttribute("Tenders", Tenders);// ����Ͷ��
		model.addAttribute("ten", ten);// ծȨת����Ϣ
		model.addAttribute("oldbro", oldbro);// ծȨ���
		return "../foregroundSystem/inforZaiQuan.jsp";
	}

	// ����ծȨ
	@RequestMapping("borrowZaiQuan")
	public String borrowZaiQuan(@RequestParam(value = "b_id") String b_id,
			@RequestParam(value = "old_b_id") String old_b_id, @RequestParam(value = "tzje") Double tzje,
			@RequestParam(value = "zffs") String zffs, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ���ĸ������Ͷ���ܶ�
		map.put("tzje", tzje);
		map.put("myid", SystemContant.tuser.getUserid());
		map.put("p_b_id", b_id);
		map.put("sjbh", new Random().nextInt());
		// �ж�����ʲô֧���� ��ȡ����
		if (zffs.equals("���֧��")) {// ���֧��
			map.put("zffs", 1);
			map.put("tzcard", 0 + "");
		} else {// ���п�֧��
			String tzcard = zffs.split(",")[0];// ���п���
			map.put("zffs", 2);
			map.put("tzcard", tzcard);
		}
		// Ͷ��ծȨת��ԭ��
		map.put("old_b_id", old_b_id);
		bservice.goBorrowmoneyZaiquan(map);
		// ��ѯ�û�
		Ttzuser user = ttzuserservice.Login(SystemContant.tuser.getUsername(), SystemContant.tuser.getPwd());
		session.setAttribute("user", user);
		return "redirect:getBorrowMoneyZaiQuan.action?id=" + b_id;
	}

	// ��̨�鿴Ͷ�ʡ�������
	@RequestMapping("backSelTZ")
	public String backSelTZ(Model model, @RequestParam(value = "id") String b_id) {
		List<TenderRecord> Tenders = bservice.selectTenderRecordForT_ID(b_id);
		model.addAttribute("Tenders", Tenders);// ����Ͷ��
		return "../backgroundSystem/borrow_list_tz.jsp";
	}

}
