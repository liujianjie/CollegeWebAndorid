package pack;

import java.util.Scanner;

public class T1 {
	static Bank ba = new Bank("��������");
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
					System.out.println("��ѡ���ҵ���д����������룺");
					break;
			}
		}
	}
	public static void new_user(){
		while(true){
			System.out.println("�������û������������룬������");
			user = sc.next();
			pwd = sc.next();
			money = sc.nextDouble();
			if(money < 10 || user.equals("") || pwd.equals("")){
				System.out.println("�������������Ƿ���������(y/n):");
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
		System.out.println("��ѡ����Ҫ�����ҵ��");
		System.out.println("1.����");
		System.out.println("2.���");
		System.out.println("3.ȡ��");
		System.out.println("4.�˳�");
	}
	public static void save_money(){
		while(true){
			if(ba.u_name != null){
				System.out.println("���������");
				money = sc.nextDouble();
				if(money < 0){
					System.out.println("�������������Ƿ���������(y/n):");
					String con = sc.next();
					if(con.equals("n")){
						break;
					}
				}else{
					ba.savemoney(money);
					break;
				}
			}else{
				System.out.println("���ȿ���");
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
					System.out.println("�����뽻�����룺");
					pwd = sc.next();
					if(!pwd.equals(ba.u_pwd)){
						System.out.println("���������������Ƿ���������(y/n):");
						con = sc.next();
						if(con.equals("n")){
							return;
						}
					}else{
						while(true){
							System.out.println("������ȡ���");
							money = sc.nextDouble();
							if(money > ba.u_rest){
								System.out.println("����ȡ����ڽ��Ƿ���������(y/n):");
								con = sc.next();
								if(con.equals("n")){
									return;
								}
							}else if(money > ba.u_trans){
								System.out.println("����ȡ����ڽ��׽��Ƿ���������(y/n):");
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
				System.out.println("���ȿ���");
				break;
			}
		}
	}
}
class Bank{
	String b_name;
	String u_name;
	String u_pwd;
	double u_rest;// ���
	double u_trans;// ���׶�
	
	public Bank(String b_name){
		this.b_name = b_name;
	}
	// ��ӭ
	public void welcome(){
		System.out.println("��ӭ����"+b_name+"-----------");
	}
	// ����
	public void tips(){
		System.out.println("��Я������������ӭ�´ι���"+b_name+"-----------");
	}
	// ����
	public void newuser(String name, String pwd, double money){
		this.u_name = name;
		this.u_pwd = pwd;
		this.u_rest = money - 10;
		this.u_trans = 10000;
		System.out.println(u_name+"�����ɹ�����ǰ���"+u_rest+"Ԫ");
	}
	// ���
	public void savemoney(double money){
		this.u_rest += money;
		System.out.println("�����˻��Ѵ���"+money+"Ԫ����ǰ���"+u_rest+"Ԫ");
	}
	// ȡ��
	public void outmoney(double money){
		this.u_rest -= money;
		System.out.println(u_name+"��ã������˻���ȡ��"+money+"Ԫ����ǰ���"+u_rest+"Ԫ");
	}
}