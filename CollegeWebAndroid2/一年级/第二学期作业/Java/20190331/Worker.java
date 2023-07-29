package pack;

public class Worker {
	String idcard;
	String name;
	char sex;
	int age;
	String jointime;
	float salary;
	float paris;
	float continuework;
	float phonecoast;
	float live;
	float transport;
	float zufang;

	public void Init() {
		this.idcard = "";
		this.name = "";
		this.sex = 'n';
		this.age = 0;
		this.jointime = "";
		this.salary = -1;
		this.paris = -1;
		this.continuework = -1;
		this.phonecoast = -1;
		this.transport = -1;
		this.live = -1;
		this.zufang = -1;
	}
	public Worker() {
		Init();
	}
	public Worker(String idcard, String name, char sex, int age, String jointime) {
		Init();
		this.idcard = idcard;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.jointime = jointime;
	}

	public Worker(float salary, float paris, float continuework,
			float phonecoast, float transport, float live, float zufang) {
		Init();
		this.salary = salary;
		this.paris = paris;
		this.continuework = continuework;
		this.phonecoast = phonecoast;
		this.transport = transport;
		this.live = live;
		this.zufang = zufang;
	}
	public Worker(String idcard, String name, char sex, int age, String jointime,float salary, float paris, float continuework,
			float phonecoast, float transport, float live, float zufang) {
		this.idcard = idcard;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.jointime = jointime;
		this.salary = salary;
		this.paris = paris;
		this.continuework = continuework;
		this.phonecoast = phonecoast;
		this.transport = transport;
		this.live = live;
		this.zufang = zufang;
	}
	public void print_Info() {
		String not = "δ֪";
		String st = "���֤��" + (idcard.equals("") ? not : idcard) + ",���֣�"
				+ (name.equals("") ? not : name) + "���Ա�"
				+ (sex == 'n' ? not : sex) + ",���䣺" + (age == 0 ? not : age)
				+ ",��ְʱ�䣺" + (jointime.equals("") ? not : jointime) + ",нˮ��"
				+ (salary == -1 ? not : salary) + ",����"
				+ (paris == -1 ? not : paris) + ",�Ӱ�ѣ�"
				+ (continuework == -1 ? not : continuework) + ",�绰�ѣ�"
				+ (phonecoast == -1 ? not : phonecoast) + ",����ѣ�"
				+ (live == -1 ? not : live) + ",��ͨ�ѣ�"
				+ (transport == -1 ? not : transport) + ",����ѣ�"
				+ (zufang == -1 ? not : zufang);
		System.out.println(st);
	}

	public float allpay() {
		return phonecoast + live + transport + zufang;
	}

	public float allshouru() {
		return (salary + paris + continuework) - allpay();
	}

	public static void main(String[] args) {
		Worker wo = new Worker();
		wo.print_Info();
		wo = new Worker("360732", "����", '��', 19, "2019��3��29��");
		wo.print_Info();
		wo = new Worker("360732", "����", '��', 19, "2019��3��29��", 3000, 1500, 300, 50, 200, 1000, 800);
		wo.print_Info();
		System.out.println("��֧��:" + wo.allpay());
		System.out.println("�����룺" + wo.allshouru());
	}
}
