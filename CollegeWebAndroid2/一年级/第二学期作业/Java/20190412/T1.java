package pack;

import java.util.Scanner;

public class T1 {
	static Bank ba = new Bank("招商银行");
	static String user, pwd;
	static double money;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ba.welcome();
		while(true){
			main_menu();
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					new_user();
					break;
				case 2:
					save_money();
					break;
				case 3:
					out_money();
					break;
				case 4:
					ba.tips();
					sc.close();
					return;
				default:
					System.out.println("你选择的业务有错，请重新输入：");
					break;
			}
		}
	}
	public static void new_user(){
		while(true){
			System.out.println("请输入用户名，交易密码，开户金额：");
			user = sc.next();
			pwd = sc.next();
			money = sc.nextDouble();
			if(money < 10 || user.equals("") || pwd.equals("")){
				System.out.println("输入数据有误，是否重新输入(y/n):");
				String con = sc.next();
				if(con.equals("n")){
					break;
				}
			}else{
				ba.newuser(user, pwd, money);
				break;
			}
		}
	}
	public static void main_menu(){
		System.out.println("请选择你要办理的业务：");
		System.out.println("1.开户");
		System.out.println("2.存款");
		System.out.println("3.取款");
		System.out.println("4.退出");
	}
	public static void save_money(){
		while(true){
			if(ba.u_name != null){
				System.out.println("请输入存款金额：");
				money = sc.nextDouble();
				if(money < 0){
					System.out.println("输入数据有误，是否重新输入(y/n):");
					String con = sc.next();
					if(con.equals("n")){
						break;
					}
				}else{
					ba.savemoney(money);
					break;
				}
			}else{
				System.out.println("请先开户");
				break;
			}
		}
	}
	public static void out_money(){
		String con;
		boolean continues = true;
		while(continues){
			if(ba.u_name != null){
				while(true){
					System.out.println("请输入交易密码：");
					pwd = sc.next();
					if(!pwd.equals(ba.u_pwd)){
						System.out.println("您输入的密码错误，是否重新输入(y/n):");
						con = sc.next();
						if(con.equals("n")){
							return;
						}
					}else{
						while(true){
							System.out.println("请输入取款金额：");
							money = sc.nextDouble();
							if(money > ba.u_rest){
								System.out.println("您的取款大于金额，是否重新输入(y/n):");
								con = sc.next();
								if(con.equals("n")){
									return;
								}
							}else if(money > ba.u_trans){
								System.out.println("您的取款大于交易金额，是否重新输入(y/n):");
								con = sc.next();
								if(con.equals("n")){
									return;
								}
							}else{
								ba.outmoney(money);
								return;
							}
						}
					}
				}
			}else{
				System.out.println("请先开户");
				break;
			}
		}
	}
}
class Bank{
	String b_name;
	String u_name;
	String u_pwd;
	double u_rest;// 余额
	double u_trans;// 交易额
	
	public Bank(String b_name){
		this.b_name = b_name;
	}
	// 欢迎
	public void welcome(){
		System.out.println("欢迎来到"+b_name+"-----------");
	}
	// 提醒
	public void tips(){
		System.out.println("请携带好随身财物，欢迎下次光临"+b_name+"-----------");
	}
	// 开户
	public void newuser(String name, String pwd, double money){
		this.u_name = name;
		this.u_pwd = pwd;
		this.u_rest = money - 10;
		this.u_trans = 10000;
		System.out.println(u_name+"开户成功，当前余额"+u_rest+"元");
	}
	// 存款
	public void savemoney(double money){
		this.u_rest += money;
		System.out.println("您的账户已存入"+money+"元，当前余额"+u_rest+"元");
	}
	// 取款
	public void outmoney(double money){
		this.u_rest -= money;
		System.out.println(u_name+"你好，您的账户已取出"+money+"元，当前余额"+u_rest+"元");
	}
}